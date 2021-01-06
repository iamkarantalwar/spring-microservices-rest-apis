package com.example.demo.product.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.product.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
