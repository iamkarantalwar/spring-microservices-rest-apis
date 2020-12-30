package com.example.demo.exceptions;

import java.util.Date;

import javax.validation.ConstraintViolationException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	// Handle Specific Exceptions
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException
								(ResourceNotFoundException exception, WebRequest webRequest) {
		
		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), webRequest.getDescription(false));
		return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	// Handle validation errors
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> customValidationErrorHandling
								(MethodArgumentNotValidException exception) {
		
		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getFieldError().getDefaultMessage(), exception.getMessage());
		return new ResponseEntity(errorDetails, HttpStatus.UNPROCESSABLE_ENTITY);
	}
	
	// Handle the DataIntegrityViolationException
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<?> customDataIntegrityViolationException
									(DataIntegrityViolationException exception) {
		
		String message =  exception.getMostSpecificCause().getMessage();
		ErrorDetails errorDetals = new ErrorDetails(new Date(), message, exception.getCause().getMessage());
		return new ResponseEntity(errorDetals, HttpStatus.UNPROCESSABLE_ENTITY);
	}

}
