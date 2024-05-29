package com.utp.webintegrado.web.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        //1 validando que es un header de autorizacion valido
        String authoHeather = request.getHeader(HttpHeaders.AUTHORIZATION);

        if(authoHeather == null || authoHeather.isEmpty() || !authoHeather.startsWith("Bearer ")){
            filterChain.doFilter(request, response);
            return;
        }
        //2 validar que el jwt sea valido
        String jwt = authoHeather.replace("Bearer ", "");

        //3 cargar el usuario del userdetailservice
        //4 cargar al usuario en el contexto de seguridad


    }
}
