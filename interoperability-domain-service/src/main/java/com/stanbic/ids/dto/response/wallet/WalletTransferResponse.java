package com.stanbic.ids.dto.response.wallet;

import com.stanbic.ids.dto.KeyValueDto;
import lombok.Data;

import java.util.List;

@Data
public class WalletTransferResponse {

    private String success;
    private String requestId;
    private List<KeyValueDto> customData;
    private String descriptionText;
    private String transactionReference;

}
