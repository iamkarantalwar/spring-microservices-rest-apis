package com.example.demo.subcategory.controller;

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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.example.demo.subcategory.models.Category;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.response.DeleteResponse;
import com.example.demo.subcategory.request.SubcategoryStoreRequest;
import com.example.demo.subcategory.service.SubcategoryService;

@RestController
@RequestMapping( "/api/subcategories" )
public class SubcategoryController {

	static final String CATEGORY_ENDPOINT = "http://127.0.0.1:8080/api/subcategories";  
	
	@Autowired
	SubcategoryService subcategoryService;
	
	private RestTemplate restTemplate;
	
	public SubcategoryController() {
		this.restTemplate = new RestTemplate();
	}
	
	
	@GetMapping
	public ResponseEntity<?> index() {
		return ResponseEntity.ok(this.subcategoryService.getAllSubcategories());
	}
	
	@PostMapping
	public ResponseEntity<?> store(@Valid @RequestBody SubcategoryStoreRequest subcategoryStoreRequest) {
		// Check if the category ID exist or not
		try {
			this.restTemplate.getForObject(CATEGORY_ENDPOINT + "/" + subcategoryStoreRequest.getCategoryId(), Category.class);
			
		// If any exception occurred then show user a message
		} catch (HttpClientErrorException e) {
			throw new ResourceNotFoundException("Category with ID ["+ subcategoryStoreRequest.getCategoryId() +"] doesn't exist.");
		}
		
		return ResponseEntity.ok(this.subcategoryService.addSubcategory(subcategoryStoreRequest));
	}
	
	@GetMapping("/{subcategoryId}")
	public ResponseEntity<?> show(@PathVariable Long subcategoryId) {
		return ResponseEntity.ok(this.subcategoryService.getSubcategory(subcategoryId));
	}
	
	@PutMapping("/{subcategoryId}")
	public ResponseEntity<?> update(@PathVariable Long subcategoryId, @RequestBody SubcategoryStoreRequest subcategoryStoreRequest) {
		// Check if the category ID exist or not
		try {
			this.restTemplate.getForObject(CATEGORY_ENDPOINT + "/" + subcategoryStoreRequest.getCategoryId(), Category.class);
			
		// If any exception occurred then show user a message
		} catch (HttpClientErrorException e) {
			throw new ResourceNotFoundException("Category with ID ["+ subcategoryStoreRequest.getCategoryId() +"] doesn't exist.");
		}
		
		return ResponseEntity.ok(this.subcategoryService.updateSubcategory(
				subcategoryStoreRequest, 
				this.subcategoryService.getSubcategory(subcategoryId)
			)
		);
	}
	
	@DeleteMapping("/{subcategoryId}")
	public ResponseEntity<?> delete(@PathVariable Long subcategoryId) {
		this.subcategoryService.deleteSubcategory(subcategoryId);
		return ResponseEntity.ok(new DeleteResponse());
	}

}
