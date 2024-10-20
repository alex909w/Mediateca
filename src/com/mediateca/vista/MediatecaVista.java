package com.mediateca.vista;

import com.mediateca.controlador.MediatecaControlador;
import com.mediateca.modelo.Producto;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class MediatecaVista extends JFrame {
    private MediatecaControlador controlador;
    private JTextArea areaTexto;

    public MediatecaVista() {
        controlador = new MediatecaControlador();
        setTitle("Mediateca");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        add(new JScrollPane(areaTexto), BorderLayout.CENTER);

        JButton botonMostrar = new JButton("Mostrar Productos");
        botonMostrar.addActionListener(e -> mostrarProductos());
        add(botonMostrar, BorderLayout.SOUTH);
    }

    private void mostrarProductos() {
        try {
            List<Producto> productos = controlador.obtenerProductos();
            areaTexto.setText("");
            for (Producto producto : productos) {
                areaTexto.append(producto.getTitulo() + "\n");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al obtener productos: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MediatecaVista vista = new MediatecaVista();
            vista.setVisible(true);
        });
    }
}
