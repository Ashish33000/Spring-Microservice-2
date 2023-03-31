package com.masai.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.DTO.ProductRequest;
import com.masai.DTO.ProductResponse;
import com.masai.model.Product;
import com.masai.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductService {
	
	@Autowired
	private  ProductRepository productRepo;
	
	public void createProduct(ProductRequest productRequest) {
		String id=UUID.randomUUID().toString();
		
		
		Product product=Product.builder()
				.id(id)
				.name(productRequest.getName())
				.description(productRequest.getDescription())
				.price(productRequest.getPrice())
				.build();
		productRepo.save(product);
		log.info("Product {} is Saved",product.getId());
		
	}
	
	public List<ProductResponse> getAllProduct(){
		
		List<Product> products=productRepo.findAll();
		return products.stream().map(this::mapToProductResponse).toList();
		
	}

	private ProductResponse mapToProductResponse(Product product) {
		// TODO Auto-generated method stub
		return ProductResponse.builder()
				.id(product.getId())
				.name(product.getName())
				.description(product.getDescription())
				.price(product.getPrice())
				.build();
	}

}
