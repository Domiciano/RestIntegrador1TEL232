package com.example.userapp.controller;


import com.example.userapp.model.dto.UserDTO;
import com.example.userapp.model.entity.User;
import com.example.userapp.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(maxAge = 3600)
public class UserController {


    private UserRepository repository;

    @Autowired
    public void setRepository(UserRepository repository){
        this.repository = repository;
    }

    @GetMapping("user/all")
    public ResponseEntity<?> getAll(){
        var users = repository.findAll();
        return ResponseEntity.status(200).body(users);
    }

    @PostMapping("user/create")
    public ResponseEntity<?> create(@RequestBody UserDTO user){

        //mapping
        //DTO -> Entity
        User userEntity = new User(
                0,user.getNombreDeUsuario(), user.getCorreoElectronico(), user.getClave()
        );

        //Guardamos en la base de datos
        repository.save(userEntity);

        return ResponseEntity.status(200).body(user);
    }



}
