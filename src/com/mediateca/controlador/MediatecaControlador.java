package com.mediateca.controlador;

import com.mediateca.dao.ProductoDAO;
import com.mediateca.modelo.Producto;

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
}
