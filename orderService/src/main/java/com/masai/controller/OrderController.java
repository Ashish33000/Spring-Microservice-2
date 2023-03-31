package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.masai.dto.OrderRequest;
import com.masai.service.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {
	@Autowired
	private OrderService orderservice;
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public String placeOrder(@RequestBody OrderRequest orderRequest) {
		orderservice.placeOrder(orderRequest);
		return "order placed Sucessfully";
	}

}
