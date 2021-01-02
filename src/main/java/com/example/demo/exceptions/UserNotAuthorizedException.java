package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class UserNotAuthorizedException extends RuntimeException {
	
	public UserNotAuthorizedException() {
		// TODO Auto-generated constructor stub
		super("User is not authorised for this action");
	}

}
