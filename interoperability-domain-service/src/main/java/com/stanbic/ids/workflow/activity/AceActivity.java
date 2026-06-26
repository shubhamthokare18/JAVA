package com.stanbic.ids.workflow.activity;

import com.stanbic.ids.dto.request.wallet.TransactionInquiryRequest;
import com.stanbic.ids.dto.request.wallet.WalletTransferRequest;
import com.stanbic.ids.dto.request.wallet.WalletValidationRequest;
import com.stanbic.ids.dto.response.wallet.TransactionInquiryResponse;
import com.stanbic.ids.dto.response.wallet.WalletTransferResponse;
import com.stanbic.ids.dto.response.wallet.WalletValidationResponse;

public interface AceActivity {

    WalletValidationResponse walletValdation(String emiType, WalletValidationRequest request);

    WalletTransferResponse walletTransfer(String emiType, WalletTransferRequest request);

    TransactionInquiryResponse transactionInquiry(String emiType,
                                                  TransactionInquiryRequest request);

}
