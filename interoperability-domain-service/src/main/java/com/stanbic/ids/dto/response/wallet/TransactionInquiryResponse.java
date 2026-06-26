package com.stanbic.ids.dto.response.wallet;

import com.stanbic.ids.dto.KeyValueDto;
import lombok.Data;

import java.util.List;

@Data
public class TransactionInquiryResponse {

    private String success;
    private String requestId;
    private String status;
    private String amount;
    private String creationDate;
    private String transactionReference;
    private String message;
    private List<KeyValueDto> customData;

}
