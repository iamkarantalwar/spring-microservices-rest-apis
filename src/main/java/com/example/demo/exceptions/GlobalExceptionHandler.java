package com.example.demo.exceptions;

import java.util.Date;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	// Handle Specific Exceptions
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException
								(ResourceNotFoundException exception, WebRequest webRequest) {
		
		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), webRequest.getDescription(false));
		return new ResponseEntity<Object>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	// Handle validation errors
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> customValidationErrorHandling
								(MethodArgumentNotValidException exception) {
		
		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getFieldError().getDefaultMessage(), exception.getMessage());
		return new ResponseEntity<Object>(errorDetails, HttpStatus.UNPROCESSABLE_ENTITY);
	}
	
	// Handle the DataIntegrityViolationException
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<?> customDataIntegrityViolationException
									(DataIntegrityViolationException exception) {
		
		if(exception.getCause() instanceof ConstraintViolationException) {
			 String name = ((ConstraintViolationException) exception.getCause()).getConstraintName();
//			SQLIntegrityConstraintViolationException sqlException = new SQLIntegrityConstraintViolationException();
//			sqlException.
			 System.out.println(name);
		}
		
		String message = "a";
		ErrorDetails errorDetals = new ErrorDetails(new Date(), message, exception.getCause().getMessage());
		return new ResponseEntity<Object>(errorDetals, HttpStatus.UNPROCESSABLE_ENTITY);
	}
	
	// When user is not Authorized
	@ExceptionHandler(UserNotAuthorizedException.class)
	public ResponseEntity<?> userNotAuthorizedException
								(UserNotAuthorizedException exception) {
		
		ErrorDetails errorDetals = new ErrorDetails(new Date(), "Please login to proceed.", exception.getCause().getMessage());
		return new ResponseEntity<Object>(errorDetals, HttpStatus.UNAUTHORIZED);
		
	}
	
	// Handle all the exceptions that are unhandled
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<?> globalExceptionHandler 
								(Exception exception) {
		
		ErrorDetails errorDetals = new ErrorDetails(new Date(), "Unhandled Response", exception.getCause().getMessage());
		return new ResponseEntity<Object>(errorDetals, HttpStatus.UNAUTHORIZED);
	}

}
