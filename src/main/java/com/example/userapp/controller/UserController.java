package com.example.userapp.controller;


import com.example.userapp.model.dto.UserDTO;
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
    public void setRepository(UserRepository repository){
        this.repository = repository;
    }

    @GetMapping("user/all")
    public ResponseEntity<?> getAll(@RequestHeader("Authorization") String auth){

        var user = repository.findById(auth);
        if(user.isPresent()){
            var users = repository.findAll();
            var output = new ArrayList<UserDTO>();
            users.forEach(u ->{
                output.add(
                        new UserDTO(u.getName(), u.getEmail(), u.getPassword())
                );
            });
            return ResponseEntity.status(200).body(output);
        }else{
            return ResponseEntity.status(400).body("No autorizado");
        }

    }

    @PostMapping("user/login")
    public ResponseEntity<?> login(@RequestBody UserDTO user){
        var dbuser = repository.getByEmailAndPassword(user.getCorreoElectronico(), user.getClave());
        if(dbuser.isPresent()){
            return ResponseEntity.status(200).body(dbuser.get());
        }else{
            return ResponseEntity.status(400).body("Bad credentials");
        }

    }

    @PostMapping("user/create")
    public ResponseEntity<?> create(@RequestBody UserDTO user){
        //mapping
        //DTO -> Entity
        User userEntity = new User(
                UUID.randomUUID().toString(),user.getNombreDeUsuario(), user.getCorreoElectronico(), user.getClave()
        );
        //Guardamos en la base de datos
        repository.save(userEntity);

        return ResponseEntity.status(200).body(user);
    }



}
