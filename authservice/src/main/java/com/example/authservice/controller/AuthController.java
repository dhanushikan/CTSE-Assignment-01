package com.example.authservice.controller;

import com.example.authservice.model.User;
import com.example.authservice.repository.UserRepository;
import com.example.authservice.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String signup(@RequestBody User user) {
        userRepository.save(user);
        return "User created successfully!";
    }

    // POST /api/auth/login
    @PostMapping("/login")
    public String login(@RequestBody User user) {
        User existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            String token = jwtUtil.generateToken(user.getUsername());
            return "Bearer " + token;
        }
        return "Invalid credentials!";
    }
}
