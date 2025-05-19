package com.example.demo.Controllers;

import com.example.demo.Models.User;
import com.example.demo.CustomUserDetailsService;
import com.example.demo.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager; // To authenticate user

    @Autowired
    private CustomUserDetailsService customUserDetailsService; // Custom user details service

    @Autowired
    private JwtService jwtService; // JWT utility to generate token

    // Login endpoint
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User loginUser) {
        try {
            // Authenticate the user
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword())
            );

            // Generate JWT token if authentication is successful
            String token = jwtService.generateToken(authentication);

            // Return the JWT token in the response body
            return ResponseEntity.ok().body(new LoginResponse(token)); // Wrap the token in a response DTO

        } catch (Exception e) {
            // Return error if authentication fails
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }

    // A DTO class to wrap the token in the response
    public static class LoginResponse {
        private String token;

        public LoginResponse(String token) {
            this.token = token;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
