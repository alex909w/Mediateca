package com.mediateca.transacciones;

import com.mediateca.bd.ConexionBD;
import com.mediateca.productos.Producto;

import java.sql.*;
import java.time.LocalDate;

public class TransaccionController {

    // Método para comprar productos
    public void comprarProducto(int idCliente, Producto producto) {
        realizarTransaccion(idCliente, producto, "COMPRA", null);
    }

    // Método para prestar productos
    public void prestarProducto(int idCliente, Producto producto, LocalDate fechaDevolucion) {
        realizarTransaccion(idCliente, producto, "PRESTAMO", fechaDevolucion);
    }

    // Método para devolver productos
    public void devolverProducto(int idCliente, Producto producto) {
        realizarTransaccion(idCliente, producto, "DEVOLUCION", null);
    }

    // Método genérico para registrar una transacción
    private void realizarTransaccion(int idCliente, Producto producto, String tipoTransaccion, LocalDate fechaDevolucion) {
        String query = "INSERT INTO transacciones (id_cliente, id_producto, tipo_transaccion, fecha_transaccion, fecha_devolucion) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, idCliente);
            stmt.setInt(2, producto.getIdProducto());
            stmt.setString(3, tipoTransaccion);
            stmt.setDate(4, Date.valueOf(LocalDate.now()));
            stmt.setDate(5, fechaDevolucion != null ? Date.valueOf(fechaDevolucion) : null);

            stmt.executeUpdate();
            System.out.println("Transacción realizada exitosamente");
        } catch (SQLException e) {
            System.err.println("Error al realizar la transacción: " + e.getMessage());
        }
    }
}
