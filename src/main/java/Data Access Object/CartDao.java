package com.my.Ecommerce.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.Ecommerce.dto.Cart;
import com.my.Ecommerce.repository.CartRepository;

@Repository
public class CartDao {
	
	@Autowired
	private CartRepository repository;
	
	public Cart saveCart(Cart cart) {
		return repository.save(cart);
	}
	
	public Cart getCart(int id) {
		return repository.findcart(id);
	}
}
