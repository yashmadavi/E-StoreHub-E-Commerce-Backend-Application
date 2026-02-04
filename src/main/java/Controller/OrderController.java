package com.my.Ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.my.Ecommerce.dto.Order;
import com.my.Ecommerce.service.OrderService;
import com.my.Ecommerce.util.ResponseStructure;

@RestController
public class OrderController {

	@Autowired
	private OrderService service;
	
	@PostMapping("/saveOrder")
	public ResponseEntity<ResponseStructure<Order>> saveOrder(@RequestBody Order order) {
		return service.saveOrder(order);
	}
	
	@GetMapping("/getOrder/{id}")
	public ResponseEntity<ResponseStructure<Order>> getOrder(@PathVariable int id){
		return service.getOrder(id);
	}
	
	@DeleteMapping("deleteOrder/{id}")
	public ResponseEntity<ResponseStructure<Order>> deleteOrder(@PathVariable int id){
		return service.deleteOrder(id);
	}
	
	@PutMapping("/updateOrder")
	public ResponseEntity<ResponseStructure<Order>> updateOrder(@RequestBody Order order){
		return service.updateOrder(order);
	}
	
	@GetMapping("/getAllOrder")
	public List<Order> getAllOrders() {
		return service.getAllOrders();
	}
}
