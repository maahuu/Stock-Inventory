package com.usecase.inventory.exception;



import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(StockNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorMessage handleNotFoundException(StockNotFoundException ex,WebRequest request) {
	    ErrorMessage message = new ErrorMessage(
	            HttpStatus.NOT_FOUND.value(),
	            LocalDate.now(),
	            ex.getMessage(),
	            request.getDescription(false));
	        
	        return message;
	}
	
	@ExceptionHandler(Exception.class)
	  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	  public ErrorMessage globalExceptionHandler(Exception ex, WebRequest request) {
	    ErrorMessage message = new ErrorMessage(
	        HttpStatus.INTERNAL_SERVER_ERROR.value(),
	        LocalDate.now(),
	        ex.getMessage(),
	        request.getDescription(false));
	    
	    return message;
	  }
	
}
