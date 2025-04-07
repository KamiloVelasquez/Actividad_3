package app_compuw;

import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import modelo.Datos;
import modelo.Empleado;

public class BDEmpleados extends JFrame {
    private DefaultTableModel modeloTabla;

    public BDEmpleados() {
        initComponents();
        
        // Configuración inicial
        configurarTabla();
        configurarEventos(); 
        cargarDatosEjemplo();
        
        setTitle("Base de Datos Empleados");
        setSize(1200, 600);
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void configurarTabla() {
        modeloTabla = new DefaultTableModel(
            new Object[][]{},
            new String[]{"ID", "Nombre", "Apellido","Dirección", "Teléfono", "Salario", "Contrato", "Departamento"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        TablaEmpelados.setModel(modeloTabla);
    }

    private void configurarEventos() {
        
        btnAgregarEmpleado.addActionListener(e -> mostrarFormularioAgregar());
        btnBDActualizarEmpleado.addActionListener(e -> actualizarEmpleado());
        btnEliminarEmpleado.addActionListener(e -> eliminarEmpleado());
        btnBDVolver.addActionListener(e -> dispose());
    }

    private void mostrarFormularioAgregar() {
        AgregarEmpleadoForm form = new AgregarEmpleadoForm(this);
        form.setVisible(true);
    }

   
   private void actualizarEmpleado() {
    int fila = TablaEmpelados.getSelectedRow();
    if (fila == -1) {
        JOptionPane.showMessageDialog(this, "Seleccione un empleado", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Obtener datos del empleado seleccionado
    int id = (int) modeloTabla.getValueAt(fila, 0);
    Empleado empleado = Datos.getInstancia().buscarEmpleadoPorId(id);
    
    if (empleado == null) {
        JOptionPane.showMessageDialog(this, "Empleado no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Crear formulario de edición
    JPanel panel = new JPanel(new GridLayout(7, 2, 5, 5));
    
    // Campos editables
    JTextField txtNombre = new JTextField(empleado.getNombre());
    JTextField txtApellido = new JTextField(empleado.getApellido());
    JTextField txtDireccion = new JTextField(empleado.getDireccion());
    JTextField txtTelefono = new JTextField(empleado.getTelefono());
    JTextField txtSalario = new JTextField(String.valueOf(empleado.getSalario()));
    JComboBox<String> cbxContrato = new JComboBox<>(new String[]{"Tiempo completo", "Medio tiempo", "Temporal", "Por proyecto"});
    cbxContrato.setSelectedItem(empleado.getTipoContrato());
    JComboBox<String> cbxDepartamento = new JComboBox<>(new String[]{"Ventas", "Marketing", "TI", "RRHH", "Producción"});
    cbxDepartamento.setSelectedItem(empleado.getDepartamento());

    // Añadir componentes al panel
    panel.add(new JLabel("Nombre:"));
    panel.add(txtNombre);
    panel.add(new JLabel("Apellido:"));
    panel.add(txtApellido);
    panel.add(new JLabel("Dirección:"));
    panel.add(txtDireccion);
    panel.add(new JLabel("Teléfono:"));
    panel.add(txtTelefono);
    panel.add(new JLabel("Salario:"));
    panel.add(txtSalario);
    panel.add(new JLabel("Tipo de Contrato:"));
    panel.add(cbxContrato);
    panel.add(new JLabel("Departamento:"));
    panel.add(cbxDepartamento);

    int result = JOptionPane.showConfirmDialog(
        this, 
        panel, 
        "Editar Empleado", 
        JOptionPane.OK_CANCEL_OPTION, 
        JOptionPane.PLAIN_MESSAGE
    );

    if (result == JOptionPane.OK_OPTION) {
        try {
            // Validar campos
            if (txtNombre.getText().isEmpty() || txtDireccion.getText().isEmpty() || 
                txtTelefono.getText().isEmpty() || txtSalario.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Actualizar datos del empleado
            empleado.setNombre(txtNombre.getText());
            empleado.setApellido(txtApellido.getText());
            empleado.setDireccion(txtDireccion.getText());
            empleado.setTelefono(txtTelefono.getText());
            empleado.setSalario(Double.parseDouble(txtSalario.getText()));
            
            String nuevoContrato = (String) cbxContrato.getSelectedItem();
            String nuevoDepto = (String) cbxDepartamento.getSelectedItem();
            
            empleado.setTipoContrato(nuevoContrato);
            empleado.setDepartamento(nuevoDepto);

            // Actualizar la tabla - CORREGIDO: Usar índices 0-6
            modeloTabla.setValueAt(empleado.getNombre(), fila, 1);
            modeloTabla.setValueAt(empleado.getApellido(), fila, 2);
            modeloTabla.setValueAt(empleado.getDireccion(), fila, 3);
            modeloTabla.setValueAt(empleado.getTelefono(), fila, 4);
            modeloTabla.setValueAt(empleado.getSalario(), fila, 5);
            modeloTabla.setValueAt(nuevoContrato, fila, 6);
            modeloTabla.setValueAt(nuevoDepto, fila, 7); // Índice 7 para Departamento

            JOptionPane.showMessageDialog(this, "Empleado actualizado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El salario debe ser un número válido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
    
    private void eliminarEmpleado() {
        int fila = TablaEmpelados.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un empleado", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (JOptionPane.showConfirmDialog(this, 
            "¿Eliminar empleado " + modeloTabla.getValueAt(fila, 1) + "?", 
            "Confirmar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            modeloTabla.removeRow(fila);
        }
    }

    private void cargarDatosEjemplo() {
        modeloTabla.addRow(new Object[]{1, "Juan", "Pérez", "Calle 123", "123-1234", 2500, "Indefinido", "Ventas"});
    }

    public void actualizarTabla() {
        DefaultTableModel model = (DefaultTableModel) TablaEmpelados.getModel();
        model.setRowCount(0);
        
        for (Empleado emp : Datos.getInstancia().getEmpleados()) {
            Object[] row = {
                emp.getId(),
                emp.getNombre(),
                emp.getApellido(),
                emp.getDireccion(),
                emp.getTelefono(),
                emp.getSalario(),
                emp.getTipoContrato(),
                emp.getDepartamento()
            };
            model.addRow(row);
        }
    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtTitulo = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnBDVolver = new javax.swing.JButton();
        btnBDActualizarEmpleado = new javax.swing.JButton();
        btnAgregarEmpleado = new javax.swing.JButton();
        btnEliminarEmpleado = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaEmpelados = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        txtTitulo.setBackground(new java.awt.Color(0, 153, 153));

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Base Datos Empleados");

        javax.swing.GroupLayout txtTituloLayout = new javax.swing.GroupLayout(txtTitulo);
        txtTitulo.setLayout(txtTituloLayout);
        txtTituloLayout.setHorizontalGroup(
            txtTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtTituloLayout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 828, Short.MAX_VALUE)
                .addGap(128, 128, 128))
        );
        txtTituloLayout.setVerticalGroup(
            txtTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, txtTituloLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(27, 27, 27))
        );

        btnBDVolver.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnBDVolver.setText("Volver");

        btnBDActualizarEmpleado.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnBDActualizarEmpleado.setText("Actualizar Empleado");

        btnAgregarEmpleado.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnAgregarEmpleado.setText("Agregar Empleado");

        btnEliminarEmpleado.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnEliminarEmpleado.setText("Eliminar Empleado");

        TablaEmpelados.setBackground(new java.awt.Color(255, 255, 255));
        TablaEmpelados.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        TablaEmpelados.setForeground(new java.awt.Color(0, 0, 0));
        TablaEmpelados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Apellido", "Dieccion", "Telefono", "Salario", "Contrato", "Departamento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaEmpelados.setGridColor(new java.awt.Color(0, 0, 0));
        TablaEmpelados.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(TablaEmpelados);
        if (TablaEmpelados.getColumnModel().getColumnCount() > 0) {
            TablaEmpelados.getColumnModel().getColumn(0).setResizable(false);
            TablaEmpelados.getColumnModel().getColumn(1).setResizable(false);
            TablaEmpelados.getColumnModel().getColumn(3).setResizable(false);
            TablaEmpelados.getColumnModel().getColumn(4).setResizable(false);
            TablaEmpelados.getColumnModel().getColumn(5).setResizable(false);
            TablaEmpelados.getColumnModel().getColumn(6).setResizable(false);
            TablaEmpelados.getColumnModel().getColumn(7).setResizable(false);
        }

        jScrollPane1.setViewportView(jScrollPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 839, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBDActualizarEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBDVolver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAgregarEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminarEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 174, Short.MAX_VALUE)
                        .addComponent(btnAgregarEmpleado)
                        .addGap(50, 50, 50)
                        .addComponent(btnBDActualizarEmpleado)
                        .addGap(50, 50, 50)
                        .addComponent(btnEliminarEmpleado)
                        .addGap(50, 50, 50)
                        .addComponent(btnBDVolver)
                        .addGap(84, 84, 84))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1)
                        .addGap(14, 14, 14))))
        );
    }// </editor-fold>//GEN-END:initComponents


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new BDEmpleados().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaEmpelados;
    private javax.swing.JButton btnAgregarEmpleado;
    private javax.swing.JButton btnBDActualizarEmpleado;
    private javax.swing.JButton btnBDVolver;
    private javax.swing.JButton btnEliminarEmpleado;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel txtTitulo;
    // End of variables declaration//GEN-END:variables
   
 
}
