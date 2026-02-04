package com.my.Ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.my.Ecommerce.dto.OrderItems;

public interface OrderItemsRepository extends JpaRepository<OrderItems, Integer>{

	//to validate if the order items is present or not
}
