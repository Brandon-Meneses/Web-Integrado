package com.utp.webintegrado.ollama;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import org.json.JSONObject;
import org.json.JSONTokener;


import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
public class OllamaService {


    public String executeSql(String sql) {

        if (!sql.trim().endsWith(";")) {
            sql += ";";
        }

        StringBuilder result = new StringBuilder();
        try {
            String dbUrl = "jdbc:mysql://localhost:3306/Gestor-Libreria-WebIntegrado";
            String username = "root";
            String password = "root";

            Connection conn = DriverManager.getConnection(dbUrl, username, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();

            while (rs.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    String columnValue = rs.getString(i);
                    result.append(columnValue + " ");
                }
                result.append("\n");
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            return "No se pudo obtener la respuesta de la base de datos, query generada incorrecta o no hay data para: " + sql;
        }

        return result.toString();
    }

    public String generateSql(OllamaRequest request) {
        try {
            URL url = new URL("http://localhost:11434/api/generate");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);

            String jsonInputString = "{"
                    + "\"model\":\"" + request.getModel_SQL() + "\","
                    + "\"system\":\"" + request.getSystem() + "\","
                    + "\"prompt\":\"" + request.getPrompt() + "\""
                    + "}";

            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            StringBuilder sql = new StringBuilder();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))) {
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    JSONObject json = new JSONObject(new JSONTokener(responseLine));
                    sql.append(json.getString("response"));
                }
            }

            System.out.println(sql.toString());
            return sql.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public String generateExplanation(OllamaRequest request) {

        // Simula la ejecución de SQL y obtiene la respuesta de la base de datos
        String dbResponse = "{"+ executeSql(generateSql(request)) +"}";

        System.out.println("Respuesta consultada: "+ dbResponse);


        HttpURLConnection conn = null;
        BufferedReader br = null;
        try {
            URL url = new URL("http://localhost:11434/v1/chat/completions");
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);

            String jsonInputString = "{"
                + "\"model\":\"" + request.getModel_Chat() + "\","
                + "\"messages\":["
                + "{\"role\":\"assistant\","
                + "\"content\":\"Usuario pregunta a la base de datos: " + request.getPrompt() + "\\n"
                + "y se obtuvo la siguiente respuesta de la base de datos: " + dbResponse.replace("\n", "\\n") + "\\n"
                + ". Brinda una respuesta concisa y breve como asistente.\"}"
                + "]"
                + "}";

            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            StringBuilder response = new StringBuilder();
            br = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                JSONObject json = new JSONObject(new JSONTokener(responseLine));
                response.append(json.getJSONArray("choices").getJSONObject(0).getJSONObject("message").getString("content"));
            }

            String responseStr = response.toString();
            System.out.println(responseStr);
            request.setResponse_SQL(responseStr);
            return responseStr;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
            try {
                if (br != null) {
                    br.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}