package Vistas;

public class VistaPrincipal extends javax.swing.JFrame {

    public VistaPrincipal() {
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jmAdministracion = new javax.swing.JMenu();
        jmiSocios = new javax.swing.JMenuItem();
        jmiEntrenadores = new javax.swing.JMenuItem();
        jmiClases = new javax.swing.JMenuItem();
        jmiPases = new javax.swing.JMenuItem();
        jmiAsistencia = new javax.swing.JMenuItem();
        jmConsultas = new javax.swing.JMenu();
        jmiClasesDisp = new javax.swing.JMenuItem();
        jmiHistorialAsist = new javax.swing.JMenuItem();
        jmiEntradasRest = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jmSalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AboriGym - Sistema de Gestion");

        jMenuBar1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jmAdministracion.setText("Administracion");
        jmAdministracion.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jmiSocios.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jmiSocios.setText("Socios");
        jmAdministracion.add(jmiSocios);

        jmiEntrenadores.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jmiEntrenadores.setText("Entrenadores");
        jmAdministracion.add(jmiEntrenadores);

        jmiClases.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jmiClases.setText("Clases");
        jmAdministracion.add(jmiClases);

        jmiPases.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jmiPases.setText("Pases");
        jmAdministracion.add(jmiPases);

        jmiAsistencia.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jmiAsistencia.setText("Asistencias");
        jmiAsistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAsistenciaActionPerformed(evt);
            }
        });
        jmAdministracion.add(jmiAsistencia);

        jMenuBar1.add(jmAdministracion);

        jmConsultas.setText("Consultas");
        jmConsultas.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jmiClasesDisp.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jmiClasesDisp.setText("Clases Disponibles");
        jmConsultas.add(jmiClasesDisp);

        jmiHistorialAsist.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jmiHistorialAsist.setText("Historial de Asistencias");
        jmConsultas.add(jmiHistorialAsist);

        jmiEntradasRest.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jmiEntradasRest.setText("Entradas Restantes");
        jmConsultas.add(jmiEntradasRest);

        jMenuItem9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jMenuItem9.setText("Informe de Asistencias");
        jmConsultas.add(jMenuItem9);

        jMenuItem10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jMenuItem10.setText("jMenuItem10");
        jmConsultas.add(jMenuItem10);

        jMenuItem11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jMenuItem11.setText("jMenuItem11");
        jmConsultas.add(jMenuItem11);

        jMenuBar1.add(jmConsultas);

        jmSalir.setText("Salir");
        jmSalir.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jMenuBar1.add(jmSalir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 901, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 703, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiAsistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAsistenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmiAsistenciaActionPerformed

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
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenu jmAdministracion;
    private javax.swing.JMenu jmConsultas;
    private javax.swing.JMenu jmSalir;
    private javax.swing.JMenuItem jmiAsistencia;
    private javax.swing.JMenuItem jmiClases;
    private javax.swing.JMenuItem jmiClasesDisp;
    private javax.swing.JMenuItem jmiEntradasRest;
    private javax.swing.JMenuItem jmiEntrenadores;
    private javax.swing.JMenuItem jmiHistorialAsist;
    private javax.swing.JMenuItem jmiPases;
    private javax.swing.JMenuItem jmiSocios;
    // End of variables declaration//GEN-END:variables
}
