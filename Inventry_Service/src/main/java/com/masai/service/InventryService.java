package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.masai.repository.InventryRepository;

@Service
public class InventryService {
	@Autowired
	private InventryRepository inventryRepo;
	@Transactional(readOnly = true)
	public boolean isInStock(String skuCode) {
		return inventryRepo.findBySkuCode(skuCode).isPresent();
	}
	
	

}
