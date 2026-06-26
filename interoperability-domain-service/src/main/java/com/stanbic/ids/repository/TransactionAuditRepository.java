package com.stanbic.ids.repository;

import com.stanbic.ids.entity.TransactionAudit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionAuditRepository extends JpaRepository<TransactionAudit, Long> {
}
