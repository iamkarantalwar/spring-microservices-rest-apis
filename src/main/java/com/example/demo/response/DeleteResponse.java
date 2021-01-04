package com.example.demo.response;

import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
public class DeleteResponse {
	
	private String message = "This entity is deleted successfully.";

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}
