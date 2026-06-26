package com.stanbic.ids.client.ace;

import com.stanbic.ids.dto.request.finacle.AccountInquiryRequest;
import com.stanbic.ids.dto.request.finacle.BalanceInquiryRequest;
import com.stanbic.ids.dto.response.finacle.AccountInquiryResponse;
import com.stanbic.ids.dto.response.finacle.BalanceInquiryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "finacle-client", url = "${ace.base-url}")
public interface FinacleFeignClient {

    @PostMapping("${ace.account-inquiry}")
    AccountInquiryResponse accountInquiry(@RequestBody AccountInquiryRequest request);

    @PostMapping("${ace.balance-inquiry}")
    BalanceInquiryResponse balanceInquiry(@RequestBody BalanceInquiryRequest request);

}
