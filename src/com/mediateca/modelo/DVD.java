package com.mediateca.modelo;

public class DVD extends Producto {
    private String director;
    private int duracion;

    public DVD(int idProducto, String titulo, double precio, int unidadesDisponibles, String estado, String director, int duracion) {
        super(idProducto, titulo, precio, unidadesDisponibles, estado);
        this.director = director;
        this.duracion = duracion;
    }

    // Getters y setters
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
}
