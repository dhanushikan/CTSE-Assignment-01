package com.example.authservice.util;

import io.jsonwebtoken.Jwts;

import java.util.Date;
import java.security.Key;

public class JwtUtil {

    // Generate a key using HS256 algorithm (no need for Keys class)
    private Key secretKey = Jwts.SIG.HS256.key().build();

    public String generateToken(String username) {
        return Jwts.builder()
                .subject(username)  // Modern builder-style for subject
                .issuedAt(new Date())  // Modern builder-style for issuedAt
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hours expiration
                .signWith(secretKey)  // Signing with the secret key
                .compact();
    }
}
