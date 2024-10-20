package com.mediateca.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static Connection connection;
    private static final String URL = "jdbc:mysql://localhost:3306/dbgestionmediatica?useSSL=false"; // Cambia esto a tu base de datos
    private static final String USER = "root"; // Cambia esto si tienes un usuario diferente
    private static final String PASSWORD = ""; // Cambia esto si tienes una contraseña

    /**
     * Obtiene una conexión a la base de datos.
     * 
     * @return Connection - la conexión a la base de datos.
     * @throws SQLException si ocurre un error al conectarse a la base de datos.
     */
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Cargar el controlador
        } catch (ClassNotFoundException e) {
            throw new SQLException("No se pudo cargar el controlador JDBC: " + e.getMessage());
        }

        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return connection;
    }

    /**
     * Cierra la conexión a la base de datos si está abierta.
     * 
     * @throws SQLException si ocurre un error al cerrar la conexión.
     */
    public static void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
