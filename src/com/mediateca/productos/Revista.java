package com.mediateca.productos;

public class Revista extends Producto {
    private String editorial;
    private String periodicidad;
    private String fechaPublicacion;

    public Revista(int idProducto, String titulo, double precio, int unidadesDisponibles, String estado,
                   String editorial, String periodicidad, String fechaPublicacion) {
        super(idProducto, titulo, precio, unidadesDisponibles, estado);
        this.editorial = editorial;
        this.periodicidad = periodicidad;
        this.fechaPublicacion = fechaPublicacion;
    }

    String getPeriodicidad() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    String getEditorial() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    String getFechaPublicacion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
