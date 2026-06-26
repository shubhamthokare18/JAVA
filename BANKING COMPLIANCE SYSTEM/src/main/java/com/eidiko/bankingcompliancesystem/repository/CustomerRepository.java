package com.eidiko.bankingcompliancesystem.repository;

import com.eidiko.bankingcompliancesystem.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
