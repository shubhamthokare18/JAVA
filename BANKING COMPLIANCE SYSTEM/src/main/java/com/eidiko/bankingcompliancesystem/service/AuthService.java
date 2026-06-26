package com.eidiko.bankingcompliancesystem.service;

import com.eidiko.bankingcompliancesystem.entity.User;
import com.eidiko.bankingcompliancesystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public Optional<User> authenticate(String username, String password) {
        log.info("Authenticating user: {}", username);
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            // Use PasswordEncoder to verify password
            if (passwordEncoder.matches(password, user.get().getPassword())) {
                log.info("✓ User authenticated successfully: {}", username);
                return user;
            } else {
                log.warn("✗ Invalid password for user: {}", username);
            }
        } else {
            log.warn("✗ User not found: {}", username);
        }
        return Optional.empty();
    }

    public User register(User user) {
        log.info("Registering new user: {}", user.getUsername());
        // Encode password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
