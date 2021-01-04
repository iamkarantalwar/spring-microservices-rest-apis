package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class UserNotAuthorizedException extends Exception {
	
	public UserNotAuthorizedException() {
		// TODO Auto-generated constructor stub
		super("This user is not authorised for this action");
	}

}
