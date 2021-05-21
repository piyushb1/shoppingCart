package com.bankar.productservice.exception;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

public class ErrorMesssage {
	
	private String errorMessage;
	private ZonedDateTime timestamp;
	private HttpStatus httpstatus;
	
	
	public ErrorMesssage(String errorMessage, HttpStatus httpstatus, ZonedDateTime timestamp) {
		super();
		this.errorMessage = errorMessage;
		this.httpstatus = httpstatus;
		this.timestamp = timestamp;
	}


	public String getErrorMessage() {
		return errorMessage;
	}


	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}


	public HttpStatus getHttpstatus() {
		return httpstatus;
	}


	public void setHttpstatus(HttpStatus httpstatus) {
		this.httpstatus = httpstatus;
	}


	public ZonedDateTime getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(ZonedDateTime timestamp) {
		this.timestamp = timestamp;
	}
	
	
	
	

}
