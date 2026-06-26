package com.eidiko.bankingcompliancesystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class FraudCase {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "Status is required")
    private String status;
    
    @NotBlank(message = "Description is required")
    private String description;
}
