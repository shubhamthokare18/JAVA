package com.stanbic.ids.dto.response.wallet;

import lombok.Data;

@Data
public class WalletValidationResponse {

    private String success;
    private String requestId;
    private Account account;
    private CustomData customData;
    private Customer customer;

}
