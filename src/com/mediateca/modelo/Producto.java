package com.mediateca.modelo;

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

    // Getters y Setters
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

    // Otros getters y setters...
}
