package com.eidiko.bankingcompliancesystem.config;

import com.eidiko.bankingcompliancesystem.entity.Customer;
import com.eidiko.bankingcompliancesystem.entity.FraudCase;
import com.eidiko.bankingcompliancesystem.entity.User;
import com.eidiko.bankingcompliancesystem.repository.CustomerRepository;
import com.eidiko.bankingcompliancesystem.repository.FraudRepository;
import com.eidiko.bankingcompliancesystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Initial data loader for development/testing
 */
@Slf4j
@Configuration
@RequiredArgsConstructor
public class DataInitializationConfig {

    @Bean
    public CommandLineRunner initializeData(
            UserRepository userRepository,
            CustomerRepository customerRepository,
            FraudRepository fraudRepository,
            PasswordEncoder passwordEncoder) {
        return args -> {
            // Create default admin user
            if (userRepository.findByUsername("admin").isEmpty()) {
                User admin = new User();
                admin.setUsername("admin");
                admin.setPassword(passwordEncoder.encode("admin123")); // Encode password
                admin.setRole("ADMIN");
                userRepository.save(admin);
                log.info("✓ Admin user created with username: admin");
            }

            // Create test customers
            if (customerRepository.findAll().isEmpty()) {
                Customer customer1 = new Customer();
                customer1.setName("John Doe");
                customer1.setCountry("USA");
                customerRepository.save(customer1);

                Customer customer2 = new Customer();
                customer2.setName("Jane Smith");
                customer2.setCountry("UK");
                customerRepository.save(customer2);
                log.info("✓ Test customers created");
            }

            // Create test fraud cases
            if (fraudRepository.findAll().isEmpty()) {
                FraudCase fraudCase = new FraudCase();
                fraudCase.setStatus("PENDING");
                fraudCase.setDescription("Suspicious transaction detected");
                fraudRepository.save(fraudCase);
                log.info("✓ Test fraud case created");
            }
        };
    }
}



