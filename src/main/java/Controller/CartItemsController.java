package com.my.Ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.my.Ecommerce.dto.CartItems;
import com.my.Ecommerce.service.CartItemsService;

@RestController
public class CartItemsController {

	@Autowired
	private CartItemsService service;
	
	@PostMapping("saveItems")
	public CartItems saveCartItems(@RequestBody CartItems items) {
		return service.saveCartItems(items);
	}
}
