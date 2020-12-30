package com.example.demo.user.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.user.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
