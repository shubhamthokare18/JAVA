package com.eidiko.bankingcompliancesystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BankingComplianceSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingComplianceSystemApplication.class, args);
	}

}
