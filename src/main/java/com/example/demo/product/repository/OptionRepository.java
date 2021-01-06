package com.example.demo.product.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.product.models.Option;

public interface OptionRepository extends CrudRepository<Option, Long> {

}
