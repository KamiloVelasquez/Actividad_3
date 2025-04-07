package app_compuw;

import javax.swing.*;
import modelo.Empleado;
import modelo.Datos;
import java.awt.*;

public class AgregarEmpleadoForm extends JFrame {
    private BDEmpleados bdEmpleados;

    public AgregarEmpleadoForm(BDEmpleados bdEmpleados) {
        this.bdEmpleados = bdEmpleados;
        initComponents();
        setTitle("Agregar Empleado");
        setSize(500, 500);
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        cbxContratoEmpleado.setModel(new javax.swing.DefaultComboBoxModel<>(
        new String[] { "Tiempo completo", "Medio tiempo", "Temporal", "Por proyecto" }));
        cbxContratoEmpleado.setFont(new java.awt.Font("Verdana", 0, 14));
        cbxContratoEmpleado.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        cbxContratoEmpleado.addActionListener(new java.awt.event.ActionListener() {
            
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxContratoEmpleadoActionPerformed(evt);
    }
});
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtnombre = new javax.swing.JLabel();
        txtApellido = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JLabel();
        txtSalario = new javax.swing.JLabel();
        TxtContrato = new javax.swing.JLabel();
        txtNombreEmpleado = new javax.swing.JTextField();
        txtApellidoEmpleado = new javax.swing.JTextField();
        txtDireccionEmpleado = new javax.swing.JTextField();
        txtTelefonoEmpleado = new javax.swing.JTextField();
        txtSalarioEmpleado = new javax.swing.JTextField();
        btnAgregarEmpleado = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtTituloAgregarEmpleado = new javax.swing.JLabel();
        btnVolverEmpleado = new javax.swing.JButton();
        cbxContratoEmpleado = new javax.swing.JComboBox<>();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtnombre.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        txtnombre.setForeground(new java.awt.Color(0, 0, 0));
        txtnombre.setText("Nombre");

        txtApellido.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        txtApellido.setForeground(new java.awt.Color(0, 0, 0));
        txtApellido.setText("Apellido");

        txtDireccion.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        txtDireccion.setForeground(new java.awt.Color(0, 0, 0));
        txtDireccion.setText("Direccion");

        txtTelefono.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        txtTelefono.setForeground(new java.awt.Color(0, 0, 0));
        txtTelefono.setText("Telefono");

        txtSalario.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        txtSalario.setForeground(new java.awt.Color(0, 0, 0));
        txtSalario.setText("Salario");

        TxtContrato.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        TxtContrato.setForeground(new java.awt.Color(0, 0, 0));
        TxtContrato.setText("Contrato");

        txtNombreEmpleado.setBackground(new java.awt.Color(255, 255, 255));
        txtNombreEmpleado.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtNombreEmpleado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtApellidoEmpleado.setBackground(new java.awt.Color(255, 255, 255));
        txtApellidoEmpleado.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtApellidoEmpleado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtDireccionEmpleado.setBackground(new java.awt.Color(255, 255, 255));
        txtDireccionEmpleado.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtDireccionEmpleado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtTelefonoEmpleado.setBackground(new java.awt.Color(255, 255, 255));
        txtTelefonoEmpleado.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtTelefonoEmpleado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtSalarioEmpleado.setBackground(new java.awt.Color(255, 255, 255));
        txtSalarioEmpleado.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtSalarioEmpleado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnAgregarEmpleado.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        btnAgregarEmpleado.setText("Agregar Empleado");
        btnAgregarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarEmpleadoActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        txtTituloAgregarEmpleado.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        txtTituloAgregarEmpleado.setText("Agregar Empleado");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(152, Short.MAX_VALUE)
                .addComponent(txtTituloAgregarEmpleado)
                .addGap(174, 174, 174))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(txtTituloAgregarEmpleado)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        btnVolverEmpleado.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        btnVolverEmpleado.setText("Volver");
        btnVolverEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverEmpleadoActionPerformed(evt);
            }
        });

        cbxContratoEmpleado.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        cbxContratoEmpleado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxContratoEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxContratoEmpleadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtnombre)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(TxtContrato)
                                .addComponent(txtDireccion)
                                .addComponent(txtSalario, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtApellido, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombreEmpleado)
                            .addComponent(txtApellidoEmpleado)
                            .addComponent(txtDireccionEmpleado)
                            .addComponent(txtTelefonoEmpleado)
                            .addComponent(txtSalarioEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                            .addComponent(cbxContratoEmpleado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(btnAgregarEmpleado)
                        .addGap(71, 71, 71)
                        .addComponent(btnVolverEmpleado)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnombre)
                    .addComponent(txtNombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellido)
                    .addComponent(txtApellidoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDireccion)
                    .addComponent(txtDireccionEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefono)
                    .addComponent(txtTelefonoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSalario)
                    .addComponent(txtSalarioEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtContrato)
                    .addComponent(cbxContratoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarEmpleado)
                    .addComponent(btnVolverEmpleado))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    
    private void btnAgregarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarEmpleadoActionPerformed
       try {
            if (validarCampos()) {
                Empleado nuevo = crearEmpleadoDesdeFormulario();
                Datos.getInstancia().agregarEmpleado(nuevo);
                
                if (bdEmpleados != null) {
                    bdEmpleados.actualizarTabla();
                }
                
                mostrarMensajeExito();
                limpiarFormulario();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, 
                "El salario debe ser un número válido", 
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean validarCampos() {
        if (txtNombreEmpleado.getText().isEmpty() || 
            //txtApellidoEmpleado.getText().isEmpty() ||
            txtDireccionEmpleado.getText().isEmpty() ||
            txtTelefonoEmpleado.getText().isEmpty() ||
            txtSalarioEmpleado.getText().isEmpty()) {
            
            JOptionPane.showMessageDialog(this, 
                "Todos los campos son obligatorios", 
                "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private Empleado crearEmpleadoDesdeFormulario() {
        return new Empleado(
            txtNombreEmpleado.getText(),
            txtApellidoEmpleado.getText(),
            txtDireccionEmpleado.getText(),
            txtTelefonoEmpleado.getText(),
            cbxContratoEmpleado.getSelectedItem().toString(),
            "General",
            Double.parseDouble(txtSalarioEmpleado.getText()),
            "Empleado",
            "General"
        );
    }

    private void mostrarMensajeExito() {
        JOptionPane.showMessageDialog(this, 
            "Empleado agregado correctamente", 
            "Éxito", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
    }

    private void limpiarFormulario() {
        txtNombreEmpleado.setText("");
        txtApellidoEmpleado.setText("");
        txtDireccionEmpleado.setText("");
        txtTelefonoEmpleado.setText("");
        txtSalarioEmpleado.setText("");
        cbxContratoEmpleado.setSelectedIndex(0);
   
    }//GEN-LAST:event_btnAgregarEmpleadoActionPerformed

    private void btnVolverEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverEmpleadoActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVolverEmpleadoActionPerformed

    private void cbxContratoEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxContratoEmpleadoActionPerformed
    String contratoSeleccionado = (String) cbxContratoEmpleado.getSelectedItem();
    
    // Asignar colores diferentes para cada ítem del contrato
    Color colorBorde = Color.BLACK;
    String mensaje = "";
    
    switch(contratoSeleccionado) {
        case "Item 1":
            colorBorde = new Color(0, 100, 0); // Verde oscuro
            mensaje = "Tiempo completo";
            break;
        case "Item 2":
            colorBorde = new Color(0, 0, 150); // Azul oscuro
            mensaje = "Medio tiempo";
            break;
        case "Item 3":
            colorBorde = new Color(150, 100, 0); // Café
            mensaje = "Temporal";
            break;
        case "Item 4":
            colorBorde = new Color(150, 0, 0); // Rojo oscuro
            mensaje = "Por proyecto";
            break;
    }
    
    // Aplicar cambios visuales
    cbxContratoEmpleado.setBorder(BorderFactory.createLineBorder(colorBorde, 2));
    
    // Mostrar mensaje de depuración en consola
    System.out.println(mensaje);
    
    // Configuración especial para Item 3 (como ejemplo)
    if (contratoSeleccionado.equals("Por proyecto")) {
        txtSalarioEmpleado.setEnabled(false);
        txtSalarioEmpleado.setText("Según convenio");
        txtSalarioEmpleado.setBackground(new Color(240, 240, 240));
    } else {
        txtSalarioEmpleado.setEnabled(true);
        if (txtSalarioEmpleado.getText().equals("Según convenio")) {
            txtSalarioEmpleado.setText("");
        }
        txtSalarioEmpleado.setBackground(Color.WHITE);
    }
    
    }//GEN-LAST:event_cbxContratoEmpleadoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TxtContrato;
    private javax.swing.JButton btnAgregarEmpleado;
    private javax.swing.JButton btnVolverEmpleado;
    private javax.swing.JComboBox<String> cbxContratoEmpleado;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel txtApellido;
    private javax.swing.JTextField txtApellidoEmpleado;
    private javax.swing.JLabel txtDireccion;
    private javax.swing.JTextField txtDireccionEmpleado;
    private javax.swing.JTextField txtNombreEmpleado;
    private javax.swing.JLabel txtSalario;
    private javax.swing.JTextField txtSalarioEmpleado;
    private javax.swing.JLabel txtTelefono;
    private javax.swing.JTextField txtTelefonoEmpleado;
    private javax.swing.JLabel txtTituloAgregarEmpleado;
    private javax.swing.JLabel txtnombre;
    // End of variables declaration//GEN-END:variables
}
