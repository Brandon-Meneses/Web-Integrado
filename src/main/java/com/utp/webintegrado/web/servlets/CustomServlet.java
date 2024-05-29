package com.utp.webintegrado.web.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.utp.webintegrado.persistence.entity.LibroEntity;
import com.utp.webintegrado.persistence.repository.LibroPaginSortRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.io.IOException;
import java.util.List;

public class CustomServlet extends HttpServlet {

    private LibroPaginSortRepository libroRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void init() throws ServletException {
        super.init();
        WebApplicationContext springContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        if (springContext != null) {
            libroRepository = springContext.getBean(LibroPaginSortRepository.class);
        } else {
            throw new IllegalStateException("Spring context is not initialized");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<LibroEntity> libros = libroRepository.findAll();
        String librosJson = objectMapper.writeValueAsString(libros);

        resp.setContentType("application/json");
        resp.getWriter().write(librosJson);
    }

}