package com.my.Ecommerce.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.my.Ecommerce.dao.OrderDao;
import com.my.Ecommerce.dto.Order;
import com.my.Ecommerce.dto.User;
import com.my.Ecommerce.exception.IdNotFound;
import com.my.Ecommerce.repository.UserRepository;
import com.my.Ecommerce.util.ResponseStructure;

@Service
public class OrderService {

	@Autowired
	private OrderDao dao;
	
	@Autowired
	private UserRepository repository;
	
	
	ResponseStructure<Order> structure = new ResponseStructure<>();
			
	public ResponseEntity<ResponseStructure<Order>> saveOrder(Order order) {
		User user = repository.getUser(order.getUser().getUser_id());
		if(user!=null) {
			order.setUser(user);
			order.setOrderTime(LocalDateTime.now());
			
			structure.setData(order);
			structure.setMessage("orders details is saved");
			structure.setStatusCode(HttpStatus.OK.value());
			
			return new ResponseEntity<ResponseStructure<Order>>(structure , HttpStatus.OK);
		}else {
			structure.setMessage("failed to store order details");
			structure.setStatusCode(HttpStatus.OK.value());
			throw new IdNotFound("user id not found");
		}
	}
	
	
	public ResponseEntity<ResponseStructure<Order>> getOrder(int id){
		
		Order order1 = dao.getOrder(id);
		if(order1!=null) {
			structure.setData(order1);
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setMessage("order Details found");
			
			return new ResponseEntity<ResponseStructure<Order>>(structure , HttpStatus.FOUND);
		}else {
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setMessage("order Details found");
			
			throw new IdNotFound("Order id is not present");
		}
	}
	
	public ResponseEntity<ResponseStructure<Order>> deleteOrder(int id){
		Order order = dao.getOrder(id);
		
		if(order!=null) {
			structure.setMessage("order details deleted");
			structure.setStatusCode(HttpStatus.OK.value());
			
			return new ResponseEntity<ResponseStructure<Order>>(structure, HttpStatus.OK);
		}else {
			structure.setMessage("order details not found");
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			
			throw new IdNotFound("order details not present");
		}
	}
	
	public ResponseEntity<ResponseStructure<Order>>  updateOrder(Order order){
		Order order1 = dao.getOrder(order.getOrder_id());
		System.out.println(order.getOrder_id());
		if(order1!=null) {
			order1.setAmount(order.getAmount());
			order1.setOrderTime(order.getOrderTime());
			order1.setStatus(order.getStatus());
			if(order.getUser().getUser_id() !=0) {
				order1.setUser(order.getUser());
			}
			
			structure.setData(order1);
			structure.setMessage("order details updated");
			structure.setStatusCode(HttpStatus.OK.value());
			
			return new ResponseEntity<ResponseStructure<Order>>(structure , HttpStatus.OK);
		}else {
			structure.setMessage("order details not found");
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			
			throw new IdNotFound("order details not present");
		}
	}
	
	public List<Order> getAllOrders(){
		
		return dao.getAllOrders();
	}
}
