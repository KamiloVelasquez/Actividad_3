package app_compuw;

import javax.swing.*;
import modelo.Empleado;

public class MenuPrincipal extends JFrame {
    private Empleado empleadoAutenticado;

    public MenuPrincipal(Empleado empleado) {
        this.empleadoAutenticado = empleado;
        initComponents();
        this.setLocationRelativeTo(null);
        configurarAccionesBotones();
    }
    
    
    private void configurarAccionesBotones() {
        btnEmpleado.addActionListener(e -> {
            new BDEmpleados().setVisible(true);
        });
        
        btnDepartamento.addActionListener(e -> {
            new GestionDepartamento().setVisible(true);
        });
        
        btnReportes.addActionListener(e -> {
            new GestionReportes().setVisible(true);
        });
        
        btnSalir.addActionListener(e -> {
            System.exit(0);
        });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jpazul = new javax.swing.JPanel();
        btnEmpleado = new javax.swing.JButton();
        btnDepartamento = new javax.swing.JButton();
        btnReportes = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jpazul.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout jpazulLayout = new javax.swing.GroupLayout(jpazul);
        jpazul.setLayout(jpazulLayout);
        jpazulLayout.setHorizontalGroup(
            jpazulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 156, Short.MAX_VALUE)
        );
        jpazulLayout.setVerticalGroup(
            jpazulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        btnEmpleado.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        btnEmpleado.setText("Empleado");

        btnDepartamento.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        btnDepartamento.setText("Departamento");

        btnReportes.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        btnReportes.setText("Reportes");

        btnSalir.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        btnSalir.setText("Salir");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jpazul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnDepartamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpazul, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(btnEmpleado)
                .addGap(18, 18, 18)
                .addComponent(btnDepartamento)
                .addGap(18, 18, 18)
                .addComponent(btnReportes)
                .addGap(85, 85, 85)
                .addComponent(btnSalir)
                .addContainerGap(51, Short.MAX_VALUE))
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

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
            
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDepartamento;
    private javax.swing.JButton btnEmpleado;
    private javax.swing.JButton btnReportes;
    private javax.swing.JButton btnSalir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jpazul;
    // End of variables declaration//GEN-END:variables

}