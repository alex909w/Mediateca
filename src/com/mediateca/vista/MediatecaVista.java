package com.mediateca.vista;

import com.mediateca.controlador.MediatecaControlador;
import com.mediateca.modelo.DVD;
import com.mediateca.modelo.Producto;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;

public class MediatecaVista extends JFrame {
    private final MediatecaControlador controlador;
    private final JTextArea areaTexto;

    public MediatecaVista() {
        controlador = new MediatecaControlador();
        setTitle("Mediateca");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        add(new JScrollPane(areaTexto), BorderLayout.CENTER);

        // Panel para botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout());

        // Botón para mostrar productos
        JButton botonMostrar = new JButton("Mostrar Productos");
        botonMostrar.addActionListener(e -> mostrarProductos());
        panelBotones.add(botonMostrar);

        // Botón para agregar producto
        JButton botonAgregar = new JButton("Agregar Producto");
        botonAgregar.addActionListener(e -> seleccionarTipoProducto());
        panelBotones.add(botonAgregar);

        // Botón para actualizar producto
        JButton botonActualizar = new JButton("Actualizar Producto");
        botonActualizar.addActionListener(e -> actualizarProducto());
        panelBotones.add(botonActualizar);

        // Botón para eliminar producto
        JButton botonEliminar = new JButton("Eliminar Producto");
        botonEliminar.addActionListener(e -> eliminarProducto());
        panelBotones.add(botonEliminar);

        add(panelBotones, BorderLayout.SOUTH);
    }

    private void mostrarProductos() {
        try {
            List<Producto> productos = controlador.obtenerProductos();
            areaTexto.setText("");
            productos.forEach((producto) -> {
                areaTexto.append(producto.getTitulo() + "\n");
            });
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al obtener productos: " + ex.getMessage());
        }
    }

    private void seleccionarTipoProducto() {
        String[] opciones = {"Libro", "Revista", "CD", "DVD"};
        String tipoProducto = (String) JOptionPane.showInputDialog(this, "Elija el tipo de producto a agregar:",
                "Agregar Producto", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

        if (tipoProducto != null) {
            switch (tipoProducto) {
                case "Libro":
                    agregarLibro();
                    break;
                case "Revista":
                    agregarRevista();
                    break;
                case "CD":
                    agregarCD();
                    break;
                case "DVD":
                    agregarDVD();
                    break;
            }
        }
    }

    private void agregarLibro() {
        // Crear un cuadro de diálogo para ingresar los datos del nuevo libro
        JPanel panel = new JPanel(new GridLayout(0, 2));
        JTextField txtTitulo = new JTextField();
        JTextField txtPrecio = new JTextField();
        JTextField txtUnidades = new JTextField();
        JTextField txtEstado = new JTextField();
        JTextField txtAutor = new JTextField();
        JTextField txtNumeroPaginas = new JTextField();
        JTextField txtEditorial = new JTextField();
        JTextField txtISBN = new JTextField();
        JTextField txtFechaPublicacion = new JTextField();

        panel.add(new JLabel("Título:"));
        panel.add(txtTitulo);
        panel.add(new JLabel("Precio:"));
        panel.add(txtPrecio);
        panel.add(new JLabel("Unidades Disponibles:"));
        panel.add(txtUnidades);
        panel.add(new JLabel("Estado:"));
        panel.add(txtEstado);
        panel.add(new JLabel("Autor:"));
        panel.add(txtAutor);
        panel.add(new JLabel("Número de Páginas:"));
        panel.add(txtNumeroPaginas);
        panel.add(new JLabel("Editorial:"));
        panel.add(txtEditorial);
        panel.add(new JLabel("ISBN:"));
        panel.add(txtISBN);
        panel.add(new JLabel("Fecha Publicación (YYYY-MM-DD):"));
        panel.add(txtFechaPublicacion);

        int result = JOptionPane.showConfirmDialog(this, panel, "Agregar Libro", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                // Crear un nuevo producto y agregarlo
                Producto producto = new Producto(0, txtTitulo.getText(), Double.parseDouble(txtPrecio.getText()),
                        Integer.parseInt(txtUnidades.getText()), txtEstado.getText(), 1); // ID Tipo Producto
                controlador.agregarProducto(producto);
                // Aquí deberías agregar el libro a la tabla Libros en la base de datos
                // ...
                mostrarProductos(); // Actualizar la lista
            } catch (NumberFormatException | SQLException e) {
                JOptionPane.showMessageDialog(this, "Error al agregar libro: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void agregarRevista() {
    // Crear un cuadro de diálogo para ingresar los datos de la nueva revista
    JPanel panel = new JPanel(new GridLayout(0, 2));
    JTextField txtEditorial = new JTextField();
    JTextField txtPeriodicidad = new JTextField();
    JTextField txtFechaPublicacion = new JTextField();

    panel.add(new JLabel("Editorial:"));
    panel.add(txtEditorial);
    panel.add(new JLabel("Periodicidad:"));
    panel.add(txtPeriodicidad);
    panel.add(new JLabel("Fecha Publicación (YYYY-MM-DD):"));
    panel.add(txtFechaPublicacion);

    int result = JOptionPane.showConfirmDialog(this, panel, "Agregar Revista", JOptionPane.OK_CANCEL_OPTION);
    if (result == JOptionPane.OK_OPTION) {
        try {
            // Crear un nuevo producto y agregarlo
            // Se asume que ya tienes un método en el controlador que maneja la inserción de revistas
            Producto producto = new Producto(0, "", 0.0, 0, "", 2); // ID Tipo Producto (suponiendo que 2 es para revistas)
            controlador.agregarProducto(producto); // Agregar el producto para obtener el ID generado

            // Aquí obtendrás el ID generado por el producto y usarlo para agregar la revista
            int idProductoGenerado = producto.getId(); // Asegúrate de que el ID se establezca después de agregar el producto
            
            // Agregar la revista a la base de datos
            controlador.agregarRevista(idProductoGenerado, txtEditorial.getText(), txtPeriodicidad.getText(), java.sql.Date.valueOf(txtFechaPublicacion.getText()));
            
            mostrarProductos(); // Actualizar la lista
        } catch (NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al agregar revista: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}


    private void agregarCD() {
        // Similar al método agregarLibro, pero para CDs
        // ...
    }

    private void agregarDVD() {
    // Crear un formulario para ingresar los datos del DVD
    JPanel panel = new JPanel(new GridLayout(0, 2));
    
    JTextField txtCodigoIdentificacion = new JTextField();
    JTextField txtIdProducto = new JTextField(); // Asumiendo que se genera automáticamente
    JTextField txtDirector = new JTextField();
    JTextField txtDuracion = new JTextField(); // Usar un formato de tiempo apropiado
    JTextField txtGenero = new JTextField();

    panel.add(new JLabel("Código Identificación (automático):"));
    panel.add(txtCodigoIdentificacion);
    panel.add(new JLabel("ID Producto (automático):"));
    panel.add(txtIdProducto);
    panel.add(new JLabel("Director:"));
    panel.add(txtDirector);
    panel.add(new JLabel("Duración (HH:MM:SS):"));
    panel.add(txtDuracion);
    panel.add(new JLabel("Género:"));
    panel.add(txtGenero);
    
    int result = JOptionPane.showConfirmDialog(this, panel, "Agregar DVD", JOptionPane.OK_CANCEL_OPTION);
    
    if (result == JOptionPane.OK_OPTION) {
        try {
            // Obtener los datos del formulario
            String codigoIdentificacion = txtCodigoIdentificacion.getText(); // No se usa en este caso, ya que se genera automáticamente
            int idProducto = Integer.parseInt(txtIdProducto.getText()); // También generado automáticamente
            String director = txtDirector.getText();
            Time duracion = Time.valueOf(txtDuracion.getText()); // Convierte a tipo TIME
            String genero = txtGenero.getText();
            
            // Crear un nuevo DVD
            DVD nuevoDVD = new DVD(idProducto, codigoIdentificacion, director, duracion, genero);
            
            // Aquí llamarías al método para guardar el nuevo DVD en la base de datos
            // dvdDAO.agregar(nuevoDVD);
            
            JOptionPane.showMessageDialog(this, "DVD agregado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un valor numérico válido para ID Producto y duración.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, "Formato de duración inválido. Use HH:MM:SS.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(this, "Error al agregar el DVD.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}


    private void actualizarProducto() {
        // Similar al método agregarProducto, pero para actualizar
        // Implementa el cuadro de diálogo para seleccionar el producto y actualizar sus datos
        // ...
    }

    private void eliminarProducto() {
        String idStr = JOptionPane.showInputDialog(this, "Ingrese ID del Producto a Eliminar:");
        if (idStr != null) {
            try {
                int idProducto = Integer.parseInt(idStr);
                controlador.eliminarProducto(idProducto);
                mostrarProductos(); // Actualizar la lista
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Error al eliminar producto: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MediatecaVista vista = new MediatecaVista();
            vista.setVisible(true);
        });
    }
}
