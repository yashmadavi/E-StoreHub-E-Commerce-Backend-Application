package com.my.Ecommerce.service;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.my.Ecommerce.dao.CartDao;
import com.my.Ecommerce.dto.Cart;
import com.my.Ecommerce.dto.User;
import com.my.Ecommerce.exception.IdNotFound;
import com.my.Ecommerce.repository.UserRepository;
import com.my.Ecommerce.util.ResponseStructure;

@Service
public class CartService {

	@Autowired
	private CartDao dao;
	
	@Autowired
	private UserRepository repository;
	
	ResponseStructure<Cart> structure = new ResponseStructure<>();
	
	public ResponseEntity<ResponseStructure<Cart>> saveCart(int user_id) {
		
		User user = repository.getUser(user_id);
		
		if(user!=null) {
			Cart cart1 = new Cart();
			structure.setData(dao.saveCart(cart1));
			structure.setMessage("cart details is saved");
			structure.setStatusCode(HttpStatus.OK.value());
		
			return new ResponseEntity<ResponseStructure<Cart>>(structure, HttpStatus.OK);
		}else {
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			structure.setMessage("user not present");
			
			throw new IdNotFound("user id not found");
		}
		
	}
	
	public ResponseEntity<ResponseStructure<Cart>> getCart(int id) {
		Cart cart = dao.getCart(id);
		if(cart!=null) {
			structure.setData(cart);
			structure.setMessage("cart detalis found");
			structure.setStatusCode(HttpStatus.FOUND.value());
			
			return new ResponseEntity<ResponseStructure<Cart>>(structure, HttpStatus.FOUND);
		}else {
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			structure.setMessage("user not present");
			
			throw new IdNotFound("user id not found");
		}
	}
	
	
}
