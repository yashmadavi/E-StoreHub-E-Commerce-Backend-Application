package com.my.Ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.my.Ecommerce.dto.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	@Query("select product from Product product where product_id=?1")
	public Product findProduct(int product_id);
	
	@Query("select product from Product product where name=?1")
	public Product getProduct(String name);
}
