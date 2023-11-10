package com.example.userapp.controller;


import com.example.userapp.model.dto.ResponseUserDTO;
import com.example.userapp.model.dto.SigninUserDTO;
import com.example.userapp.model.dto.SignupUserDTO;
import com.example.userapp.model.entity.User;
import com.example.userapp.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;

@RestController
@CrossOrigin(maxAge = 3600)
public class UserController {


    private UserRepository repository;

    @Autowired
    public void setRepository(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("user/example")
    public ResponseEntity<?> example() {
        return ResponseEntity.status(200).body("Example");
    }

    @GetMapping("user/all")
    public ResponseEntity<?> getAll(@RequestHeader("Authorization") String auth) {

        var user = repository.findById(auth);
        if (user.isPresent()) {
            var users = repository.findAll();
            var output = new ArrayList<SignupUserDTO>();
            users.forEach(u -> {
                output.add(
                        new SignupUserDTO(u.getName(), u.getEmail(), u.getPassword())
                );
            });
            return ResponseEntity.status(200).body(output);
        } else {
            return ResponseEntity.status(400).body("No autorizado");
        }

    }

    @PostMapping("user/login")
    public ResponseEntity<?> login(@RequestBody SigninUserDTO user) {
        var users = repository.findUserByEmailAndPassword(user.getEmail(), user.getPassword());
        if (users.size() > 0) {
            var response = new ResponseUserDTO(
                    users.get(0).getId(),
                    users.get(0).getName(),
                    users.get(0).getEmail()
            );
            return ResponseEntity.status(200).body(response);
        } else {
            return ResponseEntity.status(400).body("Login invalido");
        }
    }

    @PostMapping("user/create")
    public ResponseEntity<?> create(@RequestBody SignupUserDTO user) {
        var usersWithSameUsername = repository.getUserByUsername(user.getUsername());
        var usersWithSameEmail = repository.getUserByEmail(user.getEmail());
        if (usersWithSameEmail.size() > 0 || usersWithSameUsername.size() > 0) {
            return ResponseEntity.status(400).body("Usuario ya existe en dB");
        } else {
            User userEntity = new User(
                    UUID.randomUUID().toString(),
                    user.getUsername(), user.getEmail(),
                    user.getPassword()
            );
            repository.save(userEntity);
            var response = new ResponseUserDTO(
                    userEntity.getId(),
                    userEntity.getName(),
                    userEntity.getEmail()
            );
            return ResponseEntity.status(200).body(response);
        }
    }


}
