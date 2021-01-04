package com.example.demo.auth.response;

import org.springframework.stereotype.Component;

@Component
public class SuccessResponse {
	private Object data;
	private String message;

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
