package com.my.Ecommerce.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.Ecommerce.dto.Order;
import com.my.Ecommerce.repository.OrderRepository;
import com.my.Ecommerce.util.ResponseStructure;

@Repository
public class OrderDao {

	@Autowired
	private OrderRepository repository;
	
		
	public Order saveOrder(Order order) {
		return repository.save(order);
	}
	
	public Order getOrder(int id) {
		return repository.getOrder(id);
	}
	
	public List<Order> getAllOrders() {
		return repository.findAll();
	}
}
