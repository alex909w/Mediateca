package com.mediateca.productos;

public class DVD extends Producto {
    private String director;
    private int duracion;
    private String genero;

    public DVD(int idProducto, String titulo, double precio, int unidadesDisponibles, String estado,
               String director, int duracion, String genero) {
        super(idProducto, titulo, precio, unidadesDisponibles, estado);
        this.director = director;
        this.duracion = duracion;
        this.genero = genero;
    }

    String getDirector() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    int getDuracion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    String getGenero() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
