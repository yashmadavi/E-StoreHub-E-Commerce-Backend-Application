package com.my.Ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.my.Ecommerce.dto.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

	@Query("select order from Order order where order_id=?1")
	public Order getOrder(int id);
}
