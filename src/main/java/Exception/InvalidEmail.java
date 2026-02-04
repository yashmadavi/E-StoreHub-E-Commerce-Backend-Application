package com.my.Ecommerce.exception;


public class InvalidEmail extends RuntimeException {

	private String message;
	
	public InvalidEmail(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}
}
