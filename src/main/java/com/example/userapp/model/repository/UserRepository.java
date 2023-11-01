package com.example.userapp.model.repository;

import com.example.userapp.model.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, String> {

    @Query("SELECT u FROM User u WHERE u.email = :email AND u.password = :pass")
    Optional<User> getByEmailAndPassword(String email, String pass);
}
