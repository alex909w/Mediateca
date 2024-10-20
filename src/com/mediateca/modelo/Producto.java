package com.mediateca.modelo;

public class Producto {
    private int idProducto;
    String titulo;
    double precio;
    int unidadesDisponibles;
    private String estado;

    public Producto(int idProducto, String titulo, double precio, int unidadesDisponibles, String estado) {
        this.idProducto = idProducto;
        this.titulo = titulo;
        this.precio = precio;
        this.unidadesDisponibles = unidadesDisponibles;
        this.estado = estado;
    }

    public Producto(int i, String text, double parseDouble, int parseInt, String text0, int parseInt0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Getters y setters
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getUnidadesDisponibles() {
        return unidadesDisponibles;
    }

    public void setUnidadesDisponibles(int unidadesDisponibles) {
        this.unidadesDisponibles = unidadesDisponibles;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
