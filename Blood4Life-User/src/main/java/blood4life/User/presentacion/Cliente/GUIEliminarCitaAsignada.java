/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood4life.User.presentacion.Cliente;

import blood4life.User.domain.commands.Command;
import blood4life.User.domain.commands.DeleteCommand;
import blood4life.User.domain.commands.FindCommand;
import blood4life.User.domain.commands.Invoker;
import blood4life.User.domain.services.GestorServicesImpl;
import blood4life.User.domain.services.ServicesEnum;
import blood4life.commons.domain.Cita;
import blood4life.commons.domain.CitaAsignada;
import blood4life.commons.domain.UsuarioCliente;
import blood4life.commons.infra.Utilities;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class GUIEliminarCitaAsignada extends javax.swing.JFrame { 
    private Cita cita;  
    private String id_user;  
    private GestorServicesImpl ser;  
    private Invoker inv;  
    /**
     * Creates new form GUISolicitarCita
     */
    public GUIEliminarCitaAsignada() {
        initComponents();
    }
    
    public GUIEliminarCitaAsignada(GestorServicesImpl ser) {
        this.ser = ser;  
        inv = new Invoker(); 
        initComponents();
        camposNoEditables();  
        jButton2.setEnabled(true);
        jButton3.setEnabled(false);
    }
    
    private void camposNoEditables(){
        jTextField2.setEditable(false);
        jTextField3.setEditable(false);
        jTextField4.setEditable(false);
        jTextField5.setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Asignación de cita");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Eliminar cita");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Nombre");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Identificación");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Lugar");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Dirección");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Fecha y hora");

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jTextField1.setText("\"ingrese su número de identificación\"");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setText("Eliminar cita");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(73, 73, 73)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel4))
                                    .addGap(8, 8, 8)))
                            .addGap(51, 51, 51)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextField2)
                                .addComponent(jTextField3)
                                .addComponent(jTextField5)
                                .addComponent(jTextField4)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(230, 230, 230)
                            .addComponent(jLabel1)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel1)
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jLabel1.getAccessibleContext().setAccessibleName("labelAgendarCita");
        jLabel2.getAccessibleContext().setAccessibleName("lblNombre");
        jLabel3.getAccessibleContext().setAccessibleName("lblIdentificación");
        jLabel4.getAccessibleContext().setAccessibleName("lblCiudad");
        jLabel6.getAccessibleContext().setAccessibleName("lblDireccion");
        jLabel7.getAccessibleContext().setAccessibleName("lblFechaHora");
        jTextField2.getAccessibleContext().setAccessibleName("txtIdentificacion");
        jTextField3.getAccessibleContext().setAccessibleName("txtCiudad");
        jTextField4.getAccessibleContext().setAccessibleName("txtDireccion");
        jTextField5.getAccessibleContext().setAccessibleName("txtFechaHora");
        jButton2.getAccessibleContext().setAccessibleName("btnCancelar");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cargarInformacion(){
        String id = jTextField1.getText(); 
        if(!id.isEmpty() && Utilities.isNumeric(id)){
            id_user = String.valueOf(id);  
            try {
                Command cmd = new FindCommand(id_user, ser.getImpl(ServicesEnum.CustomerClientService));  
                inv.setCommand(cmd);
                inv.execute(); 
                FindCommand fcmd = (FindCommand) inv.getCommand(); 
                UsuarioCliente user = (UsuarioCliente) fcmd.getElement();  
                if(user != null){
                    cmd = new FindCommand(String.valueOf(user.getUser_id()), ser.getImpl(ServicesEnum.CitaAsignadaService));  
                    inv.setCommand(cmd);
                    inv.execute(); 
                    fcmd = (FindCommand) inv.getCommand(); 
                    CitaAsignada citAsg = (CitaAsignada) fcmd.getElement();  
                    if(citAsg != null){
                        cita = citAsg.getCita();  
                        jTextField1.setText(String.valueOf(id));
                        jTextField2.setText(user.getName() + " " + user.getLastname());
                        jTextField3.setText(cita.getLugar().getNombre());
                        jTextField4.setText(cita.getLugar().getDireccion());
                        jTextField5.setText(cita.getFecha() + " " + cita.getHora());
                        jButton3.setEnabled(true);
                    }else{
                        JOptionPane.showMessageDialog(null, "no existe una cita registrada en el sistema para este usuario");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Verifique su número de identificación");
                }
            } catch (Exception ex) {
                Logger.getLogger(GUIEliminarCitaAsignada.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else {
            JOptionPane.showMessageDialog(null, "Formato inválido");
        }
    }
    
    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        String txt = jTextField1.getText();  
        if(!Utilities.isNumeric(txt)){
            jTextField1.setText("");
            JOptionPane.showMessageDialog(null, "La identifiacion debe contener solo números");
        }else{
            cargarInformacion(); 
        }
    }//GEN-LAST:event_jTextField1ActionPerformed

    @SuppressWarnings({"unchecked", "rawtypes"})
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        ArrayList<Object> args = new ArrayList();  
        args.add(String.valueOf(cita.getCodigo()));  
        args.add(id_user); 
        
        Command cmdEli = new DeleteCommand(args, ser.getImpl(ServicesEnum.CitaAsignadaService));  
        inv.setCommand(cmdEli);
        inv.execute(); 
        JOptionPane.showMessageDialog(null, "Eliminado con éxito");
        jButton3.setEnabled(false);
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
