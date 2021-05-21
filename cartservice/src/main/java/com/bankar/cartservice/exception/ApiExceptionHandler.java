package com.bankar.cartservice.exception;

import java.time.ZonedDateTime;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
	
	
	 
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorMesssage> handleAllExceptions(Exception ex, WebRequest request) {
		ErrorMesssage exceptionResponse = new ErrorMesssage( ex.getMessage(),HttpStatus.NOT_FOUND, ZonedDateTime.now());
	    return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	 }
	 
	 
	
	@ExceptionHandler(value = {NotFoundException.class})
	public ResponseEntity<Object> handleApiRequestException(NotFoundException e){
		
		HttpStatus badrequest = HttpStatus.NOT_FOUND;
		
		ErrorMesssage errorMessage = new ErrorMesssage(
				e.getMessage(),
				badrequest,
				ZonedDateTime.now()
				);
		
		
		return new ResponseEntity<>(errorMessage,badrequest);
		
	}
	
	
	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {

		ErrorMesssage error = new ErrorMesssage	(ex.getMessage(),
												HttpStatus.NOT_FOUND,
												ZonedDateTime.now());
		
		return new ResponseEntity<Object>(error,HttpStatus.NOT_FOUND);
	}
	
	
	 
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		ErrorMesssage error = new ErrorMesssage	(ex.getMessage(),
				HttpStatus.BAD_REQUEST,
				ZonedDateTime.now());
		
		return new ResponseEntity<Object>(error,HttpStatus.NOT_FOUND);
	}

	

}
