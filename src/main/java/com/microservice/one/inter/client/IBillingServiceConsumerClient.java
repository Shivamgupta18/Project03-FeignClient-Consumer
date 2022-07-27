package com.microservice.one.inter.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("MS-Producer")
public interface IBillingServiceConsumerClient {
	@GetMapping("/billing/api/info")
	public ResponseEntity<String> fetchBillingInfo();
}
