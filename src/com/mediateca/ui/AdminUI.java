package com.mediateca.ui;

import com.mediateca.productos.CD;
import com.mediateca.productos.DVD;
import com.mediateca.productos.Libro;
import com.mediateca.productos.Producto;
import com.mediateca.productos.ProductoController;
import com.mediateca.productos.Revista;
import com.mediateca.transacciones.TransaccionController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class AdminUI extends JFrame {
    private ProductoController productoController = new ProductoController();
    private TransaccionController transaccionController = new TransaccionController();

    public AdminUI() {
        setTitle("Administrador - Mediateca");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));

        JButton btnComprar = new JButton("Comprar Productos");
        btnComprar.addActionListener(e -> mostrarFormularioCompra());
        panel.add(btnComprar);

        JButton btnPrestar = new JButton("Prestar Productos");
        btnPrestar.addActionListener(e -> mostrarFormularioPrestar());
        panel.add(btnPrestar);

        JButton btnDevolver = new JButton("Devolver Productos");
        btnDevolver.addActionListener(e -> mostrarFormularioDevolver());
        panel.add(btnDevolver);

        JButton btnListar = new JButton("Listar Productos");
        btnListar.addActionListener(e -> mostrarListaProductos());
        panel.add(btnListar);

        JButton btnRegistrar = new JButton("Registrar Productos");
        btnRegistrar.addActionListener(e -> mostrarFormularioRegistro());
        panel.add(btnRegistrar);

        add(panel);
    }

private void mostrarFormularioRegistro() {
    String[] tipos = {"Revista", "Libro", "DVD", "CD"};
    String tipoSeleccionado = (String) JOptionPane.showInputDialog(this, "Seleccione el tipo de producto:",
            "Registrar Producto", JOptionPane.QUESTION_MESSAGE, null, tipos, tipos[0]);

    if (tipoSeleccionado == null) {
        return; // Si el usuario cancela
    }

    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

    JTextField tituloField = new JTextField(20);
    JTextField precioField = new JTextField(20);
    JTextField unidadesField = new JTextField(20);
    JTextField estadoField = new JTextField(20);

    panel.add(new JLabel("Título:"));
    panel.add(tituloField);
    panel.add(new JLabel("Precio:"));
    panel.add(precioField);
    panel.add(new JLabel("Unidades Disponibles:"));
    panel.add(unidadesField);
    panel.add(new JLabel("Estado:"));
    panel.add(estadoField);

    int result = JOptionPane.showConfirmDialog(this, panel, "Ingrese los datos del producto", JOptionPane.OK_CANCEL_OPTION);
    
    if (result == JOptionPane.OK_OPTION) {
        Producto producto = null;
        double precio = Double.parseDouble(precioField.getText());
        int unidadesDisponibles = Integer.parseInt(unidadesField.getText());
        String estado = estadoField.getText();
        
        switch (tipoSeleccionado) {
            case "Revista":
                String editorialRevista = JOptionPane.showInputDialog("Ingrese la editorial:");
                String periodicidad = JOptionPane.showInputDialog("Ingrese la periodicidad:");
                String fechaPublicacionRevista = JOptionPane.showInputDialog("Ingrese la fecha de publicación (YYYY-MM-DD):");
                producto = new Revista(0, tituloField.getText(), precio, unidadesDisponibles, estado, editorialRevista, periodicidad, fechaPublicacionRevista);
                break;
            case "Libro":
                String autorLibro = JOptionPane.showInputDialog("Ingrese el autor:");
                int numeroPaginas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de páginas:"));
                String editorialLibro = JOptionPane.showInputDialog("Ingrese la editorial:");
                String ISBN = JOptionPane.showInputDialog("Ingrese el ISBN:");
                String fechaPublicacionLibro = JOptionPane.showInputDialog("Ingrese la fecha de publicación (YYYY-MM-DD):");
                producto = new Libro(0, tituloField.getText(), precio, unidadesDisponibles, estado, autorLibro, numeroPaginas, editorialLibro, ISBN, fechaPublicacionLibro);
                break;
            case "DVD":
                String directorDVD = JOptionPane.showInputDialog("Ingrese el director:");
                String duracionDVDStr = JOptionPane.showInputDialog("Ingrese la duración (en minutos):");
                int duracionDVD; // Declarar una variable para la duración
                try {
                duracionDVD = Integer.parseInt(duracionDVDStr); // Convertir a int
                } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "La duración debe ser un número entero.");
                return; // Salir si la conversión falla
                }
                String generoDVD = JOptionPane.showInputDialog("Ingrese el género:");
                producto = new DVD(0, tituloField.getText(), precio, unidadesDisponibles, estado, directorDVD, duracionDVD, generoDVD);
                break;

            case "CD":
                String artistaCD = JOptionPane.showInputDialog("Ingrese el artista:");
                String generoCD = JOptionPane.showInputDialog("Ingrese el género:");
                String duracionCDStr = JOptionPane.showInputDialog("Ingrese la duración (en minutos):");
                int duracionCD; // Declarar una variable para la duración
                try {
                    duracionCD = Integer.parseInt(duracionCDStr); // Convertir a int
                } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "La duración debe ser un número entero.");
        return; // Salir si la conversión falla
    }
    int numeroCanciones = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de canciones:"));
    producto = new CD(0, tituloField.getText(), precio, unidadesDisponibles, estado, artistaCD, generoCD, duracionCD, numeroCanciones);
    break;


            default:
                return; // Salir si no se selecciona un tipo válido
        }

        productoController.registrarProducto(producto);
        JOptionPane.showMessageDialog(this, "Producto registrado exitosamente.");
    }
}


   private void mostrarListaProductos() {
    StringBuilder productos = new StringBuilder("Lista de Productos:\n");
    productoController.listarProductos().stream().forEach((producto) -> {
        productos.append(producto.toString()).append("\n");
    });
    JTextArea textArea = new JTextArea(productos.toString());
    textArea.setEditable(false);
    JOptionPane.showMessageDialog(this, new JScrollPane(textArea), "Productos", JOptionPane.INFORMATION_MESSAGE);
}


    private void mostrarFormularioCompra() {
        JPanel compraPanel = new JPanel();
        compraPanel.setLayout(new GridLayout(2, 2));

        JTextField txtIdCliente = new JTextField();
        JTextField txtIdProducto = new JTextField();

        compraPanel.add(new JLabel("ID del Cliente:"));
        compraPanel.add(txtIdCliente);
        compraPanel.add(new JLabel("ID del Producto:"));
        compraPanel.add(txtIdProducto);

        int result = JOptionPane.showConfirmDialog(this, compraPanel, "Comprar Producto", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            int idCliente = Integer.parseInt(txtIdCliente.getText());
            int idProducto = Integer.parseInt(txtIdProducto.getText());

            Producto producto = productoController.buscarProducto(idProducto);
            if (producto != null && producto.getUnidadesDisponibles() > 0) {
                transaccionController.comprarProducto(idCliente, producto);
                JOptionPane.showMessageDialog(this, "Compra realizada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(this, "Producto no encontrado o sin unidades disponibles.");
            }
        }
    }

    private void mostrarFormularioPrestar() {
        JPanel prestarPanel = new JPanel();
        prestarPanel.setLayout(new GridLayout(3, 2));

        JTextField txtIdCliente = new JTextField();
        JTextField txtIdProducto = new JTextField();
        JTextField txtFechaDevolucion = new JTextField();

        prestarPanel.add(new JLabel("ID del Cliente:"));
        prestarPanel.add(txtIdCliente);
        prestarPanel.add(new JLabel("ID del Producto:"));
        prestarPanel.add(txtIdProducto);
        prestarPanel.add(new JLabel("Fecha de Devolución (YYYY-MM-DD):"));
        prestarPanel.add(txtFechaDevolucion);

        int result = JOptionPane.showConfirmDialog(this, prestarPanel, "Prestar Producto", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            int idCliente = Integer.parseInt(txtIdCliente.getText());
            int idProducto = Integer.parseInt(txtIdProducto.getText());
            LocalDate fechaDevolucion = LocalDate.parse(txtFechaDevolucion.getText());

            Producto producto = productoController.buscarProducto(idProducto);
            if (producto != null && producto.getUnidadesDisponibles() > 0) {
                transaccionController.prestarProducto(idCliente, producto, fechaDevolucion);
                JOptionPane.showMessageDialog(this, "Producto prestado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(this, "Producto no encontrado o sin unidades disponibles.");
            }
        }
    }

    private void mostrarFormularioDevolver() {
        JPanel devolverPanel = new JPanel();
        devolverPanel.setLayout(new GridLayout(2, 2));

        JTextField txtIdCliente = new JTextField();
        JTextField txtIdProducto = new JTextField();

        devolverPanel.add(new JLabel("ID del Cliente:"));
        devolverPanel.add(txtIdCliente);
        devolverPanel.add(new JLabel("ID del Producto:"));
        devolverPanel.add(txtIdProducto);

        int result = JOptionPane.showConfirmDialog(this, devolverPanel, "Devolver Producto", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            int idCliente = Integer.parseInt(txtIdCliente.getText());
            int idProducto = Integer.parseInt(txtIdProducto.getText());

            Producto producto = productoController.buscarProducto(idProducto);
            if (producto != null) {
                transaccionController.devolverProducto(idCliente, producto);
                JOptionPane.showMessageDialog(this, "Producto devuelto exitosamente.");
            } else {
                JOptionPane.showMessageDialog(this, "Producto no encontrado.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AdminUI adminUI = new AdminUI();
            adminUI.setVisible(true);
        });
    }
}
