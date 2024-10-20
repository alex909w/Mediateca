package com.mediateca.modelo;

import java.sql.Time;

public class DVD extends Producto {
    private String director;
    private Time duracion; // Cambiado a Time
    private String genero; // Añadido el campo 'genero'

    public DVD(int idProducto, String codigoIdentificacion, String director, Time duracion, String genero) {
        super(idProducto, codigoIdentificacion); // Llama al constructor de la clase base
        this.director = director;
        this.duracion = duracion;
        this.genero = genero; // Inicializa el nuevo campo 'genero'
    }

    // Getters y setters
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Time getDuracion() {
        return duracion;
    }

    public void setDuracion(Time duracion) {
        this.duracion = duracion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
