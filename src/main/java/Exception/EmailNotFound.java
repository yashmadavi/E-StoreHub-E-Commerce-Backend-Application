package com.my.Ecommerce.exception;

public class EmailNotFound extends RuntimeException{

	
	private String message;
	
	public EmailNotFound(String message) {
		this.message = message;
	}
	@Override
	public String getMessage() {
		
		return super.getMessage();
	}
}
