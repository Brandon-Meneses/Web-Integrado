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


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
public class OllamaService {


    public String executeSql(String sql) {
        String result = "";
        try {
            // Cambia estos detalles de conexión según tu configuración
            String dbUrl = "jdbc:mysql://localhost:3306/Gestor-Libreria-WebIntegrado";
            String username = "root";
            String password = "root";

            // Crea una conexión a la base de datos
            Connection conn = DriverManager.getConnection(dbUrl, username, password);

            // Crea un Statement para ejecutar la consulta SQL
            Statement stmt = conn.createStatement();

            // Ejecuta la consulta SQL y obtén el ResultSet
            ResultSet rs = stmt.executeQuery(sql);

            // Procesa el ResultSet y construye el resultado como String
            while (rs.next()) {
                // Asume que estás obteniendo un resultado de tipo String
                // Cambia esto según los datos que estés consultando
                result += rs.getString(1) + "\n";
            }

            // Cierra el ResultSet y el Statement
            rs.close();
            stmt.close();

            // Cierra la conexión
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
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

    private String formatDbResponse(String dbResponse) {
        // Usa una expresión regular para extraer la fecha de la respuesta de la base de datos
        Pattern pattern = Pattern.compile("\\|\\s*(\\d{4}-\\d{2}-\\d{2})\\s*\\|");
        Matcher matcher = pattern.matcher(dbResponse);
        if (matcher.find()) {
            return matcher.group(1); // Devuelve solo la fecha
        } else {
            return "No se encontró una respuesta válida"; // Maneja el caso donde no se encuentra la fecha
        }
    }


    public String generateExplanation(OllamaRequest request) {

        // Simula la ejecución de SQL y obtiene la respuesta de la base de datos
        String dbResponse = executeSql(generateSql(request));

        System.out.println(dbResponse);

        // Limpia y formatea la respuesta de la base de datos
        String formattedDbResponse = formatDbResponse(dbResponse);

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
                    + "\"content\":\"usuario pregunta a la base de datos: " + request.getPrompt() + "\\n"
                    + "y se obtuvo como respuesta: " + formattedDbResponse + "\\n"
                    + "brinda una respuesta concisa y breve como asistente.\"}"
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