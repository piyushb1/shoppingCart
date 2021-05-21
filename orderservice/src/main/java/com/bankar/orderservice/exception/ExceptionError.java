package com.bankar.orderservice.exception;

import org.springframework.stereotype.Component;

@Component
public class ExceptionError{
	
	private String errorCode;
	private String errorURL;
	private String errorMessage;
	
	public ExceptionError(String errorCode, String errorURL, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorURL = errorURL;
		this.errorMessage = errorMessage;
	}
	
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public ExceptionError(String errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
	public ExceptionError() {
		
	}
	public String getErrorURL() {
		return errorURL;
	}
	public void setErrorURL(String errorURL) {
		this.errorURL = errorURL;
	}

}
