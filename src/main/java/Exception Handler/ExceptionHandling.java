package com.my.Ecommerce.exception_handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.my.Ecommerce.dto.User;
import com.my.Ecommerce.exception.EmailNotFound;
import com.my.Ecommerce.exception.IdNotFound;
import com.my.Ecommerce.exception.InvalidEmail;
import com.my.Ecommerce.exception.InvalidPassword;
import com.my.Ecommerce.util.ResponseStructure;

@RestControllerAdvice
public class ExceptionHandling {

	ResponseStructure<User> structure = new ResponseStructure<>();
	
	@ExceptionHandler(IdNotFound.class)
	public ResponseEntity<ResponseStructure<User>> userIdNotFound(IdNotFound idNotFound){
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setMessage("user id not found");
		
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EmailNotFound.class)
	public ResponseEntity<ResponseStructure<User>> userEmailNotFound(EmailNotFound emailNotFound){
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setMessage("user email not found");
		
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidEmail.class)
	public ResponseEntity<ResponseStructure<User>> userInvalidEmail(InvalidEmail invalidEmail){
		structure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
		structure.setMessage("invalid email id");
		
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(InvalidPassword.class)
	public ResponseEntity<ResponseStructure<User>> userInvalidPassword(InvalidPassword invalidPassword){
		structure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
		structure.setMessage("wrong password");
		
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.NOT_ACCEPTABLE);
	}
}
