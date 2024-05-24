package com.utp.webintegrado.web.config;

import com.utp.webintegrado.web.servlets.CustomServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletConfig {

    @Bean
    public ServletRegistrationBean<CustomServlet> exampleServletBean() {
        ServletRegistrationBean<CustomServlet> bean = new ServletRegistrationBean<>(
                new CustomServlet(), "/custom-servlet");
        return bean;
    }
}