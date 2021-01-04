package com.example.demo.todo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.todo.models.Todo;
import com.example.demo.todo.repository.TodoRepository;
import com.example.demo.todo.request.TodoStoreRequest;

@Service
public class TodoService {
	
	@Autowired
	TodoRepository todoRepository;
	
	// Find all TODO of a particular user
	public  List<Todo> getTodos(Long userId) {
		return this.todoRepository.findByUserId(userId);
	}
	
	
	/**
	 * @return 
	 * @return the all TODO
	 */
	public  List<Todo> getAllTodos () {
		// Make a new list of TODO
		List<Todo> todos = new ArrayList<Todo>();

		for(Todo todo: this.todoRepository.findAll()) {
			todos.add(todo);
		}
		
		return todos;
	}
	
	/**
	 * @store TODO 
	 * @return the Stored TODO
	 */
	public Todo addTodo(TodoStoreRequest todoRequest, Long userId) {
		Todo todo = new Todo();
		todo.setTitle(todoRequest.getTitle());
		todo.setCompleted(todoRequest.isCompleted());
		todo.setUserId(userId);
		return this.todoRepository.save(todo);
	}
	
	/**
	 * @return 
	 * @return the TODO
	 */
	public Todo getTodo(Long todoId) {
		return todoRepository.findById(todoId).orElseThrow(() -> new ResourceNotFoundException("Todo with id " + todoId.toString() + " doesn't exist" ));
	}
	
	/**
	 * @return 
	 * @return the updated TODO
	 */
	public Todo updateTodo(TodoStoreRequest todoRequest, Todo todo) {
		todo.setCompleted(todoRequest.isCompleted());
		todo.setTitle(todoRequest.getTitle());
		return this.todoRepository.save(todo);
	}
	
	public void deleteTodo(Long todoId) {
		this.todoRepository.deleteById(todoId);
	}
	
	
	
}
