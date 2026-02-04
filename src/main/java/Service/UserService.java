package com.my.Ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.my.Ecommerce.dao.UserDao;
import com.my.Ecommerce.dto.User;
import com.my.Ecommerce.exception.IdNotFound;
import com.my.Ecommerce.exception.InvalidEmail;
import com.my.Ecommerce.exception.InvalidPassword;
import com.my.Ecommerce.util.Email;
import com.my.Ecommerce.util.ResponseStructure;

@Service
public class UserService {

	@Autowired
	private UserDao dao;
	
	ResponseStructure<User> structure = new ResponseStructure<>();
	
	@Autowired
	private Email email;
	
	
	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		dao.saveUser(user);
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("user details is saved");
		structure.setData(user);
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
		
	}
	
	public ResponseEntity<ResponseStructure<User>> findUser(int id){
		User user1 = dao.findUser(id);
		if(user1!=null) {
			structure.setData(user1);
			structure.setMessage("User found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure ,  HttpStatus.OK);
		}else {
			throw new IdNotFound("Id not found");
		}
	}
	
	
	public ResponseEntity<ResponseStructure<User>> deleteUser(int id){
		User user1 = dao.findUser(id);
		if(user1!=null) {			
			structure.setMessage("user deleted");
			structure.setData(user1);
			structure.setStatusCode(HttpStatus.OK.value());
			dao.deleteUser(id);
			return new ResponseEntity<ResponseStructure<User>>(structure , HttpStatus.OK);
		}
		throw new IdNotFound("Id not found");
	}
	
	public ResponseEntity<ResponseStructure<User>> updateUser(User user) {
		User user1 = dao.findUser(user.getUser_id());
		if(user1!=null) {
			user1.setAge(user.getAge());
			user1.setEmail(user.getEmail());
			user1.setName(user.getName());
			user1.setPassword(user.getPassword());
			user1.setRole(user.getRole());
			
			structure.setMessage("user details updated");
			structure.setData(user1);
			structure.setStatusCode(HttpStatus.OK.value());
			dao.saveUser(user1);
			
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
		}else {
			throw new IdNotFound("user is not present");
		}
	}
	
	public ResponseEntity<ResponseStructure<User>> loginUser(User user){
		User user1 = dao.loginUser(user.getEmail());
		if(user1!=null) {
			if(user1.getPassword().equalsIgnoreCase(user.getPassword())) {
				structure.setData(user1);
				structure.setStatusCode(HttpStatus.OK.value());
				structure.setMessage("Login successful");
				
			email.sendMail(user1.getEmail());
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
			}else {
				throw new InvalidPassword("incorrect password");
			}
		}else {
			throw new InvalidEmail("incorrect email");
		}
		
	}
}
