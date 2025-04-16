package com.example.authservice.controller;

import com.example.authservice.model.User;
import com.example.authservice.repository.UserRepository;
import com.example.authservice.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    // POST /api/auth/signup
    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody User user) {
        // Save the user in the repository
        userRepository.save(user);

        // Return response with 201 Created status
        return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully!");
    }

    // POST /api/auth/login
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        // Find user by username
        User existingUser = userRepository.findByUsername(user.getUsername());
        
        // Check if user exists and passwords match
        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            // Generate JWT token for the user
            String token = jwtUtil.generateToken(user.getUsername());
            
            // Return token in the response with 200 OK status
            return ResponseEntity.ok("Bearer " + token);
        }

        // Return 401 Unauthorized if credentials are invalid
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials!");
    }
}
