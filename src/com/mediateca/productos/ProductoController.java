package com.mediateca.productos;

import com.mediateca.bd.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductoController {

    // Método para registrar productos
    public void registrarProducto(Producto producto) {
        String query = "INSERT INTO productos (titulo, precio, unidades_disponibles, id_tipo_producto, estado) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            
            stmt.setString(1, producto.getTitulo());
            stmt.setDouble(2, producto.getPrecio());
            stmt.setInt(3, producto.getUnidadesDisponibles());
            stmt.setInt(4, getIdTipoProducto(producto)); // Método para obtener el ID del tipo de producto
            stmt.setString(5, producto.getEstado());

            stmt.executeUpdate();

            // Obtener el ID generado del producto
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int idProducto = generatedKeys.getInt(1);
                    producto.setIdProducto(idProducto); // Asignar el ID al objeto producto

                    // Insertar en la tabla correspondiente según el tipo de producto
                    insertarProductoEspecifico(producto);
                }
            }

            System.out.println("Producto registrado exitosamente");
        } catch (SQLException e) {
            System.err.println("Error al registrar el producto: " + e.getMessage());
        }
    }

    // Método para determinar el ID del tipo de producto
    private int getIdTipoProducto(Producto producto) {
        if (producto instanceof Revista) {
            return 1;
        } else if (producto instanceof Libro) {
            return 2;
        } else if (producto instanceof DVD) {
            return 3;
        } else if (producto instanceof CD) {
            return 4;
        }
        return -1; // Para manejar un tipo de producto no reconocido
    }

    // Método para insertar en la tabla correspondiente según el tipo de producto
    private void insertarProductoEspecifico(Producto producto) throws SQLException {
        if (producto instanceof Revista) {
            insertarRevista((Revista) producto);
        } else if (producto instanceof Libro) {
            insertarLibro((Libro) producto);
        } else if (producto instanceof DVD) {
            insertarDVD((DVD) producto);
        } else if (producto instanceof CD) {
            insertarCD((CD) producto);
        }
    }

    private void insertarRevista(Revista revista) throws SQLException {
        String query = "INSERT INTO revistas (id_producto, editorial, periodicidad, fecha_publicacion) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, revista.getIdProducto());
            stmt.setString(2, revista.getEditorial());
            stmt.setString(3, revista.getPeriodicidad());
            stmt.setString(4, revista.getFechaPublicacion());
            stmt.executeUpdate();
        }
    }

    private void insertarLibro(Libro libro) throws SQLException {
        String query = "INSERT INTO libros (id_producto, autor_libro, numero_paginas, editorial_libro, ISBN, fecha_publicacion) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, libro.getIdProducto());
            stmt.setString(2, libro.getAutor());
            stmt.setInt(3, libro.getNumeroPaginas());
            stmt.setString(4, libro.getEditorial());
            stmt.setString(5, libro.getISBN());
            stmt.setString(6, libro.getFechaPublicacion());
            stmt.executeUpdate();
        }
    }

    private void insertarDVD(DVD dvd) throws SQLException {
        String query = "INSERT INTO dvds (id_producto, director_dvd, duracion_dvd, genero_dvd) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, dvd.getIdProducto());
            stmt.setString(2, dvd.getDirector());
            stmt.setInt(3, dvd.getDuracion());
            stmt.setString(4, dvd.getGenero());
            stmt.executeUpdate();
        }
    }

    private void insertarCD(CD cd) throws SQLException {
        String query = "INSERT INTO cds (id_producto, artista_cd, genero_cd, duracion, numero_canciones) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, cd.getIdProducto());
            stmt.setString(2, cd.getArtista());
            stmt.setString(3, cd.getGenero());
            stmt.setInt(4, cd.getDuracion());
            stmt.setInt(5, cd.getNumeroCanciones());
            stmt.executeUpdate();
        }
    }

  // Método para listar productos
public List<Producto> listarProductos() {
    List<Producto> productos = new ArrayList<>();
    String query = "SELECT * FROM productos";
    try (Connection conn = ConexionBD.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {

        while (rs.next()) {
            Producto producto = new Producto(
                    rs.getInt("id_producto"), // Cambiado a id_producto
                    rs.getString("titulo"),
                    rs.getDouble("precio"),
                    rs.getInt("unidades_disponibles"),
                    rs.getString("estado")
            );
            productos.add(producto);
        }
    } catch (SQLException e) {
        System.err.println("Error al listar los productos: " + e.getMessage());
    }
    return productos;
}


    // Método para modificar productos
    public void modificarProducto(Producto producto) {
        String query = "UPDATE productos SET titulo = ?, precio = ?, unidades_disponibles = ?, estado = ? WHERE id_productos = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, producto.getTitulo());
            stmt.setDouble(2, producto.getPrecio());
            stmt.setInt(3, producto.getUnidadesDisponibles());
            stmt.setString(4, producto.getEstado());
            stmt.setInt(5, producto.getIdProducto());

            stmt.executeUpdate();
            System.out.println("Producto modificado exitosamente");
        } catch (SQLException e) {
            System.err.println("Error al modificar el producto: " + e.getMessage());
        }
    }

    // Método para eliminar productos
    public void eliminarProducto(int idProducto) {
        String query = "DELETE FROM productos WHERE id_productos = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setInt(1, idProducto);
            stmt.executeUpdate();
            System.out.println("Producto eliminado exitosamente");
        } catch (SQLException e) {
            System.err.println("Error al eliminar el producto: " + e.getMessage());
        }
    }

    // Método para buscar productos
public Producto buscarProducto(int idProducto) {
    Producto producto = null;
    String query = "SELECT * FROM productos WHERE id_productos = ?"; // Asegúrate que la columna en la base de datos se llama id_productos
    try (Connection conn = ConexionBD.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {
        
        stmt.setInt(1, idProducto);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            producto = new Producto(
                    rs.getInt("id_productos"), // Cambia aquí también si necesitas usar id_producto
                    rs.getString("titulo"),
                    rs.getDouble("precio"),
                    rs.getInt("unidades_disponibles"),
                    rs.getString("estado")
            );
        }
    } catch (SQLException e) {
        System.err.println("Error al buscar el producto: " + e.getMessage());
    }
    return producto;
}
}
