package com.invillia.acme.exception;

public class OrderDoneException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public OrderDoneException(String message) {
		super(message);
	}
	
	public OrderDoneException(String message, Exception error) {
		super(message, error);
	}
}