package com.stanbic.ids;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableConfigurationProperties
public class InteroperabilityDomainServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InteroperabilityDomainServiceApplication.class, args);
	}

}
