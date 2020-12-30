package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)

public class ResourceNotFoundException extends RuntimeException {
	
	// Create a constructor and pass the message to the super class
	public ResourceNotFoundException(String message) {
		super(message);
	}
}
