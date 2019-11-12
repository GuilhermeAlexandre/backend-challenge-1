package com.invillia.acme.exception;

public class SavingOrderException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public SavingOrderException(String message) {
		super(message);
	}
	
	public SavingOrderException(String message, Exception error) {
		super(message, error);
	}
}