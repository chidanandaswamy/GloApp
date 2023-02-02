package com.GlobalApp.Authentication.Utile;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {

    @Value("${app.secret}")
    private String secret;


    public String generateToken(String subject)
    {
        return Jwts.builder()
                .setSubject(subject)
                .setIssuer("chidu")
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+TimeUnit.MINUTES.toMillis(15)))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();

    }
    public Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secret.getBytes())
                .parseClaimsJws(token)
                .getBody();
    }


}
