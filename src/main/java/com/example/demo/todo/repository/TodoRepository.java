package com.example.demo.todo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.todo.models.Todo;


public interface TodoRepository extends CrudRepository<Todo, Long> {
	List<Todo> findByUserId(Long userId);
}
