package com.my.Ecommerce.exception;

public class IdNotFound extends RuntimeException {

	private String message;
	
	public IdNotFound(String messgage) {
		
		this.message = message;
	}
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}
	
	
	
}
