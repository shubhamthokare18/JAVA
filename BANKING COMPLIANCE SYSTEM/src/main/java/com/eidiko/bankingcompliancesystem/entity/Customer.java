package com.eidiko.bankingcompliancesystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private String name;
    private String country;
}
