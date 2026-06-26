package com.stanbic.ids.client.ace;

import com.stanbic.ids.dto.request.wallet.TransactionInquiryRequest;
import com.stanbic.ids.dto.request.wallet.WalletTransferRequest;
import com.stanbic.ids.dto.request.wallet.WalletValidationRequest;
import com.stanbic.ids.dto.response.wallet.TransactionInquiryResponse;
import com.stanbic.ids.dto.response.wallet.WalletTransferResponse;
import com.stanbic.ids.dto.response.wallet.WalletValidationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "wallet-client", url = "${ace.base-url}")
public interface WalletFeignClient {

    @PostMapping("${ace.wallet-validation}")
    WalletValidationResponse validate(@RequestHeader("emiType") String emiType,
                                      @RequestBody WalletValidationRequest request);

    @PostMapping("${ace.wallet-transfer}")
    WalletTransferResponse transfer(@RequestHeader("emiType") String emiType,
                                    @RequestBody WalletTransferRequest request);

    @PostMapping("${ace.transaction-inquiry}")
    TransactionInquiryResponse inquiry(@RequestHeader("emiType") String emiType,
                                       @RequestBody TransactionInquiryRequest request);

}
