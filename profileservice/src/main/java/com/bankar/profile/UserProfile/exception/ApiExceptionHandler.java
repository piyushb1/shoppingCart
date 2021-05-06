package com.bankar.profile.UserProfile.exception;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bankar.profile.UserProfile.pojo.ErrorMesssage;

@ControllerAdvice
public class ApiExceptionHandler {
	
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

}
