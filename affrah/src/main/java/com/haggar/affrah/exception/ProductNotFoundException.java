package com.haggar.affrah.exception;

import java.io.Serializable;

public class ProductNotFoundException extends Exception implements Serializable {
	
	private static long serialVersionUID = 1L;
	private String message;
	
	public ProductNotFoundException() {
		
		this("This product is not available");
		
	}
	
	public ProductNotFoundException(String message) {
		
		this.message = System.currentTimeMillis() + ": " +message;
		
	}

	public String getMessage() {
		return message;
	}

	

}
