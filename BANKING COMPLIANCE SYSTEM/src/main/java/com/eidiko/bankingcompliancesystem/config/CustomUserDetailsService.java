package com.eidiko.bankingcompliancesystem.config;

import com.eidiko.bankingcompliancesystem.entity.User;
import com.eidiko.bankingcompliancesystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

/**
 * Custom UserDetailsService that loads user credentials from the database
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.debug("Loading user details for username: {}", username);
        
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> {
                    log.warn("User not found: {}", username);
                    return new UsernameNotFoundException("User not found with username: " + username);
                });

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                getAuthorities(user.getRole())
        );
    }

    private Collection<? extends GrantedAuthority> getAuthorities(String role) {
        if (role == null || role.isEmpty()) {
            return Collections.emptyList();
        }
        // Add ROLE_ prefix if not already present
        String roleWithPrefix = role.startsWith("ROLE_") ? role : "ROLE_" + role;
        return Collections.singletonList(new SimpleGrantedAuthority(roleWithPrefix));
    }
}

