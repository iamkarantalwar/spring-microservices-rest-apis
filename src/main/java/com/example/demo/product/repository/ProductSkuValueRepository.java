package com.example.demo.product.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.category.models.Category;
import com.example.demo.product.models.ProductSkuValue;

public interface ProductSkuValueRepository extends CrudRepository<ProductSkuValue, Long> {

}
