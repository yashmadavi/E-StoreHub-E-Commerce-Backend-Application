package com.my.Ecommerce.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.Ecommerce.dto.Product;

import com.my.Ecommerce.repository.ProductRepository;

@Repository
public class ProductDao {

	@Autowired
	private ProductRepository repository;
	
	public Product saveProduct(Product product) {
		return repository.save(product);
	}
	
	public Product findProduct(int id) {
		return repository.findProduct(id);
	}
	
	public Product deleteProduct(int id) {
		return repository.findProduct(id);
	}
	
	public Product updateUser(Product product) {
		return repository.save(product);
	}
	
	public Product productName(String name) {
		return repository.getProduct(name);
	}
	public List<Product> getAllProducts() {
		return repository.findAll();
	}
}
