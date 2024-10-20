package com.mediateca.modelo;

public class Libro extends Producto {
    private String autor;
    private String editorial;
    private String isbn;

    public Libro(int idProducto, String titulo, double precio, int unidadesDisponibles, String estado, String autor, String editorial, String isbn) {
        super(idProducto, titulo, precio, unidadesDisponibles, estado);
        this.autor = autor;
        this.editorial = editorial;
        this.isbn = isbn;
    }

    // Getters y setters
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
