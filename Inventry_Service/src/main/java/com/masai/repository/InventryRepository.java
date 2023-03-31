package com.masai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Inventory;



public interface InventryRepository extends JpaRepository<Inventory, Long>{

	public Optional<Inventory> findBySkuCode(String skuCode);

}
