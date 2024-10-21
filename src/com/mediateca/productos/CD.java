package com.mediateca.productos;

public class CD extends Producto {
    private String artista;
    private String genero;
    private int duracion;
    private int numeroCanciones;

    public CD(int idProducto, String titulo, double precio, int unidadesDisponibles, String estado,
              String artista, String genero, int duracion, int numeroCanciones) {
        super(idProducto, titulo, precio, unidadesDisponibles, estado);
        this.artista = artista;
        this.genero = genero;
        this.duracion = duracion;
        this.numeroCanciones = numeroCanciones;
    }

    String getArtista() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    String getGenero() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    int getDuracion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    int getNumeroCanciones() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
