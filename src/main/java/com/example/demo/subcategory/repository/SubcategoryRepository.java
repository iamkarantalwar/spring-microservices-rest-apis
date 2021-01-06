package com.example.demo.subcategory.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.category.models.Category;
import com.example.demo.subcategory.models.Subcategory;

public interface SubcategoryRepository extends CrudRepository<Subcategory, Long> {

}
