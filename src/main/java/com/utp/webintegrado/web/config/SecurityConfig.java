package com.utp.webintegrado.web.config;
/*
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // hace que sea un bean que pueda autogestionar e inyectar dentro de la aplicación
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChange(HttpSecurity http) throws Exception { // Permite configurar la seguridad de la aplicación
        http
                .csrf().disable() // desactiva la protección antiafalsificación de solicitudes csrf (no para producción)
                .cors().and() // habilita la configuración de cors, por defecto no permite que otros dominios accedan a la aplicación
                .authorizeHttpRequests() // autoriza las solicitudes http
                .anyRequest() // cualquier solicitud
                .authenticated() // debe estar autenticado
                .and() // y
                .httpBasic(); // debe ser autenticado con http basic
        return http.build();
    }
}
*/