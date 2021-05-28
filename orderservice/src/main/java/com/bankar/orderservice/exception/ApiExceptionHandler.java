package com.bankar.orderservice.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Controller
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

	 
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public @ResponseBody ExceptionError handleException(final Exception exception,
			final HttpServletRequest request) {

 		ExceptionError error = new ExceptionError();
		error.setErrorMessage(exception.getMessage());
		error.setErrorCode(HttpStatus.NOT_FOUND.toString());
		error.setErrorURL(request.getRequestURI());

		return error;
	}

	 
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		ExceptionError error = new ExceptionError(HttpStatus.BAD_REQUEST.toString(),request.getDescription(false),ex.getMessage());

		return new ResponseEntity<Object>(error,HttpStatus.NOT_FOUND);
	}

	
		
	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {

		ExceptionError error = new ExceptionError(status.toString(),request.getDescription(false),ex.getLocalizedMessage());
		
		return new ResponseEntity<Object>(error,HttpStatus.NOT_FOUND);
	}
	
	
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ExceptionError> handleNotFoundException(NotFoundException e, final HttpServletRequest request){
		
		ExceptionError error = new ExceptionError(HttpStatus.NOT_FOUND.toString(),request.getRequestURI(),e.getMessage());
		
		return new ResponseEntity<ExceptionError>(error,HttpStatus.NOT_FOUND);
	}
	
	

}
