package com.my.Ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.my.Ecommerce.dto.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	@Query("select user from User user where user_id=?1")
	public User getUser(int id);
	
	@Query("select user from User user where email=?1")
	public User findEmail(String email);
}
