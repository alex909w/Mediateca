package com.mediateca.modelo;

public class CD extends Producto {
    private String codigoIdentificacionCD; // Nueva propiedad
    private String artista;
    private String genero;
    private String duracion; // Cambié a String para poder representar TIME
    private int numeroCanciones;

    public CD(int idProducto, String titulo, double precio, int unidadesDisponibles, String estado, 
              String codigoIdentificacionCD, String artista, String genero, String duracion, int numeroCanciones) {
        super(idProducto, titulo, precio, unidadesDisponibles, estado);
        this.codigoIdentificacionCD = codigoIdentificacionCD;
        this.artista = artista;
        this.genero = genero;
        this.duracion = duracion;
        this.numeroCanciones = numeroCanciones;
    }

    // Getters y setters
    public String getCodigoIdentificacionCD() {
        return codigoIdentificacionCD;
    }

    public void setCodigoIdentificacionCD(String codigoIdentificacionCD) {
        if (codigoIdentificacionCD == null || codigoIdentificacionCD.trim().isEmpty()) {
            throw new IllegalArgumentException("El código de identificación del CD no puede ser nulo o vacío.");
        }
        this.codigoIdentificacionCD = codigoIdentificacionCD;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        if (artista == null || artista.trim().isEmpty()) {
            throw new IllegalArgumentException("El artista no puede ser nulo o vacío.");
        }
        this.artista = artista;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        if (genero == null || genero.trim().isEmpty()) {
            throw new IllegalArgumentException("El género no puede ser nulo o vacío.");
        }
        this.genero = genero;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        if (duracion == null || duracion.trim().isEmpty()) {
            throw new IllegalArgumentException("La duración no puede ser nula o vacía.");
        }
        this.duracion = duracion;
    }

    public int getNumeroCanciones() {
        return numeroCanciones;
    }

    public void setNumeroCanciones(int numeroCanciones) {
        if (numeroCanciones < 0) {
            throw new IllegalArgumentException("El número de canciones no puede ser negativo.");
        }
        this.numeroCanciones = numeroCanciones;
    }

    @Override
    public String toString() {
        return "CD{" +
                "codigoIdentificacionCD='" + codigoIdentificacionCD + '\'' +
                ", idProducto=" + getIdProducto() +
                ", titulo='" + getTitulo() + '\'' +
                ", precio=" + getPrecio() +
                ", unidadesDisponibles=" + getUnidadesDisponibles() +
                ", estado='" + getEstado() + '\'' +
                ", artista='" + artista + '\'' +
                ", genero='" + genero + '\'' +
                ", duracion='" + duracion + '\'' +
                ", numeroCanciones=" + numeroCanciones +
                '}';
    }
}
