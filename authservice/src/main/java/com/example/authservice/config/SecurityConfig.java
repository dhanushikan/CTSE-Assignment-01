package com.example.authservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())  // Disable CSRF protection
            .authorizeHttpRequests(authz -> authz
                .requestMatchers("/api/auth/signup", "/api/auth/login").permitAll() // Allow signup/login without authentication
                .anyRequest().authenticated() // Secure other requests
            )
            .formLogin(form -> form // Configure form login
                .permitAll()
            );
        return http.build();
    }
}
