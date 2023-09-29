package com.example.userapp.model.dto;

public class UserDTO {

    private String nombreDeUsuario;
    private String correoElectronico;
    private String clave;

    public UserDTO() {
    }

    public UserDTO(String nombreDeUsuario, String correoElectronico, String clave) {
        this.nombreDeUsuario = nombreDeUsuario;
        this.correoElectronico = correoElectronico;
        this.clave = clave;
    }

    public String getNombreDeUsuario() {
        return nombreDeUsuario;
    }

    public void setNombreDeUsuario(String nombreDeUsario) {
        this.nombreDeUsuario = nombreDeUsario;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
