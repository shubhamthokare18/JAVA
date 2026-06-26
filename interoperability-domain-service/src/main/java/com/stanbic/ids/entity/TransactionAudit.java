package com.stanbic.ids.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaction_audit", schema = "ids_schema")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String request_id;
    private String correlationId;
    private String apiName;
    private String status;
    private String transactionReference;
    private BigDecimal amount;
    private LocalDateTime createdAt;

}
