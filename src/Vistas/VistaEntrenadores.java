package Vistas;

import Entidades.Entrenador;
import Persistencia.EntrenadorData;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VistaEntrenadores extends javax.swing.JInternalFrame {

    private EntrenadorData entrenadorData;
    private Entrenador entrenador;

    public VistaEntrenadores() {
        initComponents();
        entrenadorData = new EntrenadorData();

        configurarTabla();
        cargarTabla();
    }

    //configurar tabla
    private void configurarTabla() {
        jTable1.getTableHeader().setBackground(
                new java.awt.Color(40, 167, 69)
        );

        jTable1.getTableHeader().setForeground(
                java.awt.Color.darkGray
        );

        jTable1.getTableHeader().setFont(
                new java.awt.Font("Dialog", java.awt.Font.BOLD, 15)
        );

        jTable1.getTableHeader().setPreferredSize(
                new java.awt.Dimension(0, 32)
        );
    }

    private void cargarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0);

        List<Entrenador> lista = entrenadorData.listarEntrenadores();

        for (Entrenador ent : lista) {
            modelo.addRow(new Object[]{
                ent.getDni(), ent.getApellido(), ent.getNombre(),
                ent.getEspecialidad(), ent.isEstado()
            });
        }
    }

    //VALIDACIONES
    private boolean validarFormulario() {
        String dni = txtDni.getText().trim();
        String apellido = txtApellido.getText().trim();
        String nombre = txtNombre.getText().trim();
        String especialidad = txtEspecialidad.getText().trim();

        //DNI
        if (dni.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el numero de DNI");
            txtDni.requestFocus();
            return false;
        } else {
            if (!dni.matches("[0-9]+")) {
                if (!dni.contains(".")) {
                    JOptionPane.showMessageDialog(this, "Ingrese el DNI sin puntos.");
                } else {
                    JOptionPane.showMessageDialog(this, "El DNI solo debe contener números.");
                }
                txtDni.selectAll();
                txtDni.requestFocus();
                return false;
            } else {
                if (dni.length() < 7 || dni.length() > 8) {
                    JOptionPane.showMessageDialog(this, "El DNI debe contener entre 7 y 8 números.");
                    txtDni.selectAll();
                    txtDni.requestFocus();
                    return false;
                }
            }
        }

        //APELLIDO
        if (apellido.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El apellido no puede estar vacío.");
            txtApellido.requestFocus();
            return false;
        } else {
            //Validar longitud mínima
            if (apellido.length() < 2) {
                JOptionPane.showMessageDialog(this, "El apellido debe tener al menos 2 letras.");
                txtApellido.selectAll();
                txtApellido.requestFocus();
                return false;
            } else {
                //Validar solo letras, acentos y espacios (excluye números y símbolos)
                if (!apellido.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) {
                    // Anidado para dar un mensaje específico si metió números
                    if (apellido.matches(".*\\d.*")) {
                        JOptionPane.showMessageDialog(this, "El apellido no puede contener números.");
                    } else {
                        JOptionPane.showMessageDialog(this, "El apellido no puede contener símbolos ni caracteres especiales.");
                    }
                    txtApellido.selectAll();
                    txtApellido.requestFocus();
                    return false;
                }
            }
        }

        //NOMBRE    
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El nombre no puede estar vacío.");
            txtNombre.requestFocus();
            return false;
        } else {
            //Validar longitud mínima
            if (nombre.length() < 2) {
                JOptionPane.showMessageDialog(this, "El nombre debe tener al menos 2 letras.");
                txtNombre.selectAll();
                txtNombre.requestFocus();
                return false;
            } else {
                //Validar solo letras, acentos y espacios (excluye números y símbolos)
                if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) {
                    // Anidado para dar un mensaje específico si metió números
                    if (nombre.matches(".*\\d.*")) {
                        JOptionPane.showMessageDialog(this, "El nombre no puede contener números.");
                    } else {
                        JOptionPane.showMessageDialog(this, "El nombre no puede contener símbolos ni caracteres especiales.");
                    }
                    txtNombre.selectAll();
                    txtNombre.requestFocus();
                    return false;
                }
            }
        }
        
        //ESPECIALIDAD
        if(especialidad.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar la especialidad del entrenador");
            txtEspecialidad.requestFocus();
            return false;
        }else {
            if(especialidad.length() < 2) {
                JOptionPane.showMessageDialog(this, "La especialidad debe tener al menos 2 letras");
                txtEspecialidad.requestFocus();
                return false;
            }
        }
        
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblTitulo2 = new javax.swing.JLabel();
        lblDni = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblApellido = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        lblEspecialidad = new javax.swing.JLabel();
        txtEspecialidad = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnDarDeBaja = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblTitulo3 = new javax.swing.JLabel();
        lblTitulo4 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Gestion de Entrenadores");

        jPanel1.setBackground(new java.awt.Color(33, 27, 35));

        lblTitulo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Gestion de Entrenadores");

        lblTitulo2.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        lblTitulo2.setForeground(new java.awt.Color(40, 167, 69));
        lblTitulo2.setText("DATOS PERSONALES");

        lblDni.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblDni.setForeground(new java.awt.Color(255, 255, 255));
        lblDni.setText("DNI");

        txtDni.setBackground(new java.awt.Color(52, 58, 68));
        txtDni.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDniActionPerformed(evt);
            }
        });

        lblNombre.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setText("Nombre");

        txtNombre.setBackground(new java.awt.Color(52, 58, 68));
        txtNombre.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        lblApellido.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblApellido.setForeground(new java.awt.Color(255, 255, 255));
        lblApellido.setText("Apellido");

        txtApellido.setBackground(new java.awt.Color(52, 58, 68));
        txtApellido.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        lblEspecialidad.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblEspecialidad.setForeground(new java.awt.Color(255, 255, 255));
        lblEspecialidad.setText("Especialidad");

        txtEspecialidad.setBackground(new java.awt.Color(52, 58, 68));
        txtEspecialidad.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        btnNuevo.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnGuardar.setText("Guardar");

        btnModificar.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnModificar.setText("Modificar");

        btnDarDeBaja.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnDarDeBaja.setText("Dar de Baja");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo)
                    .addComponent(lblTitulo2)
                    .addComponent(lblDni)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblApellido)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNombre)
                    .addComponent(lblNombre)
                    .addComponent(lblEspecialidad)
                    .addComponent(txtEspecialidad, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE))
                .addGap(47, 47, 47))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(btnNuevo)
                .addGap(49, 49, 49)
                .addComponent(btnGuardar)
                .addGap(56, 56, 56)
                .addComponent(btnModificar)
                .addGap(61, 61, 61)
                .addComponent(btnDarDeBaja)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTitulo2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombre, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblDni))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblApellido)
                            .addComponent(lblEspecialidad))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(97, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNuevo)
                            .addComponent(btnGuardar)
                            .addComponent(btnModificar)
                            .addComponent(btnDarDeBaja))
                        .addGap(26, 26, 26))))
        );

        jPanel2.setBackground(new java.awt.Color(33, 27, 35));

        lblTitulo3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblTitulo3.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo3.setText("Entrenadores Registrados");

        lblTitulo4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblTitulo4.setText("Buscar Por DNI o Apellido");

        txtBuscar.setBackground(new java.awt.Color(52, 58, 68));
        txtBuscar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });

        btnBuscar.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnBuscar.setText("Buscar");

        jScrollPane1.setBackground(new java.awt.Color(32, 36, 43));

        jTable1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "DNI", "APELLIDO", "NOMBRE", "ESPECIALIDAD", "ESTADO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitulo3)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblTitulo4)
                                .addGap(99, 99, 99)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                        .addComponent(btnBuscar)
                        .addGap(99, 99, 99))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBuscar)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblTitulo3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTitulo4))
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDniActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnDarDeBaja;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblDni;
    private javax.swing.JLabel lblEspecialidad;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTitulo2;
    private javax.swing.JLabel lblTitulo3;
    private javax.swing.JLabel lblTitulo4;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtEspecialidad;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
