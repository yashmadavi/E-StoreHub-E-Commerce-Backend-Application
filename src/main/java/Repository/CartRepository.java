package com.my.Ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.my.Ecommerce.dto.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

	@Query("select cart from Cart cart where cart_id=?1")
	public Cart findcart(int id);
}
