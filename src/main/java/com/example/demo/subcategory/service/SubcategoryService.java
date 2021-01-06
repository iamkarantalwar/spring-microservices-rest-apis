package com.example.demo.subcategory.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.subcategory.models.Subcategory;
import com.example.demo.subcategory.repository.SubcategoryRepository;
import com.example.demo.subcategory.request.SubcategoryStoreRequest;

@Service
public class SubcategoryService {
	
	@Autowired
	SubcategoryRepository subcategoryRepository;
		
	/**
	 * Display a listing of the resource.
	 *  
	 * @return
	 */
	public  List<Subcategory> getAllSubcategories () {
		// Make a new list of Categories
		List<Subcategory> subcategories = new ArrayList<Subcategory>();
		
		for(Subcategory subcategory: this.subcategoryRepository.findAll()) {
			subcategories.add(subcategory);
		}
		return subcategories;
	}
	
	
	/**
     * Store a newly created resource in storage.
     *
     * @param  categoryRequest
     * @return List
     */
	public Subcategory addSubcategory(SubcategoryStoreRequest subcategoryStoreRequest) {
		Subcategory subcategory = new Subcategory();		
		subcategory.setCategoryId(subcategoryStoreRequest.getCategoryId());
		subcategory.setName(subcategoryStoreRequest.getName());
		return this.subcategoryRepository.save(subcategory);
	}
	
	/**
     * Display the specified category.
     *
     * @param  
     * @return 
     */
	public Subcategory getSubcategory(Long subcategoryId) {
		return this.subcategoryRepository.findById(subcategoryId).orElseThrow(() -> new ResourceNotFoundException("Subcategory with id " + subcategoryId.toString() + " doesn't exist" ));
	}
	
	/**
     * Update the specified resource in storage.
     *
     * @param 
     * @param  
     * @return
     */
	public Subcategory updateSubcategory(SubcategoryStoreRequest subcategoryStoreRequest, Subcategory subcategory) {
		subcategory.setCategoryId(subcategoryStoreRequest.getCategoryId());
		subcategory.setName(subcategoryStoreRequest.getName());
		return this.subcategoryRepository.save(subcategory);
	}
	
	/**
    * Remove the specified resource from storage.
    *
    * @param
    * @return 
    */
	public void deleteSubcategory(Long subcategoryId) {
		this.subcategoryRepository.deleteById(subcategoryId);
	}
	
}
