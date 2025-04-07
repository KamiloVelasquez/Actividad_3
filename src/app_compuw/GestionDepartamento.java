package app_compuw;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import modelo.Datos;
import modelo.Empleado;
import modelo.Departamento;

public class GestionDepartamento extends JFrame {
    
    public GestionDepartamento() {
        setTitle("Gestión de Departamentos");
        setSize(910, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        initComponents();
        configurarEventos();
        cargarDatosIniciales();
    }
    
    private void configurarEventos() {
        btnAsignarDepartamento.addActionListener(e -> asignarEmpleadoADepartamento());
        btnActualizarLista.addActionListener(e -> cargarDatosIniciales());
    }
    
private void cargarDatosIniciales() {
    DefaultTableModel modeloTabla = (DefaultTableModel) tblDepartamento.getModel();
    modeloTabla.setRowCount(0);
    
    // Cargar empleados
    chcIdEmpleado.removeAll();
    for (Empleado emp : Datos.getInstancia().getEmpleados()) {
        chcIdEmpleado.add(emp.getId() + " - " + emp.getNombre());
    }
    
    // Cargar departamentos - USANDO LA MISMA LISTA QUE BDEmpleados
    chcDepartamento.removeAll();
    String[] departamentosDisponibles = {"Ventas", "Marketing", "TI", "RRHH", "Producción"};
    for (String depto : departamentosDisponibles) {
        chcDepartamento.add(depto);
    }
    
    // Cargar datos en la tabla
    for (Departamento depto : Datos.getInstancia().getDepartamentos()) {
        Empleado emp = Datos.getInstancia().buscarEmpleado(depto.getEmpleadoId());
        String nombreEmpleado = (emp != null) ? emp.getNombre() + " " + emp.getApellido() : "No asignado";
        
        modeloTabla.addRow(new Object[]{
            depto.getId(),
            depto.getNombre(),
            depto.getEmpleadoId(),
            nombreEmpleado
        });
    }
}
    
    private void asignarEmpleadoADepartamento() {
        if (chcIdEmpleado.getSelectedItem() == null || chcDepartamento.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Seleccione un empleado y un departamento", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            // Obtener ID del empleado seleccionado
            String empleadoStr = chcIdEmpleado.getSelectedItem().toString();
            int empleadoId = Integer.parseInt(empleadoStr.split(" - ")[0]);
            
            // Obtener nombre del departamento seleccionado
            String deptoNombre = chcDepartamento.getSelectedItem().toString();
            
            // Buscar el departamento
            Departamento depto = Datos.getInstancia().buscarDepartamentoPorNombre(deptoNombre);
            if (depto == null) {
                JOptionPane.showMessageDialog(this, "Departamento no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Asignar el empleado al departamento
            depto.setEmpleadoId(empleadoId);
            
            // Actualizar la tabla
            cargarDatosIniciales();
            
            JOptionPane.showMessageDialog(this, 
                "Empleado asignado correctamente al departamento " + deptoNombre, 
                "Éxito", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, 
                "Error al asignar empleado: " + ex.getMessage(), 
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        chcIdEmpleado = new java.awt.Choice();
        chcDepartamento = new java.awt.Choice();
        btnAsignarDepartamento = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDepartamento = new javax.swing.JTable();
        btnActualizarLista = new javax.swing.JButton();
        btnVolverDepartamento = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("ID Empleado");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Departamento");

        btnAsignarDepartamento.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnAsignarDepartamento.setText("Asignar Departamento");

        tblDepartamento.setBackground(new java.awt.Color(255, 255, 255));
        tblDepartamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Empleado ID", "Nombre Empleado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblDepartamento);

        btnActualizarLista.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnActualizarLista.setText("Actualizar Lista");

        btnVolverDepartamento.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnVolverDepartamento.setText("Volver");
        btnVolverDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverDepartamentoActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel3.setText("Gestion Departamento");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(338, 338, 338)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel3)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(247, 247, 247)
                        .addComponent(btnActualizarLista, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93)
                        .addComponent(btnVolverDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chcIdEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(32, 32, 32)
                        .addComponent(chcDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(btnAsignarDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chcDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2))
                    .addComponent(chcIdEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAsignarDepartamento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizarLista)
                    .addComponent(btnVolverDepartamento))
                .addGap(25, 25, 25))
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

    private void btnVolverDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverDepartamentoActionPerformed
         this.dispose();
    }//GEN-LAST:event_btnVolverDepartamentoActionPerformed

        public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GestionDepartamento().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarLista;
    private javax.swing.JButton btnAsignarDepartamento;
    private javax.swing.JButton btnVolverDepartamento;
    private java.awt.Choice chcDepartamento;
    private java.awt.Choice chcIdEmpleado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDepartamento;
    // End of variables declaration//GEN-END:variables


}
