package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Order;

public interface OrderRepository extends  JpaRepository<Order, Long> {

}
