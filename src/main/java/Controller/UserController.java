package com.my.Ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.my.Ecommerce.dto.User;
import com.my.Ecommerce.service.UserService;
import com.my.Ecommerce.util.ResponseStructure;

@RestController
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping("/saveUser")
	public  ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user) {
		return service.saveUser(user);
	}
	
	@GetMapping("/findUser/{id}")
	public ResponseEntity<ResponseStructure<User>> getUser(@PathVariable int id) {
		return service.findUser(id);
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<ResponseStructure<User>> deleteUser(@PathVariable int id){
		return service.deleteUser(id);
	}
	
	@PutMapping("/updateUser")
	public ResponseEntity<ResponseStructure<User>> updateUser(@RequestBody User user){
		return service.updateUser(user);
	}
	@GetMapping("/loginUser")
	public ResponseEntity<ResponseStructure<User>> loginUser(@RequestBody User user){
		return service.loginUser(user);
	}
}
