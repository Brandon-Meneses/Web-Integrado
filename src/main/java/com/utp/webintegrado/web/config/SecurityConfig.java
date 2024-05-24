package com.utp.webintegrado.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // desactiva la protección antiafalsificación de solicitudes csrf (no para producción)
                .cors().and() // habilita la configuración de cors, por defecto no permite que otros dominios accedan a la aplicación
                .authorizeHttpRequests()
                .requestMatchers("/swagger-ui.html", "/swagger-ui/**", "/v3/api-docs/**", "/swagger-resources/**").permitAll() // permite todas las solicitudes a estas rutas
                .anyRequest().authenticated() // cualquier otra solicitud debe estar autenticada
                .and()
                .httpBasic(); // debe ser autenticado con http basic
        return http.build();
    }
}
