package com.bankar.orderservice.exception;

public class NotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3381175975448235680L;
	
	
	
	public NotFoundException(String message) {
		super(message);
	}

}
