package com.invillia.acme.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.invillia.acme.exception.ExistingCNPJException;
import com.invillia.acme.exception.ExistingSkuException;
import com.invillia.acme.exception.ItemNotFoundException;
import com.invillia.acme.exception.OrderDoneException;
import com.invillia.acme.exception.SavingOrderException;
import com.invillia.acme.exception.SupplyValidationException;
import com.invillia.acme.model.DetailsError;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ExistingSkuException.class)
	public ResponseEntity<DetailsError> ExistingSkuException
							(ExistingSkuException e, HttpServletRequest request) {
		
		DetailsError erro = new DetailsError();
		
		erro.setStatus(404L);
		erro.setTitle(e.getMessage());
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(SupplyValidationException.class)
	public ResponseEntity<DetailsError> SupplyValidationException
							(ExistingSkuException e, HttpServletRequest request) {
		
		DetailsError erro = new DetailsError();
		
		erro.setStatus(404L);
		erro.setTitle(e.getMessage());
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}
	
	@ExceptionHandler(ItemNotFoundException.class)
	public ResponseEntity<DetailsError> ItemNotFoundException
							(ExistingSkuException e, HttpServletRequest request) {
		
		DetailsError erro = new DetailsError();
		
		erro.setStatus(404L);
		erro.setTitle(e.getMessage());
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}
	
	@ExceptionHandler(SavingOrderException.class)
	public ResponseEntity<DetailsError> SavingOrderException
							(ExistingSkuException e, HttpServletRequest request) {
		
		DetailsError erro = new DetailsError();
		
		erro.setStatus(404L);
		erro.setTitle(e.getMessage());
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}
	
	@ExceptionHandler(OrderDoneException.class)
	public ResponseEntity<DetailsError> OrderDoneException
							(OrderDoneException e, HttpServletRequest request) {
		
		DetailsError erro = new DetailsError();
		
		erro.setStatus(404L);
		erro.setTitle(e.getMessage());
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}
	
	@ExceptionHandler(ExistingCNPJException.class)
	public ResponseEntity<DetailsError> ExistingCNPJException
							(ExistingCNPJException e, HttpServletRequest request) {
		
		DetailsError erro = new DetailsError();
		
		erro.setStatus(404L);
		erro.setTitle(e.getMessage());
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}
	
	
}
