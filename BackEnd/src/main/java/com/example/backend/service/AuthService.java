package com.example.backend.service;

import com.example.backend.dto.LoginRequest;
import com.example.backend.dto.RegisterRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public ResponseEntity<?> login(LoginRequest loginRequest) {
        String role = authenticateUser(loginRequest.getUsername(), loginRequest.getPassword());
        if (role != null) {
            return ResponseEntity.ok(role);
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }

    public ResponseEntity<?> register(RegisterRequest registerRequest) {
        // Implement registration logic here
        return ResponseEntity.ok("Registration successful");
    }

    private String authenticateUser(String username, String password) {
        // Dummy authentication logic
        if ("user".equals(username) && "password".equals(password)) {
            return "user";
        } else if ("designer".equals(username) && "password".equals(password)) {
            return "designer";
        } else if ("admin".equals(username) && "password".equals(password)) {
            return "admin";
        }
        return null;
    }
}