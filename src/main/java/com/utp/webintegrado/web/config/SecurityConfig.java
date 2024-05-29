package com.utp.webintegrado.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .cors().and()
            .authorizeHttpRequests()

            .requestMatchers( "/api/auth/**").permitAll()

            .requestMatchers(HttpMethod.GET,  "/api/usuario/**").hasRole("ADMIN")

            .requestMatchers(HttpMethod.GET, "/api/**", "/api/auth/**","/api/ollama").permitAll()
            .requestMatchers("/swagger-ui/**", "/v3/api-docs/**", "/swagger-resources/**").permitAll()

            // Permisos para el rol ADMIN
            .requestMatchers(HttpMethod.GET, "/api/adquisicion/**", "/api/libro/**", "/api/stock_sucursal/**", "/api/sucursal/**", "/api/transferencia/**", "/api/usuario/**", "/api/ollama/**").hasRole("ADMIN")
            .requestMatchers(HttpMethod.POST, "/api/adquisicion/**", "/api/libro/**", "/api/stock_sucursal/**", "/api/sucursal/**", "/api/transferencia/**", "/api/usuario/**", "/api/ollama/**").hasRole("ADMIN")
            .requestMatchers(HttpMethod.PUT, "/api/adquisicion/**", "/api/libro/**", "/api/stock_sucursal/**", "/api/sucursal/**", "/api/transferencia/**", "/api/usuario/**", "/api/ollama/**").hasRole("ADMIN")
            .requestMatchers(HttpMethod.DELETE, "/api/adquisicion/**", "/api/libro/**", "/api/stock_sucursal/**", "/api/sucursal/**", "/api/transferencia/**", "/api/usuario/**", "/api/ollama/**").hasRole("ADMIN")

            // Permisos para el rol BIBLIOTERARIO
            .requestMatchers(HttpMethod.GET, "/api/transferencia/**", "/api/libro/**", "/api/stock_sucursal/**").hasRole("BIBLIOTERARIO")
            .requestMatchers(HttpMethod.POST, "/api/transferencia/**", "/api/libro/**", "/api/stock_sucursal/**").hasRole("BIBLIOTERARIO")
            .requestMatchers(HttpMethod.PUT, "/api/transferencia/**", "/api/libro/**", "/api/stock_sucursal/**").hasRole("BIBLIOTERARIO")
            .requestMatchers(HttpMethod.DELETE, "/api/transferencia/**", "/api/libro/**", "/api/stock_sucursal/**").hasRole("BIBLIOTERARIO")

            .anyRequest().authenticated()
            .and()
            .httpBasic();
        return http.build();
    }



    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }


                                                       @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
