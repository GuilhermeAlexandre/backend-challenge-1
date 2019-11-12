package com.invillia.acme.exception;

public class ExistingSkuException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public ExistingSkuException(String message) {
		super(message);
	}
	
	public ExistingSkuException(String message, Exception error) {
		super(message, error);
	}
}