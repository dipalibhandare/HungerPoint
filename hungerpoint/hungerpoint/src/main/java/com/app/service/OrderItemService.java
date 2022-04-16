package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojos.OrderItem;
import com.app.repository.OrderItemRepository;
import com.app.repository.OrderRepository;

@Service
public class OrderItemService {

	@Autowired
	private OrderItemRepository orderItemRepo;
	
	public List<OrderItem> save(List<OrderItem> obj)
	{
		return orderItemRepo.saveAll(obj);
	}
}
