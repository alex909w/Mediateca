package com.mediateca.usuarios;

public class Administrador extends Usuario {

    public Administrador(String nombre, String contrasena) {
        super(nombre, contrasena);
    }

    @Override
    public String getPerfil() {
        return "Administrador";
    }

    // Métodos específicos del administrador
}
