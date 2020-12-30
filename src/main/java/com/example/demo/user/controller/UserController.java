package com.example.demo.user.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.response.SuccessResponse;
import com.example.demo.user.User;
import com.example.demo.user.repository.UserRepository;
import com.example.demo.user.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	SuccessResponse successRespone;
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping
	public List<User> index() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity show(@PathVariable("userId") int userId) {
		// FInd a user
		return ResponseEntity.status(200).body( this.userService.getUser(userId));
	}
	
	@PostMapping
	public ResponseEntity store(@Valid @RequestBody User user) {
		successRespone.setData(this.userService.addUser(user));
		successRespone.setMessage("User created successfuly.");
		return ResponseEntity.status(200).body(successRespone);
	}
	
	
}
