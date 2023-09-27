package com.example.userapp.model.dto;

public class UserDTO {

    private String nombreDeUsario;
    private String correoElectronico;
    private String clave;

    public UserDTO() {
    }

    public UserDTO(String nombreDeUsario, String correoElectronico, String clave) {
        this.nombreDeUsario = nombreDeUsario;
        this.correoElectronico = correoElectronico;
        this.clave = clave;
    }

    public String getNombreDeUsario() {
        return nombreDeUsario;
    }

    public void setNombreDeUsario(String nombreDeUsario) {
        this.nombreDeUsario = nombreDeUsario;
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
