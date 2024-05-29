package com.utp.webintegrado.web.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

import java.util.concurrent.TimeUnit;

@Component
public class JwtUtil {

    private static String SECRET_KEY = "webintegrado-libreria";
    private static Algorithm ALGORITMO  = Algorithm.HMAC256(SECRET_KEY);

    public String create(String email){
        return JWT.create()
                .withSubject(email)
                .withIssuer("webintegrado")
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(1)))
                .sign(ALGORITMO);
    }

    public Boolean verifyJwt(String jwtoken){
        try {
            JWT.require(ALGORITMO).build().verify(jwtoken);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public String getEmail(String jwtoken){
        return JWT.require(ALGORITMO)
                .build()
                .verify(jwtoken)
                .getSubject();
    }
}
