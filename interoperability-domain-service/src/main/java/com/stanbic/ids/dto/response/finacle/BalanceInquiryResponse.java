package com.stanbic.ids.dto.response.finacle;

import lombok.Data;

@Data
public class BalanceInquiryResponse {

    private String requestId;
    private String status;
    private Double clearedBalance;
    private Double availableBalance;

}
