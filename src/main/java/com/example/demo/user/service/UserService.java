package com.example.demo.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.user.User;
import com.example.demo.user.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	// Get All The Users
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();  
		this.userRepository.findAll().forEach(user -> users.add(user));
		return users;
	}
	
	// Add a new User
	public User addUser(User user) {
		return this.userRepository.save(user);
	}
	
	// Update a User
	public User updateUser(User user, Integer userId) {
		return this.userRepository.save(user);
	}
	
	// Delete a User
	public void deleteUser(Integer userId) {
		this.userRepository.deleteById(userId);
	}
	
	// find a User
	public  User getUser(Integer userId) {
		return this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User with ID [" + String.valueOf(userId) + "] not found"));
	}
	
	
}

