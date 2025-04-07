package app_compuw;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;
import modelo.Datos;
import modelo.Empleado;


public class GestionReportes extends JFrame {
    private DefaultTableModel modeloTabla;
    
    public GestionReportes() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setSize(800, 600); 
        this.setTitle("Gestión de Reportes");
        
    // Configurar el modelo de tabla
    modeloTabla = (DefaultTableModel) tblResporte.getModel();  // Cambiado de tblReporte a tblResporte
    modeloTabla.setRowCount(0); // Limpiar datos de ejemplo
        
        // Configurar acciones de los botones
        configurarAcciones();
    }
    
    private void configurarAcciones() {
        btnImprimir.addActionListener(this::imprimirReporte);
        btnVolverReportes.addActionListener(e -> this.dispose());
    }

    public void mostrarReportesCompletos() {
        limpiarTabla();
        // Configurar columnas como en la imagen
        modeloTabla.setColumnIdentifiers(new String[]{
            "Empleado Total", 
            "Empleado por Departamento", 
            "Departamento Total"
        });
        
        // Generar todos los reportes
        generarReporteTotalEmpleados();
        generarReporteEmpleadosPorDepto();
        generarReporteTotalDepartamentos();
    }
    
    private void generarReporteTotalEmpleados() {
        int total = Datos.getInstancia().getEmpleados().size();
        modeloTabla.addRow(new Object[]{"Total: " + total, "", ""});
    }
    
    private void generarReporteEmpleadosPorDepto() {
        // Contar empleados por departamento
        Map<String, Integer> conteo = new HashMap<>();
        for (Empleado emp : Datos.getInstancia().getEmpleados()) {
            String depto = emp.getDepartamento();
            conteo.put(depto, conteo.getOrDefault(depto, 0) + 1);
        }
        
        // Agregar resultados a la tabla
        for (Map.Entry<String, Integer> entry : conteo.entrySet()) {
            modeloTabla.addRow(new Object[]{"", entry.getKey() + ": " + entry.getValue(), ""});
        }
    }
    
    private void generarReporteTotalDepartamentos() {
        long total = Datos.getInstancia().getDepartamentos().size();
        modeloTabla.addRow(new Object[]{"", "", "Total: " + total});
    }
    
    private void limpiarTabla() {
        modeloTabla.setRowCount(0);
        modeloTabla.setColumnCount(0);
    }
    
private void imprimirReporte(ActionEvent evt) {
    try {
        // Usar el nombre de tabla consistente (elegir uno y mantenerlo)
        tblResporte.print(JTable.PrintMode.FIT_WIDTH); 
        
        // Alternativa con cabecera y pie de página:
        // tblResporte.print(JTable.PrintMode.FIT_WIDTH, 
        //     new MessageFormat("Reporte"), 
        //     new MessageFormat("Página {0}"));
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this,
            "Error al imprimir:\n" + ex.getMessage(),
            "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpituloReportes = new javax.swing.JPanel();
        txtReportes = new javax.swing.JLabel();
        scrlReportes = new javax.swing.JScrollPane();
        tblResporte = new javax.swing.JTable();
        jpbotones = new javax.swing.JPanel();
        btnVolverReportes = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();

        jpituloReportes.setBackground(new java.awt.Color(0, 153, 153));

        txtReportes.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        txtReportes.setText("Reportes");

        javax.swing.GroupLayout jpituloReportesLayout = new javax.swing.GroupLayout(jpituloReportes);
        jpituloReportes.setLayout(jpituloReportesLayout);
        jpituloReportesLayout.setHorizontalGroup(
            jpituloReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpituloReportesLayout.createSequentialGroup()
                .addGap(368, 368, 368)
                .addComponent(txtReportes)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpituloReportesLayout.setVerticalGroup(
            jpituloReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpituloReportesLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(txtReportes)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        scrlReportes.setBackground(new java.awt.Color(255, 255, 255));
        scrlReportes.setForeground(new java.awt.Color(255, 255, 255));
        scrlReportes.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        tblResporte.setBackground(new java.awt.Color(255, 255, 255));
        tblResporte.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Empledo Total", "Empleado por Departamento", "Departamento Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        scrlReportes.setViewportView(tblResporte);

        jpbotones.setBackground(new java.awt.Color(255, 255, 255));

        btnVolverReportes.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        btnVolverReportes.setText("Volver");

        btnImprimir.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        btnImprimir.setText("Imprimir");

        javax.swing.GroupLayout jpbotonesLayout = new javax.swing.GroupLayout(jpbotones);
        jpbotones.setLayout(jpbotonesLayout);
        jpbotonesLayout.setHorizontalGroup(
            jpbotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpbotonesLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jpbotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnImprimir)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpbotonesLayout.createSequentialGroup()
                        .addComponent(btnVolverReportes)
                        .addGap(9, 9, 9)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jpbotonesLayout.setVerticalGroup(
            jpbotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpbotonesLayout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(btnImprimir)
                .addGap(63, 63, 63)
                .addComponent(btnVolverReportes)
                .addContainerGap(96, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpituloReportes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(scrlReportes, javax.swing.GroupLayout.DEFAULT_SIZE, 723, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpbotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpituloReportes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrlReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jpbotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnVolverReportes;
    private javax.swing.JPanel jpbotones;
    private javax.swing.JPanel jpituloReportes;
    private javax.swing.JScrollPane scrlReportes;
    private javax.swing.JTable tblResporte;
    private javax.swing.JLabel txtReportes;
    // End of variables declaration//GEN-END:variables


    // Métodos públicos para generar reportes desde otros lugares
    public void mostrarReporteTotalEmpleados() {
        generarReporteTotalEmpleados();
        this.setVisible(true);
    }
    
    public void mostrarReporteEmpleadosPorDepto() {
        generarReporteEmpleadosPorDepto();
        this.setVisible(true);
    }
    
    public void mostrarReporteTotalDepartamentos() {
        generarReporteTotalDepartamentos();
        this.setVisible(true);
    }
    
}
