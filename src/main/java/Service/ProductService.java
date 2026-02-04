package com.my.Ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.my.Ecommerce.dao.ProductDao;
import com.my.Ecommerce.dto.Product;
import com.my.Ecommerce.exception.IdNotFound;
import com.my.Ecommerce.util.ResponseStructure;

@Service
public class ProductService {

	@Autowired
	private ProductDao dao;
	
	ResponseStructure<Product> structure = new ResponseStructure<>();
	
	public ResponseEntity<ResponseStructure<Product>> saveProduct(Product product) {
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("product details is saved");
		structure.setData(product);
		
		return new ResponseEntity<ResponseStructure<Product>>(structure , HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Product>> findProduct(int id) {
		Product product1 = dao.findProduct(id);
		if(product1!=null) {			
		
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("product details");
		structure.setData(product1);
		
		return new ResponseEntity<ResponseStructure<Product>>(structure , HttpStatus.OK);
		}else {

			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			structure.setMessage("product details not found");
			throw new IdNotFound("product id is not present");
		}
	}
	
	public ResponseEntity<ResponseStructure<Product>> deleteProduct(int id) {
		Product product1 = dao.findProduct(id);
		if(product1!=null) {		
		
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("product details");
		structure.setData(product1);
		
		return new ResponseEntity<ResponseStructure<Product>>(structure , HttpStatus.OK);
		}else {
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			structure.setMessage("product details not found");
			throw new IdNotFound("product id is not present");
		}
	}
	
	
	public ResponseEntity<ResponseStructure<Product>> updateProduct(Product product) {
		Product product1 = dao.findProduct(product.getProduct_id());
		if(product1!=null) {
		product1.setCategory(product.getCategory());
		product1.setDescription(product.getDescription());
		product1.setName(product.getName());
		product1.setPrice(product.getPrice());
		product1.setStock(product.getStock());
		
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("product details is saved");
		structure.setData(product1);
		
		return new ResponseEntity<ResponseStructure<Product>>(structure , HttpStatus.OK);
		}else {
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			structure.setMessage("product details is not found");
			throw new IdNotFound("product details not present");
		}
	}
	
	public List<Product> getAllProduct(){
		return dao.getAllProducts();
	}
	
	public ResponseEntity<ResponseStructure<Product>> productName(String name){
		Product product1 = dao.productName(name);
		if(product1!=null) {
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("product details is saved");
		structure.setData(product1);
		
		return new ResponseEntity<ResponseStructure<Product>>(structure , HttpStatus.OK);
		}else {
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("product details is saved");
			throw new IdNotFound("product not present");
		}
	}
	
}
