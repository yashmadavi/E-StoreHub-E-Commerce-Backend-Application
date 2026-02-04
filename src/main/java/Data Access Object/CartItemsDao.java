package com.my.Ecommerce.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.Ecommerce.dto.CartItems;
import com.my.Ecommerce.repository.CartItemsRepository;

@Repository
public class CartItemsDao {

	
	@Autowired
	private CartItemsRepository repository;
	
	public CartItems saveCartItems(CartItems items) {
		return repository.save(items);
	}
}
