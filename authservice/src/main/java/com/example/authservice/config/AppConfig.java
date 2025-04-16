package com.example.authservice.config;

import com.example.authservice.util.JwtUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public JwtUtil jwtUtil() {
        return new JwtUtil();  // Create and return a new instance of JwtUtil
    }
}
