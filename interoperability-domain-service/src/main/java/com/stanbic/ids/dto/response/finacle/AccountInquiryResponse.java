package com.stanbic.ids.dto.response.finacle;

import lombok.Data;

@Data
public class AccountInquiryResponse {

    private String requestId;
    private String status;
    private String accountNumber;
    private String currency;
    private String customerId;
    private String customerName;

}
