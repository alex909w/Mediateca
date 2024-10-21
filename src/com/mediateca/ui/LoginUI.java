package com.mediateca.ui;

import com.mediateca.usuarios.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginUI extends JFrame {
    private final JTextField txtUsuario;
    private final JPasswordField txtContrasena;
    private final JButton btnLogin;

    public LoginUI() {
        setTitle("Mediateca - Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setBounds(20, 20, 80, 25);
        panel.add(lblUsuario);

        txtUsuario = new JTextField(20);
        txtUsuario.setBounds(100, 20, 165, 25);
        panel.add(txtUsuario);

        JLabel lblContrasena = new JLabel("Contraseña:");
        lblContrasena.setBounds(20, 60, 80, 25);
        panel.add(lblContrasena);

        txtContrasena = new JPasswordField(20);
        txtContrasena.setBounds(100, 60, 165, 25);
        panel.add(txtContrasena);

        btnLogin = new JButton("Ingresar");
        btnLogin.setBounds(100, 100, 165, 25);
        panel.add(btnLogin);

        // Acción al hacer clic en el botón "Ingresar"
        btnLogin.addActionListener((ActionEvent e) -> {
            autenticar();
        });

        add(panel);
    }

    private void autenticar() {
        String usuario = txtUsuario.getText();
        String contrasena = new String(txtContrasena.getPassword());

        // Validar credenciales
        if (usuario.equals("admin") && contrasena.equals("admin123")) {
            JOptionPane.showMessageDialog(this, "Bienvenido Administrador");
            new AdminUI().setVisible(true);
            this.dispose();
        } else if (usuario.equals("cliente") && contrasena.equals("cliente123")) {
            JOptionPane.showMessageDialog(this, "Bienvenido Cliente");
            new ClienteUI().setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos");
        }
    }

    public static void main(String[] args) {
        LoginUI login = new LoginUI();
        login.setVisible(true);
    }
}
