package com.my.Ecommerce.exception;

public class InvalidPassword extends RuntimeException{

	private String message;
	
	public InvalidPassword(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}
}
