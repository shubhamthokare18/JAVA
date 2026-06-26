package com.stanbic.ids.dto.request.finacle;

import lombok.Data;

@Data
public class AccountInquiryRequest {

    private String requestId;
    private String channelId;
    private String accountNumber;

}
