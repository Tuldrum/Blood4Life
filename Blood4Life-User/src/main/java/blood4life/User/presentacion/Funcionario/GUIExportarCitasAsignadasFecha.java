/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package blood4life.User.presentacion.Funcionario;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import blood4life.User.domain.commands.Command;
import blood4life.User.domain.commands.FindAllCommand;
import blood4life.User.domain.commands.Invoker;
import blood4life.User.domain.services.GestorServicesImpl;
import blood4life.User.domain.services.ServicesEnum;
import blood4life.commons.domain.LugarRecogida;
import blood4life.commons.infra.Utilities;

/**
 *
 * @author UnSup
 */
public class GUIExportarCitasAsignadasFecha extends javax.swing.JFrame {
    private GestorServicesImpl ser;  
    private Invoker inv;
    private List<LugarRecogida> rec;

    /**
     * Creates new form GUIExportarCitasAsignadasFecha
     */
    public GUIExportarCitasAsignadasFecha() {
        initComponents();
        ser = new GestorServicesImpl(); 
        inv = new Invoker();
        rec = new ArrayList<LugarRecogida>();
        cargarLugares();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        listaLugares = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btnExportar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        listaLugares.setModel(new javax.swing.DefaultComboBoxModel<>());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Exportar datos de citas asignadas");

        btnExportar.setText("Exportar");
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Lugares:");

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(listaLugares, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1))))
                .addGap(65, 65, 65))
            .addGroup(layout.createSequentialGroup()
                .addGap(171, 171, 171)
                .addComponent(btnExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVolver)
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listaLugares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExportar)
                    .addComponent(btnVolver))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    @SuppressWarnings({"unchecked"})
    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        int lugarIndex = listaLugares.getSelectedIndex();
        int lugarId = -1;
        if (!rec.isEmpty() && lugarIndex > -1) {
            lugarId = rec.get(lugarIndex).getLugar_id();
        }
        try {
            List<Object> args = new ArrayList<Object>();
            Date today = Utilities.ActualDateToDateSQL();
            args.add(lugarId);
            args.add(today);
            Command cmd = new FindAllCommand(args,ser.getImpl(ServicesEnum.CitaAsignadaService));  
            inv.setCommand(cmd);
            inv.execute(); 
            FindAllCommand fcmd = (FindAllCommand) inv.getCommand(); 
            List<String> infoCitasAsignadas = (List<String>) fcmd.getList();
            if (infoCitasAsignadas.size() == 0) {
                JOptionPane.showMessageDialog(null, "No se encontraron datos para citas asignadas");
                return;
            }
            BufferedWriter writer = Files.newBufferedWriter(Paths.get("datos_citas_asignadas.csv"));
            CSVPrinter csvPrinter = new CSVPrinter(writer,
                CSVFormat.DEFAULT.withHeader("lugar","direccion","fecha","hora","documentoPaciente","nombrePaciente",
                                            "apellidoPaciente","mailPaciente","telPaciente","tipoSangre","rh").withDelimiter(','));
            for (String each : infoCitasAsignadas) {
                csvPrinter.printRecord(each);
            }
            csvPrinter.flush();
            csvPrinter.close();
            JOptionPane.showMessageDialog(null, "Se exporto el archivo exitosamente");
        } catch (Exception ex) {
            Logger.getLogger(GUIFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExportarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        GUIFuncionario nVentana = new GUIFuncionario();
        nVentana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

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
//            java.util.logging.Logger.getLogger(GUIExportarCitasAsignadasFecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(GUIExportarCitasAsignadasFecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(GUIExportarCitasAsignadasFecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(GUIExportarCitasAsignadasFecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new GUIExportarCitasAsignadasFecha().setVisible(true);
//            }
//        });
//    }
    
    @SuppressWarnings("unchecked")
    private void cargarLugares() {
        ArrayList<Object> args = new ArrayList<Object>();
        Date today = Utilities.ActualDateToDateSQL();
        Date one_day_later = Utilities.ActualDateToDateSQL();
        one_day_later.setTime(today.getTime() + Long.parseLong("2592000000")); // 86400000 = 1 day in milliseconds, 2592000000 = 30 days
        args.add(today);
        args.add(one_day_later);
        Command command = new FindAllCommand(args, ser.getImpl(ServicesEnum.LugaresServices));  
        inv.setCommand(command);
        inv.execute();
        FindAllCommand obj = (FindAllCommand) inv.getCommand(); 
        rec =  (List<LugarRecogida>) obj.getList();
        if (rec != null) {
            for (int i = 0; i < rec.size(); i++) {
                listaLugares.addItem(rec.get(i).getNombre() + " | " + rec.get(i).getDireccion());
            }
        } else {
            listaLugares.addItem("Sin lugares disponibles");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExportar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JComboBox<String> listaLugares;
    // End of variables declaration//GEN-END:variables
}
