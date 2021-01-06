package com.example.demo.product.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.product.models.ProductSku;

public interface ProductSkuRepository extends CrudRepository<ProductSku, Long> {

}
