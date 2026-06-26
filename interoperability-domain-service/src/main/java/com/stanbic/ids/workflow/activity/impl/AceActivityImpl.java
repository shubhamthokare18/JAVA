package com.stanbic.ids.workflow.activity.impl;

import com.stanbic.ids.client.ace.WalletFeignClient;
import com.stanbic.ids.dto.request.wallet.TransactionInquiryRequest;
import com.stanbic.ids.dto.request.wallet.WalletTransferRequest;
import com.stanbic.ids.dto.request.wallet.WalletValidationRequest;
import com.stanbic.ids.dto.response.wallet.TransactionInquiryResponse;
import com.stanbic.ids.dto.response.wallet.WalletTransferResponse;
import com.stanbic.ids.dto.response.wallet.WalletValidationResponse;
import com.stanbic.ids.workflow.activity.AceActivity;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AceActivityImpl implements AceActivity {

    private final WalletFeignClient client;

    @Override
    @CircuitBreaker(name = "aceActivity", fallbackMethod = "walletValidationFallback")
    public WalletValidationResponse walletValdation(String emiType,
                                                    WalletValidationRequest request) {

        return client.validate(emiType, request);

    }

    public WalletValidationResponse walletValidationFallback(String emiType,
                                                             WalletValidationRequest request,
                                                             Exception ex) {

        throw new RuntimeException("ACE wallet validation unavailable");

    }

    @Override
    public WalletTransferResponse walletTransfer(String emiType, WalletTransferRequest request) {

        return client.transfer(emiType, request);

    }

    @Override
    public TransactionInquiryResponse transactionInquiry(String emiType,
                                                         TransactionInquiryRequest request) {

        return client.inquiry(emiType, request);

    }

}
