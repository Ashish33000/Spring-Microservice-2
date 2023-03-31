package com.masai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.masai.service.InventryService;

@RestController
@RequestMapping("/api/inventory")
public class InventryController {
	@Autowired
	private InventryService inventryservice;
	
	@GetMapping("/{sku-code}")
	@ResponseStatus(code = HttpStatus.OK)
	public boolean inStock(@PathVariable("sku-code") String skuCode) {
		return inventryservice.isInStock(skuCode);
	}
	

}
