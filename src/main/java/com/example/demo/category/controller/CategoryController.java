package com.example.demo.category.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.category.repository.CategoryRepository;
import com.example.demo.category.request.CategoryStoreRequest;
import com.example.demo.category.service.CategoryService;
import com.example.demo.response.DeleteResponse;

@RestController
@RequestMapping( "/api/categories" )
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping
	public ResponseEntity<?> index() {
		return ResponseEntity.ok(this.categoryService.getAllCategories());
	}
	
	@PostMapping
	public ResponseEntity<?> store(@Valid @RequestBody CategoryStoreRequest categoryStoreRequest) {
		return ResponseEntity.ok(this.categoryService.addCategory(categoryStoreRequest));
	}
	
	@GetMapping("/{categoryId}")
	public ResponseEntity<?> show(@PathVariable Long categoryId) {
		return ResponseEntity.ok(this.categoryService.getCategory(categoryId));
	}
	
	@PutMapping("/{categoryId}")
	public ResponseEntity<?> update(@PathVariable Long categoryId, @RequestBody CategoryStoreRequest categoryStoreRequest) {
		return ResponseEntity.ok(this.categoryService.updateCategory(
				categoryStoreRequest, 
				this.categoryService.getCategory(categoryId))
		);
	}
	
	@DeleteMapping("/{categoryId}")
	public ResponseEntity<?> delete(@PathVariable Long categoryId) {
		this.categoryService.deleteCategory(categoryId);
		return ResponseEntity.ok(new DeleteResponse());
	}

}
