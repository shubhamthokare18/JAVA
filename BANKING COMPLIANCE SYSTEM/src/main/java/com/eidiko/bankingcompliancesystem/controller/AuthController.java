package com.eidiko.bankingcompliancesystem.controller;

import com.eidiko.bankingcompliancesystem.dto.LoginRequest;
import com.eidiko.bankingcompliancesystem.dto.LoginResponse;
import com.eidiko.bankingcompliancesystem.entity.User;
import com.eidiko.bankingcompliancesystem.security.JwtUtil;
import com.eidiko.bankingcompliancesystem.service.AuthService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "Authentication", description = "Authentication endpoints")
public class AuthController {

    private final JwtUtil jwtUtil;
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        log.info("Login request for user: {}", loginRequest.getUsername());
        
        // Authenticate user
        Optional<User> user = authService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());
        
        if (user.isPresent()) {
            // Generate JWT token
            String token = jwtUtil.generateToken(user.get().getUsername());
            LoginResponse response = LoginResponse.builder()
                    .token(token)
                    .message("✓ Login successful")
                    .expiresIn(3600000) // 1 hour
                    .build();
            log.info("✓ User logged in successfully: {}", loginRequest.getUsername());
            return ResponseEntity.ok(response);
        } else {
            log.warn("✗ Login failed for user: {}", loginRequest.getUsername());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new AuthErrorResponse("✗ Invalid username or password"));
        }
    }

    public static class AuthErrorResponse {
        public String error;

        public AuthErrorResponse(String error) {
            this.error = error;
        }

        public String getError() {
            return error;
        }
    }
}
