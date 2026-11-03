package Vistas;

public class VistaSocios extends javax.swing.JInternalFrame {

    public VistaSocios() {
        initComponents();
        
        configurarTabla();
    }

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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFormulario = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblTitulo2 = new javax.swing.JLabel();
        lblDni = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblCorreoElectronico = new javax.swing.JLabel();
        txtCorreoElectronico = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();
        lblEdad = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        lblTelefono = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnDarDeBaja = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        spnEdad = new javax.swing.JSpinner();
        pnlPanel = new javax.swing.JPanel();
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
        setTitle("Gestion de socios");
        setPreferredSize(new java.awt.Dimension(855, 760));

        pnlFormulario.setBackground(new java.awt.Color(32, 36, 43));

        lblTitulo.setBackground(new java.awt.Color(255, 255, 255));
        lblTitulo.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("GESTIÓN DE SOCIOS");

        lblTitulo2.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        lblTitulo2.setForeground(new java.awt.Color(40, 167, 69));
        lblTitulo2.setText("DATOS PERSONALES");

        lblDni.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblDni.setForeground(new java.awt.Color(255, 255, 255));
        lblDni.setText("DNI");

        txtDni.setBackground(new java.awt.Color(52, 58, 68));
        txtDni.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtDni.setForeground(new java.awt.Color(255, 255, 255));
        txtDni.setCaretColor(new java.awt.Color(255, 255, 255));

        lblNombre.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setText("Nombre");

        txtNombre.setBackground(new java.awt.Color(52, 58, 68));
        txtNombre.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre.setCaretColor(new java.awt.Color(255, 255, 255));
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        lblCorreoElectronico.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblCorreoElectronico.setForeground(new java.awt.Color(255, 255, 255));
        lblCorreoElectronico.setText("Correo electronico");

        txtCorreoElectronico.setBackground(new java.awt.Color(52, 58, 68));
        txtCorreoElectronico.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtCorreoElectronico.setForeground(new java.awt.Color(255, 255, 255));
        txtCorreoElectronico.setCaretColor(new java.awt.Color(255, 255, 255));

        btnNuevo.setBackground(java.awt.Color.gray);
        btnNuevo.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnNuevo.setForeground(java.awt.Color.white);
        btnNuevo.setText("Nuevo");
        btnNuevo.setFocusPainted(false);

        lblEdad.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblEdad.setForeground(new java.awt.Color(255, 255, 255));
        lblEdad.setText("Edad");

        lblApellido.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblApellido.setForeground(new java.awt.Color(255, 255, 255));
        lblApellido.setText("Apellido");

        txtApellido.setBackground(new java.awt.Color(52, 58, 68));
        txtApellido.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtApellido.setForeground(new java.awt.Color(255, 255, 255));
        txtApellido.setCaretColor(new java.awt.Color(255, 255, 255));

        lblTelefono.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblTelefono.setForeground(new java.awt.Color(255, 255, 255));
        lblTelefono.setText("Telefono");

        txtTelefono.setBackground(new java.awt.Color(52, 58, 68));
        txtTelefono.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtTelefono.setForeground(new java.awt.Color(255, 255, 255));
        txtTelefono.setCaretColor(new java.awt.Color(255, 255, 255));

        btnGuardar.setBackground(new java.awt.Color(0, 88, 29));
        btnGuardar.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnGuardar.setForeground(java.awt.Color.white);
        btnGuardar.setText("Guardar");
        btnGuardar.setFocusPainted(false);

        btnModificar.setBackground(new java.awt.Color(0, 65, 134));
        btnModificar.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnModificar.setForeground(java.awt.Color.white);
        btnModificar.setText("Modificar");
        btnModificar.setFocusPainted(false);

        btnDarDeBaja.setBackground(new java.awt.Color(120, 16, 26));
        btnDarDeBaja.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        btnDarDeBaja.setForeground(java.awt.Color.white);
        btnDarDeBaja.setText("Dar de Baja");
        btnDarDeBaja.setFocusPainted(false);
        btnDarDeBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDarDeBajaActionPerformed(evt);
            }
        });

        btnLimpiar.setBackground(new java.awt.Color(204, 204, 204));
        btnLimpiar.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setFocusPainted(false);
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        spnEdad.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        spnEdad.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        javax.swing.GroupLayout pnlFormularioLayout = new javax.swing.GroupLayout(pnlFormulario);
        pnlFormulario.setLayout(pnlFormularioLayout);
        pnlFormularioLayout.setHorizontalGroup(
            pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormularioLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDni)
                    .addComponent(txtNombre)
                    .addComponent(txtCorreoElectronico)
                    .addGroup(pnlFormularioLayout.createSequentialGroup()
                        .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDni)
                            .addComponent(lblCorreoElectronico)
                            .addComponent(lblNombre)
                            .addComponent(lblTitulo2)
                            .addComponent(lblTitulo)
                            .addGroup(pnlFormularioLayout.createSequentialGroup()
                                .addComponent(btnNuevo)
                                .addGap(39, 39, 39)
                                .addComponent(btnGuardar)
                                .addGap(38, 38, 38)
                                .addComponent(btnModificar)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFormularioLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(btnDarDeBaja)
                        .addGap(41, 41, 41)
                        .addComponent(btnLimpiar))
                    .addGroup(pnlFormularioLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblEdad)
                            .addComponent(lblApellido)
                            .addComponent(lblTelefono)
                            .addComponent(txtApellido)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                            .addComponent(spnEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(15, 15, 15))
        );
        pnlFormularioLayout.setVerticalGroup(
            pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormularioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitulo2)
                .addGap(18, 18, 18)
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDni)
                    .addComponent(lblEdad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombre, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblApellido, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCorreoElectronico)
                    .addComponent(lblTelefono))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCorreoElectronico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnGuardar)
                    .addComponent(btnModificar)
                    .addComponent(btnDarDeBaja)
                    .addComponent(btnLimpiar))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pnlPanel.setBackground(new java.awt.Color(32, 36, 43));

        lblTitulo3.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        lblTitulo3.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo3.setText("SOCIOS REGISTRADOS");

        lblTitulo4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblTitulo4.setForeground(new java.awt.Color(40, 167, 69));
        lblTitulo4.setText("BUSCAR POR DNI O APELLIDO");

        txtBuscar.setBackground(new java.awt.Color(52, 58, 68));
        txtBuscar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtBuscar.setForeground(new java.awt.Color(255, 255, 255));
        txtBuscar.setCaretColor(new java.awt.Color(255, 255, 255));

        btnBuscar.setBackground(new java.awt.Color(0, 65, 134));
        btnBuscar.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnBuscar.setForeground(java.awt.Color.white);
        btnBuscar.setText("Buscar");
        btnBuscar.setFocusPainted(false);

        jScrollPane1.setBackground(new java.awt.Color(32, 36, 43));

        jTable1.setBackground(new java.awt.Color(52, 58, 68));
        jTable1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTable1.setForeground(java.awt.Color.white);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "DNI", "Nombre", "Apellido", "Edad", "Telefono", "Correo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(89, 98, 115));
        jTable1.setRowHeight(28);
        jTable1.setSelectionBackground(new java.awt.Color(40, 120, 200));
        jTable1.setSelectionForeground(java.awt.Color.white);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout pnlPanelLayout = new javax.swing.GroupLayout(pnlPanel);
        pnlPanel.setLayout(pnlPanelLayout);
        pnlPanelLayout.setHorizontalGroup(
            pnlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pnlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPanelLayout.createSequentialGroup()
                        .addComponent(lblTitulo3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlPanelLayout.createSequentialGroup()
                        .addComponent(lblTitulo4)
                        .addGap(39, 39, 39)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addComponent(btnBuscar)
                        .addGap(25, 25, 25))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        pnlPanelLayout.setVerticalGroup(
            pnlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitulo4)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnDarDeBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDarDeBajaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDarDeBajaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnDarDeBaja;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblCorreoElectronico;
    private javax.swing.JLabel lblDni;
    private javax.swing.JLabel lblEdad;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTitulo2;
    private javax.swing.JLabel lblTitulo3;
    private javax.swing.JLabel lblTitulo4;
    private javax.swing.JPanel pnlFormulario;
    private javax.swing.JPanel pnlPanel;
    private javax.swing.JSpinner spnEdad;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCorreoElectronico;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
