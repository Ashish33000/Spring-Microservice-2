package com.masai.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.masai.dto.OrderLineItemsDto;
import com.masai.dto.OrderRequest;
import com.masai.model.Order;
import com.masai.model.OrderLineItems;
import com.masai.repository.OrderRepository;



@Service
@Transactional
public class OrderService {
	@Autowired
	private OrderRepository  orderRepository;
	
	
	public void placeOrder(OrderRequest orderRequest) {
		Order order=new Order();
		order.setOrderNumber(UUID.randomUUID().toString());
		
	   List<OrderLineItems> orderLineItems	=orderRequest.getOrdelLineItemsDtoList()
		.stream()
		.map(this:: mapToDto)
		.toList();
		order.setOrdelLineItemList(orderLineItems);
		orderRepository.save(order);
		
	}

	private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
		// TODO Auto-generated method stub
		OrderLineItems orderLineItems=new OrderLineItems();
		orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
		orderLineItems.setPrice(orderLineItemsDto.getPrice());
		orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
		return orderLineItems;
	}

}
