package com.example.demo.todo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.auth.security.services.UserDetailsImpl;
import com.example.demo.exceptions.UserNotAuthorizedException;
import com.example.demo.response.DeleteResponse;
import com.example.demo.todo.models.Todo;
import com.example.demo.todo.request.TodoStoreRequest;
import com.example.demo.todo.service.TodoService;


@RestController
@RequestMapping("/api/todos")
public class TodoController {
	
	@Autowired
	TodoService todoService;
	
	@GetMapping
	public ResponseEntity<?> index(Authentication authentication) {
		// Get the User
		UserDetailsImpl user  = ((UserDetailsImpl) authentication.getPrincipal());
		// Send the ID to the Service
		return ResponseEntity.ok(this.todoService.getTodos(user.getId()));
	}
	
	@PostMapping
	public ResponseEntity<?> store(@Valid @RequestBody TodoStoreRequest todoRequest, Authentication authentication) {
		// Get the User
		UserDetailsImpl user  = ((UserDetailsImpl) authentication.getPrincipal());
		// Send the ID to the service
		return ResponseEntity.ok(this.todoService.addTodo(todoRequest, user.getId()));
	}
	
	
	@PutMapping("{todoId}")
	public ResponseEntity<?> update(@RequestBody TodoStoreRequest todoRequest, Authentication authentication, @PathVariable Long todoId) throws UserNotAuthorizedException {
		// Get the User
		UserDetailsImpl user  = ((UserDetailsImpl) authentication.getPrincipal());
		
		// Get the TODO
		Todo todo = this.todoService.getTodo(todoId);
		
		// Check if this TODO exist to a particular user or not
		if (!user.getId().equals(todo.getUserId())) {
			throw new UserNotAuthorizedException();
		}
		
		// Return the updates instance
		return ResponseEntity.ok(this.todoService.updateTodo(todoRequest, todo));
	}
	
	// Get the TODO instance
	@GetMapping("{todoId}")
	public ResponseEntity<?> show(@PathVariable Long todoId, Authentication authentication) throws UserNotAuthorizedException {
		// Get the User
		UserDetailsImpl user  = ((UserDetailsImpl) authentication.getPrincipal());
				
		// Get the TODO
		Todo todo = this.todoService.getTodo(todoId);
		
		// Check if this TODO exist to a particular user or not
		if (!user.getId().equals(todo.getUserId())) {
			throw new UserNotAuthorizedException();
		}
		
		// Return the updates instance
		return ResponseEntity.ok(todo);
	}
	
	@DeleteMapping("{todoId}")
	public ResponseEntity<?> delete(@PathVariable Long todoId, Authentication authentication) throws UserNotAuthorizedException {
		// Get the User
		UserDetailsImpl user  = ((UserDetailsImpl) authentication.getPrincipal());
				
		// Get the TODO
		Todo todo = this.todoService.getTodo(todoId);
		
		// Check if this TODO exist to a particular user or not
		if (!user.getId().equals(todo.getUserId())) {
			throw new UserNotAuthorizedException();
		}
		
		// Delete the instance 
		this.todoService.deleteTodo(todoId);
		
		// Return the updates instance
		return ResponseEntity.ok(new DeleteResponse());
	}
	
}
