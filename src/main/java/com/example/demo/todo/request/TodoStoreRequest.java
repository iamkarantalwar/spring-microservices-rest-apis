package com.example.demo.todo.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class TodoStoreRequest {
	
	@NotBlank
	private String title;
	
	@NotNull
	private boolean completed;

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the completed
	 */
	public boolean isCompleted() {
		return completed;
	}

	/**
	 * @param completed the completed to set
	 */
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	
}
