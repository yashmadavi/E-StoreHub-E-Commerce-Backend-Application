package com.my.Ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.my.Ecommerce.dto.Product;
import com.my.Ecommerce.service.ProductService;
import com.my.Ecommerce.util.ResponseStructure;

@RestController
public class ProductController {

	@Autowired
	private ProductService service;
	
	@PostMapping("/saveProduct")
	public ResponseEntity<ResponseStructure<Product>> saveProduct(@RequestBody Product product) {
		return service.saveProduct(product);
	}
	
	@GetMapping("/findProduct/{id}")
	public ResponseEntity<ResponseStructure<Product>> findProduct(@PathVariable int id) {
		return service.findProduct(id);
	}
	
	@PutMapping("/deleteProduct/{id}")
	public ResponseEntity<ResponseStructure<Product>> deleteProduct(@PathVariable int id) {
		return service.deleteProduct(id);
	}
	
	@PatchMapping("/updateProduct")
	public ResponseEntity<ResponseStructure<Product>> updateProduct(@RequestBody Product product) {
		return service.updateProduct(product);
	}
	
	@GetMapping("/getProduct")
	public List<Product>  getAllProducts(){
		return service.getAllProduct();
	}
	
	@GetMapping("/getName/{name}")
	public ResponseEntity<ResponseStructure<Product>> getName(@PathVariable String name){
		return service.productName(name);
	}
}
