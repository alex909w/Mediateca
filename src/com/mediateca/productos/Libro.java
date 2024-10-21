package com.mediateca.productos;

public class Libro extends Producto {
    private final String autorLibro;
    private final int numeroPaginas;
    private final String editorialLibro;
    private final String ISBN;
    private final String fechaPublicacion;

    public Libro(int idProducto, String titulo, double precio, int unidadesDisponibles, String estado,
                 String autorLibro, int numeroPaginas, String editorialLibro, String ISBN, String fechaPublicacion) {
        super(idProducto, titulo, precio, unidadesDisponibles, estado);
        this.autorLibro = autorLibro;
        this.numeroPaginas = numeroPaginas;
        this.editorialLibro = editorialLibro;
        this.ISBN = ISBN;
        this.fechaPublicacion = fechaPublicacion;
    }

    // Getters y setters (si es necesario)

    String getAutor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    int getNumeroPaginas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    String getEditorial() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    String getISBN() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    String getFechaPublicacion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
