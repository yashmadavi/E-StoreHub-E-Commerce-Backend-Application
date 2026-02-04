package com.my.Ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my.Ecommerce.dto.Cart;
import com.my.Ecommerce.service.CartService;
import com.my.Ecommerce.util.ResponseStructure;

@RestController
public class CartController {

	@Autowired
	private CartService service;
	
	@PostMapping("/saveCart/{user_id}")
	public ResponseEntity<ResponseStructure<Cart>> saveCart(@PathVariable int user_id) {
		return service.saveCart(user_id);
	}
	
	
	@GetMapping("/getCart/{id}")
	public ResponseEntity<ResponseStructure<Cart>> getCart(@PathVariable int id) {
		return service.getCart(id);
	}
}
