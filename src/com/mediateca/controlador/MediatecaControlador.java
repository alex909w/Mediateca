package com.mediateca.controlador;

import static com.mediateca.conexion.ConexionBD.getConnection;
import com.mediateca.dao.ProductoDAO;
import com.mediateca.modelo.Producto;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MediatecaControlador {
    private final ProductoDAO productoDAO;

    public MediatecaControlador() {
        productoDAO = new ProductoDAO();
    }
    public List<Producto> listarProductos() {
    try {
        return productoDAO.obtenerTodos();
    } catch (SQLException e) {
        // Manejo de excepciones
        e.printStackTrace();
        return new ArrayList<>();
    }
}

    public List<Producto> obtenerProductos() throws SQLException {
        return productoDAO.obtenerTodos();
    }

    public void agregarProducto(Producto producto) throws SQLException {
        productoDAO.agregarProducto(producto);
    }

    public void eliminarProducto(int idProducto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void agregarRevista(int idProducto, String editorial, String periodicidad, Date fechaPublicacion) throws SQLException {
    String sql = "INSERT INTO Revistas (id_producto, editorial, periodicidad, fecha_publicacion) VALUES (?, ?, ?, ?)";
    try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setInt(1, idProducto);
        pstmt.setString(2, editorial);
        pstmt.setString(3, periodicidad);
        pstmt.setDate(4, fechaPublicacion);
        pstmt.executeUpdate();
    }
}
    
}
