package com.example.userapp.model.entity;

import jakarta.persistence.*;

@Entity
public class User {

    @Id
    private String id;

    private String name;

    private String email;

    private String password;


    //ToDo: Hacer Getters y Setters


    public User() {
    }

    //int: INT, int, long, short, byte, BigInt
    //decimal: FLOAT, DOUBLE, float, double
    public User(String id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
