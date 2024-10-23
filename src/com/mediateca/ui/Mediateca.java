package com.mediateca.ui;

import com.mediateca.bd.ConexionBD;
import com.mediateca.ui.AdminMenu;
import com.mediateca.ui.ClienteMenu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class Mediateca extends javax.swing.JFrame {
    
public Mediateca() {
        initComponents();
    }
    
public boolean verificarUsuario(String username) 
{
    Connection connection = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    boolean usuarioExiste = false;
    
    String sql = "SELECT COUNT(*) FROM usuarios WHERE username = ?";
    
    try {
        connection = ConexionBD.getConnection(); // Obtener la conexión
        ps = connection.prepareStatement(sql);
        ps.setString(1, username);  // Establecer el valor del parámetro (nombre de usuario)
        rs = ps.executeQuery();
        
        if (rs.next()) {
            int count = rs.getInt(1);  // Obtener el número de coincidencias
            usuarioExiste = (count > 0);  // Si es mayor que 0, el usuario existe
        }
        
    } catch (SQLException e) {
        System.err.println("Error al verificar el usuario: " + e.getMessage());
    } finally {
        // Cerrar los recursos
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            ConexionBD.cerrarConexion(connection);
        } catch (SQLException e) {
            System.err.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
    
    return usuarioExiste;
}    

public class ResultadoLogin {
    private boolean credencialesValidas;
    private String tipoUsuario;
    private String nombre; // Agregar el campo nombre

    public ResultadoLogin(boolean credencialesValidas, String tipoUsuario, String nombre) {
        this.credencialesValidas = credencialesValidas;
        this.tipoUsuario = tipoUsuario;
        this.nombre = nombre; // Inicializar el nombre
    }

    public boolean isCredencialesValidas() {
        return credencialesValidas;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public String getNombre() { // Método para obtener el nombre
        return nombre;
    }
}


public ResultadoLogin verificarCredenciales(String username, String password) {
    Connection connection = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    boolean credencialesValidas = false;
    String tipoUsuario = null;
    String nombre = null; // Variable para almacenar el nombre

    String sql = "SELECT password, tipo_usuario, nombre FROM usuarios WHERE username = ?"; // Asegúrate de que la consulta incluya el nombre

    try {
        connection = ConexionBD.getConnection();
        ps = connection.prepareStatement(sql);
        ps.setString(1, username);
        rs = ps.executeQuery();

        if (rs.next()) {
            String passwordEnBD = rs.getString("password");
            credencialesValidas = passwordEnBD.equals(password);
            tipoUsuario = rs.getString("tipo_usuario");
            nombre = rs.getString("nombre"); // Obtener el nombre
        }
    } catch (SQLException e) {
        System.err.println("Error al verificar las credenciales: " + e.getMessage());
    } finally {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            ConexionBD.cerrarConexion(connection);
        } catch (SQLException e) {
            System.err.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }

    return new ResultadoLogin(credencialesValidas, tipoUsuario, nombre); // Devolver el nombre
}





    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        User = new javax.swing.JTextField();
        Inicio = new javax.swing.JButton();
        Password = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel1.setText("BIENVENIDO");

        jLabel2.setText("USUARIO:");

        jLabel3.setText("CONTRASEÑA:");

        User.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserActionPerformed(evt);
            }
        });

        Inicio.setText("ENTRAR");
        Inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InicioActionPerformed(evt);
            }
        });

        Password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jLabel1)
                        .addGap(0, 6, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(User)
                            .addComponent(Password))))
                .addGap(122, 122, 122))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(User, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(38, 38, 38)
                .addComponent(Inicio)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserActionPerformed
            Password.requestFocus();
    }//GEN-LAST:event_UserActionPerformed

    private void PasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordActionPerformed
                Inicio.doClick();
    }//GEN-LAST:event_PasswordActionPerformed
           
    private void InicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InicioActionPerformed
    // Captura el nombre de usuario y la contraseña
    String username = User.getText(); // Obtiene el nombre de usuario del JTextField
    char[] passwordArray = Password.getPassword(); // Obtiene la contraseña del JPasswordField
    String password = new String(passwordArray); // Convierte el arreglo de caracteres a String

    // Verificar las credenciales
    ResultadoLogin resultado = verificarCredenciales(username, password); // Llama al método para verificar credenciales

    if (resultado.isCredencialesValidas()) {
    // Mostrar mensaje de éxito con el nombre del usuario
    JOptionPane.showMessageDialog(this, "Bienvenido, " + resultado.getNombre(), "Éxito", JOptionPane.INFORMATION_MESSAGE);

    // Redirigir según el tipo de usuario
    if ("admin".equalsIgnoreCase(resultado.getTipoUsuario())) {
        // Si es administrador
        AdminMenu adminMenu = new AdminMenu(resultado.getNombre()); // Pasa el nombre completo
        adminMenu.setVisible(true);
    } else {
        // Si es un cliente
        ClienteMenu clienteMenu = new ClienteMenu(resultado.getNombre()); // Pasa el nombre completo
        clienteMenu.setVisible(true);
    }

    this.dispose(); // Cierra la ventana de inicio de sesión
} else {
    JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
}


    // Limpia el arreglo de caracteres de la contraseña
    Arrays.fill(passwordArray, '0'); // Reemplaza los caracteres de la contraseña por '0'
    }//GEN-LAST:event_InicioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Mediateca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mediateca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mediateca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mediateca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Mediateca().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Inicio;
    private javax.swing.JPasswordField Password;
    private javax.swing.JTextField User;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
