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

        String filtro = cmbEstado.getSelectedItem().toString();

        List<Entrenador> lista = entrenadorData.listarEntrenadoresPorEstado(filtro);

        for (Entrenador ent : lista) {
            modelo.addRow(new Object[]{
                ent.getDni(),
                ent.getApellido(),
                ent.getNombre(),
                ent.getEspecialidad(),
                ent.isEstado() ? "Activo" : "Inactivo"
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
        if (especialidad.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar la especialidad del entrenador");
            txtEspecialidad.requestFocus();
            return false;
        } else {
            if (especialidad.length() < 2) {
                JOptionPane.showMessageDialog(this, "La especialidad debe tener al menos 2 letras");
                txtEspecialidad.requestFocus();
                return false;
            }
        }

        return true;
    }

    //METODO BOTON NUEVO
    private void limpiarFormulario() {
        txtDni.setText("");
        txtApellido.setText("");
        txtNombre.setText("");
        txtEspecialidad.setText("");

        entrenador = null;
    }

    //METODO GUARDAR
    private void guardarEntrenador() {
        //datos del formulario
        String dni = txtDni.getText().trim();
        String apellido = txtApellido.getText().trim();
        String nombre = txtNombre.getText().trim();
        String especialidad = txtEspecialidad.getText().trim();

        //creo entrenador
        Entrenador e = new Entrenador();
        e.setDni(dni);
        e.setNombre(nombre);
        e.setApellido(apellido);
        e.setEspecialidad(especialidad);
        e.setEstado(true);

        //guardar en BD
        entrenadorData.guardarEntrenador(e);

        cargarTabla();
        limpiarFormulario();
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
        cmbEstado = new javax.swing.JComboBox<>();

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
        txtDni.setForeground(java.awt.Color.white);
        txtDni.setCaretColor(new java.awt.Color(255, 255, 255));
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
        txtNombre.setForeground(java.awt.Color.white);
        txtNombre.setCaretColor(new java.awt.Color(255, 255, 255));

        lblApellido.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblApellido.setForeground(new java.awt.Color(255, 255, 255));
        lblApellido.setText("Apellido");

        txtApellido.setBackground(new java.awt.Color(52, 58, 68));
        txtApellido.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtApellido.setForeground(java.awt.Color.white);
        txtApellido.setCaretColor(new java.awt.Color(255, 255, 255));

        lblEspecialidad.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblEspecialidad.setForeground(new java.awt.Color(255, 255, 255));
        lblEspecialidad.setText("Especialidad");

        txtEspecialidad.setBackground(new java.awt.Color(52, 58, 68));
        txtEspecialidad.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtEspecialidad.setForeground(java.awt.Color.white);
        txtEspecialidad.setCaretColor(new java.awt.Color(255, 255, 255));

        btnNuevo.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnModificar.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnDarDeBaja.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnDarDeBaja.setText("Dar de Baja");
        btnDarDeBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDarDeBajaActionPerformed(evt);
            }
        });

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
                .addContainerGap(316, Short.MAX_VALUE))
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

        lblTitulo4.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        lblTitulo4.setForeground(new java.awt.Color(40, 167, 69));
        lblTitulo4.setText("Buscar Por DNI o Apellido");

        txtBuscar.setBackground(new java.awt.Color(52, 58, 68));
        txtBuscar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtBuscar.setForeground(java.awt.Color.white);
        txtBuscar.setCaretColor(new java.awt.Color(255, 255, 255));
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });

        btnBuscar.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(32, 36, 43));

        jTable1.setBackground(new java.awt.Color(52, 58, 68));
        jTable1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTable1.setForeground(java.awt.Color.white);
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
        jTable1.setGridColor(new java.awt.Color(89, 98, 115));
        jTable1.setRowHeight(24);
        jTable1.setSelectionBackground(new java.awt.Color(40, 120, 200));
        jTable1.setSelectionForeground(java.awt.Color.white);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
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

        cmbEstado.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Activos", "Inactivos" }));
        cmbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEstadoActionPerformed(evt);
            }
        });

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
                                .addGap(57, 57, 57)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(btnBuscar)
                                .addGap(28, 28, 28)
                                .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBuscar)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblTitulo3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTitulo4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
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
        limpiarFormulario();

        jTable1.clearSelection();
        txtDni.requestFocus();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (!validarFormulario()) {
            return;
        }

        guardarEntrenador();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnDarDeBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDarDeBajaActionPerformed
        if (entrenador == null) {
            JOptionPane.showMessageDialog(this,
                    "Debe seleccionar un entrenador.");
            return;
        }

        int opcion = JOptionPane.showConfirmDialog(
                this,
                entrenador.isEstado()
                ? "¿Desea dar de baja a este entrenador?"
                : "¿Desea dar de alta a este entrenador?",
                "Confirmar operación",
                JOptionPane.YES_NO_OPTION
        );

        if (opcion == JOptionPane.YES_OPTION) {

            if (entrenador.isEstado()) {
                entrenadorData.bajaEntrenador(entrenador.getIdEntrenador());
            } else {
                entrenadorData.altaEntrenador(entrenador.getIdEntrenador());
            }

            cargarTabla();
            limpiarFormulario();
            btnDarDeBaja.setText("Dar de baja");
        }
    }//GEN-LAST:event_btnDarDeBajaActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int fila = jTable1.getSelectedRow();

        if (fila != -1) {
            String dni = jTable1.getValueAt(fila, 0).toString();

            entrenador = entrenadorData.buscarPorDni(dni);

            if (entrenador != null) {
                txtDni.setText(entrenador.getDni());
                txtApellido.setText(entrenador.getApellido());
                txtNombre.setText(entrenador.getNombre());
                txtEspecialidad.setText(entrenador.getEspecialidad());
            }
            if (entrenador.isEstado()) {
                btnDarDeBaja.setText("Dar de baja");
            } else {
                btnDarDeBaja.setText("Dar de alta");
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (entrenador == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un entrenador de la tabla");
            return;
        }
        if (!validarFormulario()) {
            return;
        }

        entrenador.setDni(txtDni.getText().trim());
        entrenador.setNombre(txtNombre.getText().trim());
        entrenador.setApellido(txtApellido.getText().trim());
        entrenador.setEspecialidad(txtEspecialidad.getText().trim());

        entrenadorData.modificarEntrenador(entrenador);

        cargarTabla();
        limpiarFormulario();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String criterio = txtBuscar.getText().trim().toLowerCase();
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0);

        // Respeta el filtro del ComboBox ("Todos", "Activos", "Inactivos")
        String filtro = cmbEstado.getSelectedItem().toString();
        List<Entrenador> lista = entrenadorData.listarEntrenadoresPorEstado(filtro);

        for (Entrenador e : lista) {
            if (criterio.isEmpty()
                    || e.getDni().toLowerCase().contains(criterio)
                    || e.getApellido().toLowerCase().contains(criterio)) {
                modelo.addRow(new Object[]{
                    e.getDni(),
                    e.getApellido(),
                    e.getNombre(),
                    e.getEspecialidad(),
                    e.isEstado() ? "Activo" : "Inactivo" // Formato de texto uniforme
                });
            }
        }

        if (modelo.getRowCount() == 0) {
            JOptionPane.showMessageDialog(
                    this,
                    "No se encontró ningún entrenador que coincida con '" + criterio + "'.",
                    "Búsqueda sin resultados",
                    JOptionPane.WARNING_MESSAGE
            );
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void cmbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEstadoActionPerformed
        cargarTabla();
        limpiarFormulario();
    }//GEN-LAST:event_cmbEstadoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnDarDeBaja;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> cmbEstado;
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
