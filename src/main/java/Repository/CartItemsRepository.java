package com.my.Ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.my.Ecommerce.dto.CartItems;

public interface CartItemsRepository extends JpaRepository<CartItems, Integer>{
	
	@Query("select cart from CartItems cart where cartItem_id=?1")
	public CartItems getCartId(int id);

}
