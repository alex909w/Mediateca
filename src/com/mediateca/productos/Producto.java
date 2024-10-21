package com.mediateca.productos;

public class Producto {
    private int idProducto;
    private String titulo;
    private double precio;
    private int unidadesDisponibles;
    private String estado;

    public Producto(int idProducto, String titulo, double precio, int unidadesDisponibles, String estado) {
        this.idProducto = idProducto;
        this.titulo = titulo;
        this.precio = precio;
        this.unidadesDisponibles = unidadesDisponibles;
        this.estado = estado;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getPrecio() {
        return precio;
    }

    public int getUnidadesDisponibles() {
        return unidadesDisponibles;
    }

    public String getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return "ID: " + idProducto + ", Título: " + titulo + ", Precio: " + precio +
               ", Unidades: " + unidadesDisponibles + ", Estado: " + estado;
    }

    void setIdProducto(int idProducto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
