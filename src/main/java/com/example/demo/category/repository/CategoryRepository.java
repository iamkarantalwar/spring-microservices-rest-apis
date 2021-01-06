package com.example.demo.category.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.category.models.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
