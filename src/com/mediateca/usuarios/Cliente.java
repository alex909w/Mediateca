package com.mediateca.usuarios;

public class Cliente extends Usuario {

    public Cliente(String nombre, String contrasena) {
        super(nombre, contrasena);
    }

    @Override
    public String getPerfil() {
        return "Cliente";
    }

    // Métodos específicos del cliente
}
