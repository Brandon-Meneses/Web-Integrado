package com.utp.webintegrado.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class LibroServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp, "POST");
    }

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp, String method) throws ServletException, IOException {
        String titulo = req.getParameter("titulo");
        String autor = req.getParameter("autor");
        String isbn = req.getParameter("isbn");
        String editorial = req.getParameter("editorial");
        int anioPublicacion = Integer.parseInt(req.getParameter("anioPublicacion"));
        int stockTotal = Integer.parseInt(req.getParameter("stockTotal"));
        String descripcion = req.getParameter("descripcion");

        if (titulo == null || titulo.isEmpty() || autor == null || autor.isEmpty() || isbn == null || isbn.isEmpty() || editorial == null || editorial.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write("Los parámetros no son correctos");
            return;
        }

        URL url = new URL("http://localhost:8080/api/libro");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod(method);
        conn.setRequestProperty("Content-Type", "application/json");

        String input = String.format("{\"titulo\":\"%s\", \"autor\":\"%s\", \"isbn\":\"%s\", \"editorial\":\"%s\", \"anioPublicacion\":%d, \"stockTotal\":%d, \"descripcion\":\"%s\"}", titulo, autor, isbn, editorial, anioPublicacion, stockTotal, descripcion);

        OutputStream os = conn.getOutputStream();
        os.write(input.getBytes());
        os.flush();

        if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
            throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
        }

        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().write("OK");

        conn.disconnect();
    }
}