package com.mediateca.transacciones;

import com.mediateca.productos.Producto;

public class Transaccion {
    private int idTransaccion;
    private int idCliente;
    private int idProducto;
    private String tipoTransaccion; // Puede ser "comprar" o "prestar"
    private String fechaTransaccion;
    private String fechaDevolucion;

    public Transaccion(int idTransaccion, int idCliente, int idProducto, String tipoTransaccion,
                       String fechaTransaccion, String fechaDevolucion) {
        this.idTransaccion = idTransaccion;
        this.idCliente = idCliente;
        this.idProducto = idProducto;
        this.tipoTransaccion = tipoTransaccion;
        this.fechaTransaccion = fechaTransaccion;
        this.fechaDevolucion = fechaDevolucion;
    }
}
