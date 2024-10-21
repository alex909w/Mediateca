package com.mediateca.ui;

import javax.swing.*;

public class ClienteUI extends JFrame {
    public ClienteUI() {
        setTitle("Cliente - Mediateca");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JButton btnComprar = new JButton("Comprar Productos");
        btnComprar.setBounds(100, 30, 200, 30);
        panel.add(btnComprar);

        JButton btnPrestar = new JButton("Prestar Productos");
        btnPrestar.setBounds(100, 70, 200, 30);
        panel.add(btnPrestar);

        JButton btnDevolver = new JButton("Devolver Productos");
        btnDevolver.setBounds(100, 110, 200, 30);
        panel.add(btnDevolver);

        add(panel);
    }
}
