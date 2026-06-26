package com.eidiko.bankingcompliancesystem.feign;

import com.eidiko.bankingcompliancesystem.entity.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "customer-service")
public interface CustomerClient {

    @GetMapping("/customer")
    List<Customer> getCustomer();
}
