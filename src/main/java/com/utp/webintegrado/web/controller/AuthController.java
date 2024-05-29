package com.utp.webintegrado.web.controller;

import com.utp.webintegrado.service.dto.LoginDto;
import com.utp.webintegrado.web.config.JwtUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody LoginDto loginDto){

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getContrasena());
        Authentication authentication = authenticationManager.authenticate(token);

        System.out.println(authentication.isAuthenticated());
        System.out.println(authentication.getPrincipal());

        String jwt =  this.jwtUtil.create(loginDto.getEmail());

        return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, "Bearer " + jwt).build();
    }
}
