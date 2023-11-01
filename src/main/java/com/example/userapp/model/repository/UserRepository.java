package com.example.userapp.model.repository;

import com.example.userapp.model.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, String> {


    @Query("SELECT u FROM User u WHERE u.email = :searchEmail")
    List<User> getUserByEmail(String searchEmail);

    @Query("SELECT u FROM User u WHERE u.name = :username")
    List<User> getUserByUsername(String username);

    @Query("SELECT u FROM User u WHERE u.email = :email AND u.password = :password")
    List<User> findUserByEmailAndPassword(String email, String password);
}
