package com.stanbic.ids.dto.request.wallet;

import com.stanbic.ids.dto.KeyValueDto;
import lombok.Data;

import java.util.List;

@Data
public class WalletTransferRequest {

    private String requestId;
    private String amount;
    private String originalTransactionReference;
    private List<KeyValueDto> creditParty;
    private List<KeyValueDto> debitParty;
    private String descriptionText;

}
