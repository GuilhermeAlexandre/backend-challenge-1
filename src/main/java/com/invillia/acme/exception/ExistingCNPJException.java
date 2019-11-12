package com.invillia.acme.exception;

public class ExistingCNPJException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public ExistingCNPJException(String message) {
		super(message);
	}
	
	public ExistingCNPJException(String message, Exception error) {
		super(message, error);
	}
}
