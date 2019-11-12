package com.invillia.acme.exception;

public class ItemAlreadyExistsException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public ItemAlreadyExistsException(String message) {
		super(message);
	}
	
	public ItemAlreadyExistsException(String message, Exception error) {
		super(message, error);
	}
}