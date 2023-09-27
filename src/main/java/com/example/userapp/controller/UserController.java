package com.example.userapp.controller;


import com.example.userapp.model.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    @PostMapping("user/create")
    public ResponseEntity<?> create(@RequestBody UserDTO user){
        return ResponseEntity.status(200).body(user);
    }



}
