package com.my.Ecommerce.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.Ecommerce.dto.User;
import com.my.Ecommerce.repository.UserRepository;

@Repository
public class UserDao {

	@Autowired
	private UserRepository repository;
	
	public User saveUser(User user) {
		return repository.save(user); 
	}
	
	public User findUser(int id) {
		return repository.getUser(id);
	}
	
	public User deleteUser(int id) {
		return repository.getUser(id);
	}
	
	
	public User loginUser(String email) {
		return repository.findEmail(email);
	}
}
