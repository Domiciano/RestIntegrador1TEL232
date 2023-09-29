package com.example.userapp.model.repository;

import com.example.userapp.model.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> { }
