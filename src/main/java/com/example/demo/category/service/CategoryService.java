package com.example.demo.category.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.category.models.Category;
import com.example.demo.category.repository.CategoryRepository;
import com.example.demo.category.request.CategoryStoreRequest;
import com.example.demo.exceptions.ResourceNotFoundException;

@Service
public class CategoryService {
	@Autowired
	CategoryRepository categoryRepository;
		
	/**
	 * Display a listing of the resource.
	 *  
	 * @return
	 */
	public  List<Category> getAllCategories () {
		// Make a new list of Categories
		List<Category> categories = new ArrayList<Category>();
		
		for(Category category: this.categoryRepository.findAll()) {
			categories.add(category);
		}
		return categories;
	}
	
	
	/**
     * Store a newly created resource in storage.
     *
     * @param  categoryRequest
     * @return List
     */
	public Category addCategory(CategoryStoreRequest categoryRequest) {
		Category category = new Category();
		category.setName(categoryRequest.getName());
		return this.categoryRepository.save(category);
	}
	
	/**
     * Display the specified category.
     *
     * @param  
     * @return 
     */
	public Category getCategory(Long categoryId) {
		return this.categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category with id " + categoryId.toString() + " doesn't exist" ));
	}
	
	/**
     * Update the specified resource in storage.
     *
     * @param 
     * @param  
     * @return
     */
	public Category updateCategory(CategoryStoreRequest categoryStoreRequest, Category category) {
		category.setName(categoryStoreRequest.getName());
		return this.categoryRepository.save(category);
	}
	
	/**
    * Remove the specified resource from storage.
    *
    * @param
    * @return 
    */
	public void deleteCategory(Long categoryId) {
		this.categoryRepository.deleteById(categoryId);
	}
	
}
