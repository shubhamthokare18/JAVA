package com.eidiko.bankingcompliancesystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FraudCaseDto {
    private Long id;
    private String status;
    private String description;
}
