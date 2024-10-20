package com.mediateca.modelo;

public class CD extends Producto {
    private String artista;
    private String genero;

    public CD(int idProducto, String titulo, double precio, int unidadesDisponibles, String estado, String artista, String genero) {
        super(idProducto, titulo, precio, unidadesDisponibles, estado);
        this.artista = artista;
        this.genero = genero;
    }

    // Getters y setters
    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
