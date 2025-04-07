package app_compuw;

import javax.swing.*;
import modelo.Datos;
import modelo.Empleado;

public class InicioSesion extends JFrame {
    
    public InicioSesion() {
        initComponents();
        setIconoAplicacion();
        this.setLocationRelativeTo(null);
    }
    
    private void setIconoAplicacion() {
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource("/images/inicioSesion.png"));
            this.setIconImage(icon.getImage());
        } catch (Exception e) {
            System.err.println("Error al cargar el icono: " + e.getMessage());
        }
    }
       
   private void validarUsuario() {
    String usuario = txtNombre.getText().trim();
    String contrasena = new String(txtContraseña.getPassword()).trim();
    
    if (usuario.isEmpty() || contrasena.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor complete todos los campos", 
            "Campos vacíos", JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    // Obtener instancia de Datos y validar credenciales
    Empleado empleado = Datos.getInstancia().validarCredenciales(usuario, contrasena);
    
    if (empleado != null) {
        // Crear y mostrar MenuPrincipal
        MenuPrincipal menu = new MenuPrincipal(empleado);
        menu.setVisible(true);
        this.dispose(); // Cerrar la ventana de login
    } else {
        JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos", 
            "Error de autenticación", JOptionPane.ERROR_MESSAGE);
        txtNombre.setText("");
        txtContraseña.setText("");
        txtNombre.requestFocus();
    }
}
    
    private void abrirMenuPrincipal(Empleado empleado) {
        MenuPrincipal menu = new MenuPrincipal(empleado);
        menu.setVisible(true);
        this.dispose();
    }
    
    private void mostrarErrorAutenticacion() {
        JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos", 
            "Error de autenticación", JOptionPane.ERROR_MESSAGE);
        txtNombre.setText("");
        txtContraseña.setText("");
        txtNombre.requestFocus();
    }
    
    public static void main(String[] args) {
        Datos.getInstancia();
        
        SwingUtilities.invokeLater(() -> {
            InicioSesion inicioSesion = new InicioSesion();
            inicioSesion.setVisible(true);
            inicioSesion.pack();
        });
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpInicioSesion = new javax.swing.JPanel();
        jpbandaazul = new javax.swing.JPanel();
        lblusuario = new javax.swing.JLabel();
        lblcontraseña = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtContraseña = new javax.swing.JPasswordField();
        txtIniciarSesion = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        jpInicioSesion.setBackground(new java.awt.Color(255, 255, 255));

        jpbandaazul.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout jpbandaazulLayout = new javax.swing.GroupLayout(jpbandaazul);
        jpbandaazul.setLayout(jpbandaazulLayout);
        jpbandaazulLayout.setHorizontalGroup(
            jpbandaazulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );
        jpbandaazulLayout.setVerticalGroup(
            jpbandaazulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lblusuario.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        lblusuario.setForeground(new java.awt.Color(0, 0, 0));
        lblusuario.setText("Usuario");

        lblcontraseña.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        lblcontraseña.setForeground(new java.awt.Color(0, 0, 0));
        lblcontraseña.setText("Contraseña");

        txtNombre.setBackground(new java.awt.Color(255, 255, 255));
        txtNombre.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtContraseña.setBackground(new java.awt.Color(255, 255, 255));
        txtContraseña.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtContraseña.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtIniciarSesion.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        txtIniciarSesion.setForeground(new java.awt.Color(0, 0, 0));
        txtIniciarSesion.setText("Iniciar Sesion");

        btnLogin.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpInicioSesionLayout = new javax.swing.GroupLayout(jpInicioSesion);
        jpInicioSesion.setLayout(jpInicioSesionLayout);
        jpInicioSesionLayout.setHorizontalGroup(
            jpInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpInicioSesionLayout.createSequentialGroup()
                .addComponent(jpbandaazul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jpInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpInicioSesionLayout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(txtIniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpInicioSesionLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLogin)
                        .addGap(92, 92, 92)
                        .addComponent(btnSalir))
                    .addGroup(jpInicioSesionLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jpInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblcontraseña)
                            .addComponent(lblusuario))
                        .addGap(18, 18, 18)
                        .addGroup(jpInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtContraseña, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                            .addComponent(txtNombre))))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jpInicioSesionLayout.setVerticalGroup(
            jpInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpbandaazul, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jpInicioSesionLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(txtIniciarSesion)
                .addGap(42, 42, 42)
                .addGroup(jpInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblusuario)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jpInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblcontraseña)
                    .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jpInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogin)
                    .addComponent(btnSalir))
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpInicioSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpInicioSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        validarUsuario();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnSalir;
    private javax.swing.JPanel jpInicioSesion;
    private javax.swing.JPanel jpbandaazul;
    private javax.swing.JLabel lblcontraseña;
    private javax.swing.JLabel lblusuario;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JLabel txtIniciarSesion;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

   
}





