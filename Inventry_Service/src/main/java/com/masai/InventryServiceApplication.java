package com.masai;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.masai.model.Inventory;
import com.masai.repository.InventryRepository;

@SpringBootApplication
public class InventryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventryServiceApplication.class, args);
	}
	
	
	@Bean
	public CommandLineRunner loadData(InventryRepository inventryRepository) {
		return args->{
			Inventory inventory=new Inventory();
			inventory.setSkuCode("iphone-13");
			inventory.setQuantity(100);
			Inventory inventory1=new Inventory();
			inventory1.setSkuCode("iphone-13_red");
			inventory1.setQuantity(0);
			inventryRepository.save(inventory);
			inventryRepository.save(inventory1);
			
		};
	}

}
