package com.microservice.one.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.one.inter.client.IBillingServiceConsumerClient;

@RestController
@RequestMapping("/shopping/api")
public class ShoppingServiceOperationController {
	@Autowired
	private IBillingServiceConsumerClient client;

	@GetMapping("/cart")
	public ResponseEntity<String> doShopping() {
		System.out.println(
				"Consumer Method started " + client.getClass() + Arrays.toString(client.getClass().getInterfaces()));
		String resultMsg = client.fetchBillingInfo().getBody();
		return new ResponseEntity<String>(" Feign Shopping the item(shirts,troust)" + resultMsg, HttpStatus.OK);
	}
}
