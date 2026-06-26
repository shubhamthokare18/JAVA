package com.eidiko.bankingcompliancesystem.repository;

import com.eidiko.bankingcompliancesystem.entity.FraudCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudRepository extends JpaRepository<FraudCase, Long> {
}
