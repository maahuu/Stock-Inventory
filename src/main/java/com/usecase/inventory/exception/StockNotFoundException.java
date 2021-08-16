package com.usecase.inventory.exception;

@SuppressWarnings("serial")
public class StockNotFoundException extends RuntimeException {
	
	public StockNotFoundException(String message) {
		super(message);
	}
	

}
