package com.mediateca.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String URL = "jdbc:mysql://localhost:3306/dbgestionmediatica"; // Cambia según tu motor de BD
    private static final String USER = "root";  // Usuario de la base de datos
    private static final String PASSWORD = "";  // Contraseña del usuario

    // Método para obtener la conexión
    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            // Registrar el driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Obtener la conexión
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a la base de datos");
        } catch (ClassNotFoundException e) {
            System.err.println("Error al registrar el driver: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error de conexión a la base de datos: " + e.getMessage());
            throw e; // Lanzar excepción para manejarla en la lógica de negocio
        }
        return connection;
    }

    // Método para cerrar la conexión
    public static void cerrarConexion(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexión cerrada correctamente");
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}
