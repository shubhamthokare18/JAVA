package com.stanbic.ids.dto.request.wallet;

import lombok.Data;

@Data
public class WalletValidationRequest {

    private String requestId;
    private String accountHoldingInstitutionIdentifier;
    private String getAccountHoldingInstitutionIdentifierType;

}
