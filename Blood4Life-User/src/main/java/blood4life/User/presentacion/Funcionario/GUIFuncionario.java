/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package blood4life.User.presentacion.Funcionario;

import blood4life.User.presentacion.GUILogin;

/**
 *
 * @author cerqu
 */
public class GUIFuncionario extends javax.swing.JFrame {
    /**
     * Creates new form GUIFuncionario
     */
    public GUIFuncionario() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblFuncionario = new javax.swing.JLabel();
        bntIrSitios = new javax.swing.JButton();
        lblSitios = new javax.swing.JLabel();
        lblCitas = new javax.swing.JLabel();
        bntAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        bntVerCitasAgendadas = new javax.swing.JButton();
        lblListaDonantes = new javax.swing.JLabel();
        btnExportar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblFuncionario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblFuncionario.setText("Funcionario");

        bntIrSitios.setText("Ir");
        bntIrSitios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntIrSitiosActionPerformed(evt);
            }
        });

        lblSitios.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblSitios.setText("Sitios de recogida");

        lblCitas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblCitas.setText("Citas Agendadas");

        bntAceptar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bntAceptar.setText("Aceptar");

        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        bntVerCitasAgendadas.setText("Ir");
        bntVerCitasAgendadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntVerCitasAgendadasActionPerformed(evt);
            }
        });

        lblListaDonantes.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblListaDonantes.setText("Lista de donantes");

        btnExportar.setText("Exportar");
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(bntAceptar)
                .addGap(38, 38, 38)
                .addComponent(btnCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblFuncionario)
                .addGap(183, 183, 183))
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblSitios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCitas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblListaDonantes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnExportar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bntVerCitasAgendadas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bntIrSitios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(76, 76, 76))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(lblFuncionario)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bntIrSitios)
                    .addComponent(lblSitios))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 14, Short.MAX_VALUE)
                        .addComponent(lblCitas)
                        .addGap(18, 18, 18)
                        .addComponent(lblListaDonantes)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bntAceptar)
                            .addComponent(btnCancelar))
                        .addGap(40, 40, 40))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(bntVerCitasAgendadas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExportar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        lblFuncionario.getAccessibleContext().setAccessibleName("lblFuncionario");
        bntIrSitios.getAccessibleContext().setAccessibleName("btnDesplegarLugar");
        lblSitios.getAccessibleContext().setAccessibleName("lblSitiosRecogida");
        lblCitas.getAccessibleContext().setAccessibleName("lblCitas");
        bntAceptar.getAccessibleContext().setAccessibleName("btnAceptar");
        btnCancelar.getAccessibleContext().setAccessibleName("btnCancelar");
        bntVerCitasAgendadas.getAccessibleContext().setAccessibleName("btnDesplegarCitas");
        lblListaDonantes.getAccessibleContext().setAccessibleName("lblListaDonentes");
        btnExportar.getAccessibleContext().setAccessibleName("btnVerListDonant");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bntIrSitiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntIrSitiosActionPerformed
        GUILugares nVentana = new GUILugares();
        nVentana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bntIrSitiosActionPerformed

    private void bntVerCitasAgendadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntVerCitasAgendadasActionPerformed
        GUIVerCitas nVentana = new GUIVerCitas();
        nVentana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bntVerCitasAgendadasActionPerformed

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        GUIExportarCitasAsignadasFecha nVentana = new GUIExportarCitasAsignadasFecha();
        nVentana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnExportarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        new GUILogin().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(GUIFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(GUIFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(GUIFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(GUIFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>

//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new GUIFuncionario().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntAceptar;
    private javax.swing.JButton bntIrSitios;
    private javax.swing.JButton bntVerCitasAgendadas;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExportar;
    private javax.swing.JLabel lblCitas;
    private javax.swing.JLabel lblFuncionario;
    private javax.swing.JLabel lblListaDonantes;
    private javax.swing.JLabel lblSitios;
    // End of variables declaration//GEN-END:variables
}
