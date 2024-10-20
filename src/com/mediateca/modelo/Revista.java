package com.mediateca.modelo;

public class Revista extends Producto {
    private int numero;
    private String periodicidad;

    public Revista(int idProducto, String titulo, double precio, int unidadesDisponibles, String estado, int numero, String periodicidad) {
        super(idProducto, titulo, precio, unidadesDisponibles, estado);
        this.numero = numero;
        this.periodicidad = periodicidad;
    }

    // Getters y setters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPeriodicidad() {
        return periodicidad;
    }

    public void setPeriodicidad(String periodicidad) {
        this.periodicidad = periodicidad;
    }
}
