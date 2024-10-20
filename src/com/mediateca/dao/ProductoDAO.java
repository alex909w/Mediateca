package com.mediateca.dao;

import com.mediateca.conexion.ConexionBD;
import com.mediateca.modelo.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    public List<Producto> obtenerTodos() throws SQLException {
        List<Producto> productos = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConexionBD.getConnection();
            String sql = "SELECT * FROM Productos"; // Cambiar a 'Productos'
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int idProducto = resultSet.getInt("id_producto");
                String titulo = resultSet.getString("titulo");
                double precio = resultSet.getDouble("precio");
                int unidadesDisponibles = resultSet.getInt("unidades_disponibles");
                String estado = resultSet.getString("estado");
           

                Producto producto = new Producto(idProducto, titulo, precio, unidadesDisponibles, estado); // Incluir idTipoProducto
                productos.add(producto);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener productos: " + e.getMessage());
        } finally {
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
            if (connection != null) connection.close(); // Cerrar la conexión
        }

        return productos;
    }

    public void agregarProducto(Producto producto) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConexionBD.getConnection();
            String sql = "INSERT INTO Productos (titulo, precio, unidades_disponibles, id_tipo_producto, estado) VALUES (?, ?, ?, ?, ?)"; // Cambiar a 'Productos'
            statement = connection.prepareStatement(sql);
            statement.setString(1, producto.getTitulo());
            statement.setDouble(2, producto.getPrecio());
            statement.setInt(3, producto.getUnidadesDisponibles());
            statement.setString(5, producto.getEstado());

            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al agregar producto: " + e.getMessage());
        } finally {
            if (statement != null) statement.close();
            if (connection != null) connection.close(); // Cerrar la conexión
        }
    }

    public void actualizarProducto(Producto producto) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConexionBD.getConnection();
            String sql = "UPDATE Productos SET titulo = ?, precio = ?, unidades_disponibles = ?, id_tipo_producto = ?, estado = ? WHERE id_producto = ?"; // Cambiar a 'Productos'
            statement = connection.prepareStatement(sql);
            statement.setString(1, producto.getTitulo());
            statement.setDouble(2, producto.getPrecio());
            statement.setInt(3, producto.getUnidadesDisponibles());
            statement.setString(5, producto.getEstado());
            statement.setInt(6, producto.getIdProducto());

            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al actualizar producto: " + e.getMessage());
        } finally {
            if (statement != null) statement.close();
            if (connection != null) connection.close(); // Cerrar la conexión
        }
    }

    public void eliminarProducto(int idProducto) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConexionBD.getConnection();
            String sql = "DELETE FROM Productos WHERE id_producto = ?"; // Cambiar a 'Productos'
            statement = connection.prepareStatement(sql);
            statement.setInt(1, idProducto);

            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al eliminar producto: " + e.getMessage());
        } finally {
            if (statement != null) statement.close();
            if (connection != null) connection.close(); // Cerrar la conexión
        }
    }
}
