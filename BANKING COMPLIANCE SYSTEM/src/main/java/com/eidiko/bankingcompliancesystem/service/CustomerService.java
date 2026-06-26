package com.eidiko.bankingcompliancesystem.service;

import com.eidiko.bankingcompliancesystem.entity.Customer;
import com.eidiko.bankingcompliancesystem.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repo;

    public Customer save(Customer customer) {
        log.info("Saving customer with name: {}", customer.getName());
        return repo.save(customer);
    }

    public Optional<Customer> getById(Long id) {
        log.info("Fetching customer with id: {}", id);
        return repo.findById(id);
    }

    public List<Customer> getAll() {
        log.info("Fetching all customers");
        return repo.findAll();
    }

    public Customer update(Long id, Customer customer) {
        log.info("Updating customer with id: {}", id);
        if (repo.existsById(id)) {
            customer.setId(id);
            return repo.save(customer);
        }
        return null;
    }

    public void delete(Long id) {
        log.info("Deleting customer with id: {}", id);
        repo.deleteById(id);
    }

    public void logExample() {
        log.info("Customer service called");
    }
}
