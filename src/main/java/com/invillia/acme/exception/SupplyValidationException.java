package com.invillia.acme.exception;

public class SupplyValidationException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public SupplyValidationException(String message) {
		super(message);
	}
	
	public SupplyValidationException(String message, Exception error) {
		super(message, error);
	}

}
