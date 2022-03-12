package blood4life.User.presentacion.Funcionario;

import blood4life.User.domain.commands.CreateCommand;
import blood4life.User.domain.commands.DeleteCommand;
import blood4life.User.domain.commands.FindAllCommand;
import blood4life.User.domain.commands.FindCommand;
import blood4life.User.domain.commands.Invoker;
import blood4life.User.domain.commands.UpdateCommand;
import blood4life.User.domain.services.GestorServicesImpl;
import blood4life.User.domain.services.ServicesEnum;
import blood4life.User.infra.Messages;
import blood4life.commons.domain.Cita;
import blood4life.commons.domain.Entidad;
import blood4life.commons.domain.LugarRecogida;
import blood4life.commons.infra.Utilities;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GUIEntidades extends javax.swing.JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * Instancia del invocador para poder enviar comandos al receptor
     * FoodService
     */
    private final Invoker invoker;
    GestorServicesImpl serv;
    private LugarRecogida lugar;
    private Entidad entidad;
    
    
    /**
     * Constructor
     */
    public GUIEntidades(Entidad entidad, GestorServicesImpl serv) {
        this.entidad = entidad;  
        invoker = new Invoker();
        this.serv = serv;
        initComponents();
        setSize(988, 498);
        loadDataTable();
        initStateButtons();
        setLocationRelativeTo(null);
    }

    /**
     * Poner los botones en su estado inicial
     */
    private void initStateButtons() {
        btnAdd.setEnabled(false);
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
        btnUndo.setEnabled(invoker.hasCommandUndo());
    }

    /**
     * Carga las comidas en el jTable
     */
    @SuppressWarnings("unchecked")
    private void loadDataTable() {
        try {
            ArrayList<Object> args = new ArrayList<Object>();
            args.add(Utilities.ActualDateToDateSQL());
            args.add(entidad.getEntidad_id());

            invoker.setCommand(new FindAllCommand(args, serv.getImpl(ServicesEnum.)));//no sé si debo hacerle un enum para entidad
            invoker.execute();

            FindAllCommand findAllCommand = (FindAllCommand) invoker.getCommand();
            List<Entidad> components = (List<Entidad>) findAllCommand.getList();
            if (components.size() > 0) {
                DefaultTableModel modelTable = (DefaultTableModel) tblData.getModel();
                clearData(modelTable);
                for (Entidad component : components) {
                    Object[] fila = new Object[4];
                    fila[0] = String.valueOf(component.getEntidad_id());
                    fila[1] = component.getNombre();
                    fila[2] = component.getDireccion();
                    fila[3] = component.getHora();//aquí va la fecha, porque es la 4ta vaina que se pide, pero tambíen se neceista del teléfono
                    modelTable.addRow(fila);
                }
            } else {
                Messages.confirmMessage("Sin citas disponibles para este lugar", "información");
            }
        } catch (Exception ex) {
            Logger.getLogger(GUIEntidades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Elimina las filas del jTable
     *
     * @param modelTable modelo de datos del jTable
     */
    private void clearData(DefaultTableModel modelTable) {
        while (modelTable.getRowCount() > 0) {
            modelTable.removeRow(0);
        }
    }

    /**
     * Mensaje inicial del panel superior
     */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlCentro = new javax.swing.JPanel();
        lblId = new javax.swing.JLabel();
        txtIdEntidad = new javax.swing.JTextField();
        lblCupos = new javax.swing.JLabel();
        txtNombreEntidad = new javax.swing.JTextField();
        lblFecha = new javax.swing.JLabel();
        lblFecha1 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        txtDireccionEntidad = new javax.swing.JTextField();
        pnlSur = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUndo = new javax.swing.JButton();
        btnListaLugares = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        pnlEste = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();

        setTitle("Lugares ");

        pnlCentro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblId.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblId.setText("*Id:");

        txtIdEntidad.setPreferredSize(new java.awt.Dimension(150, 32));
        txtIdEntidad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIdEntidadFocusLost(evt);
            }
        });
        txtIdEntidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdEntidadActionPerformed(evt);
            }
        });
        txtIdEntidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIdEntidadKeyPressed(evt);
            }
        });

        lblCupos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCupos.setText("*Nombre:");

        txtNombreEntidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreEntidadActionPerformed(evt);
            }
        });

        lblFecha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFecha.setText("Fecha");

        lblFecha1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFecha1.setText("*Dirección");

        txtDireccionEntidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionEntidadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCentroLayout = new javax.swing.GroupLayout(pnlCentro);
        pnlCentro.setLayout(pnlCentroLayout);
        pnlCentroLayout.setHorizontalGroup(
            pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCentroLayout.createSequentialGroup()
                .addGroup(pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCentroLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlCentroLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCupos, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlCentroLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDireccionEntidad, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtIdEntidad, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))
                    .addComponent(txtNombreEntidad, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        pnlCentroLayout.setVerticalGroup(
            pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCentroLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdEntidad, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCupos, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreEntidad, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCentroLayout.createSequentialGroup()
                        .addComponent(lblFecha1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlCentroLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(txtDireccionEntidad, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                        .addGap(18, 18, 18)))
                .addGroup(pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        pnlSur.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnAdd.setText("Agregar");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        pnlSur.add(btnAdd);

        btnUpdate.setText("Modificar");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        pnlSur.add(btnUpdate);

        btnDelete.setText("Eliminar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        pnlSur.add(btnDelete);

        btnUndo.setText("Deshacer");
        btnUndo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUndoActionPerformed(evt);
            }
        });
        pnlSur.add(btnUndo);

        btnListaLugares.setText("Lista Lugares para asignar");
        btnListaLugares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaLugaresActionPerformed(evt);
            }
        });
        pnlSur.add(btnListaLugares);

        btnClose.setText("Cerrar");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        pnlSur.add(btnClose);

        pnlEste.setBorder(new javax.swing.border.MatteBorder(null));
        pnlEste.setLayout(new java.awt.BorderLayout());

        tblData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Cupos", "Fecha", "Hora"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblData);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlCentro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(pnlSur, javax.swing.GroupLayout.PREFERRED_SIZE, 964, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(pnlEste, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlEste, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(pnlCentro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlSur, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed
    public String getTxtyId() {
        return txtIdEntidad.getText();
    }

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        try {
            String idEntidad = txtIdEntidad.getText();
            if (idEntidad.isEmpty()) {
                Messages.warningMessage("Debe agregar un ID a la entidad", "Atención");
                txtIdEntidad.requestFocus();
                return;
            }

            int id = Integer.parseInt(txtIdEntidad.getText());
            int cupos = Integer.parseInt(txtNombreEntidad.getText());

            Date fecha = Utilities.DateToDateSQL(jDateChooser1.getDate());
            Time hora = Time.valueOf(txtDireccionEntidad.getText());

            addEntidad(id, nombre, direccion, fecha);
            //addCita(id, cupos, fecha, hora);

            Messages.successMessage("Entidad agregada con éxito", "Atención");
            clearControls();
            initStateButtons();
            loadDataTable();
        } catch (Exception ex) {
            Logger.getLogger(GUIEntidades.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnAddActionPerformed

    /**
     * Llama a la logica de negocio para agregar la cita mediante el comando
     *
     * @param id identificador de la cita
     * @param cupos
     * @param fecha fecha de la cita
     * @param hora hora de la cita
     */
    private void addEntidad(int id, String nombre, String direccion, Date fecha) throws Exception {
        Entidad entidad = new Entidad(id, nombre, direccion, fecha);
        //Fija el comando del invoker
        invoker.setCommand(new CreateCommand(entidad, serv.getImpl(ServicesEnum.CitaService)));
        //Ejecuta el comando
        invoker.execute();
    }


    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        String idEntidad = txtIdEntidad.getText();
        if (idEntidad.isEmpty()) {
            Messages.warningMessage("Debe agregar un ID para la entidad", "Atención");
            txtIdEntidad.requestFocus();
            return;
        }
        // Preparar los datos
        int id = Integer.parseInt(txtIdEntidad.getText());
        String nombre = txtNombreEntidad.getText();
        String direccion = txtDireccionEntidad.getText();
        Date fecha = Utilities.DateToDateSQL(jDateChooser1.getDate());

        //Crea la cita con los nuevos datos
        Entidad entidad = new Entidad(id, nombre, direccion, fecha);

        try {
            // Traer la cita previa
            invoker.setCommand(new FindCommand(String.valueOf(id), serv.getImpl(ServicesEnum.CitaService)));
        } catch (Exception ex) {
            Logger.getLogger(GUIEntidades.class.getName()).log(Level.SEVERE, null, ex);
        }
        FindCommand findcommand = (FindCommand) invoker.getCommand();
        findcommand.setArgs(String.valueOf(id));
        invoker.execute();

        //la cita previa debe crearse en una nueva instancia
        Entidad compAux = (Entidad) findcommand.getElement();
        Entidad previous = new Entidad(compAux.getEntidad_id(), compAux.getNombre(), compAux.getDireccion(), compAux.getHora());

        //Modifica la cita y guarda el previo
        updateCita(entidad, previous);

        Messages.successMessage("Entidad modificada con éxito", "Atención");
        clearControls();
        initStateButtons();
        try {
            loadDataTable();
        } catch (Exception ex) {
            Logger.getLogger(GUIEntidades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed
    /**
     * Llama a la logica de negocio para modificar comida mediante el comando
     *
     * @param food lugar a editar
     * @param previous lugar antes de ser modificada
     */
    private void updateCita(Entidad entidad, Entidad previous) {
        try {
            //Fija el UpdateCommand
            invoker.setCommand(new UpdateCommand(entidad, serv.getImpl(ServicesEnum)));//otra vez el enum
            UpdateCommand updateCommand = (UpdateCommand) invoker.getCommand();
            //Fija la cita  previa
            updateCommand.setPrevious(previous);
            //Ejecuta el comando
            invoker.execute();
        } catch (Exception ex) {
            Logger.getLogger(GUIEntidades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void txtIdEntidadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdEntidadFocusLost
        String strId = txtIdEntidad.getText().trim();
        if (strId.isEmpty()) {
            return;
        }

        try {
            //Fija el comando del invoker para buscar cita por id
            invoker.setCommand(new FindCommand(null, serv.getImpl(ServicesEnum))); //el enum
        } catch (Exception ex) {
            Logger.getLogger(GUIEntidades.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Pasa parámetros al comando
        FindCommand findByIdCommand = (FindCommand) invoker.getCommand();
        findByIdCommand.setArgs(strId);
        //Ejecuta el comando
        invoker.execute();
        Entidad entidad = (Entidad) findByIdCommand.getElement();

        if (entidad == null) {
            //Agregar
            btnAdd.setEnabled(true);
            btnUndo.setEnabled(false);
            btnUpdate.setEnabled(false);
            btnDelete.setEnabled(false);

        } else {
            //Editar
            btnUpdate.setEnabled(true);
            btnDelete.setEnabled(true);
            btnUndo.setEnabled(false);
            txtNombreEntidad.setText(String.valueOf(entidad.getNombre()));
            jDateChooser1.setDate(entidad.getFecha());
            txtDireccionEntidad.setText(entidad.getDireccion());
        }
    }//GEN-LAST:event_txtIdEntidadFocusLost

    private void btnUndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUndoActionPerformed
        //Ejecuta el comando deshacer
        invoker.undo();
        try {
            loadDataTable();
        } catch (Exception ex) {
            Logger.getLogger(GUIEntidades.class.getName()).log(Level.SEVERE, null, ex);
        }
        initStateButtons();
    }//GEN-LAST:event_btnUndoActionPerformed

    private void txtIdEntidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdEntidadKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            //txtIdFocusLost(null);
            txtNombreEntidad.requestFocus();
        }
    }//GEN-LAST:event_txtIdEntidadKeyPressed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            String strId = txtIdEntidad.getText().trim();

            // Traer la cita previa
            invoker.setCommand(new FindCommand(strId, serv.getImpl(ServicesEnum)));//el enum
            FindCommand findByIdCommand = (FindCommand) invoker.getCommand();
            invoker.execute();
            Entidad compAux = (Entidad) findByIdCommand.getElement();
            Entidad entidad = new Entidad(compAux.getEntidad_id(), compAux.getNombre(), compAux.getDireccion(), compAux.fecha);

            //Elimina la entidad
            deleteEntidad(entidad);

            Messages.successMessage("Entidad eliminada con éxito", "Atención");
            clearControls();
            initStateButtons();
            loadDataTable();
        } catch (Exception ex) {
            Logger.getLogger(GUIEntidades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnListaLugaresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaLugaresActionPerformed
        GUIListaLugares listaLugares = new GUIListaLugares();
        listaLugares.setVisible();
    }//GEN-LAST:event_btnListaLugaresActionPerformed

    /**
     * Llama a la logica de negocio para cita mediante el comando
     * @param cita cita a eliminar
     */
    private void deleteCita(Entidad entidad) {
        try {
            //Fija el comando del invoker
            invoker.setCommand(new DeleteCommand(entidad, serv.getImpl(ServicesEnum)));
            DeleteCommand cmd = (DeleteCommand) invoker.getCommand();  
            cmd.setPrevious(entidad);
            //Ejecuta el comando
            invoker.execute();
        } catch (Exception ex) {
            Logger.getLogger(GUIEntidades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Limpia las cajas de texto
     */
    public void clearControls() {
        txtIdEntidad.setText("");
        txtNombreEntidad.setText("");
        jDateChooser1.setDate(null);
        txtDireccionEntidad.setText("");
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnListaLugares;
    private javax.swing.JButton btnUndo;
    private javax.swing.JButton btnUpdate;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCupos;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblFecha1;
    private javax.swing.JLabel lblId;
    private javax.swing.JPanel pnlCentro;
    private javax.swing.JPanel pnlEste;
    private javax.swing.JPanel pnlSur;
    private javax.swing.JTable tblData;
    private javax.swing.JTextField txtDireccionEntidad;
    private javax.swing.JTextField txtIdEntidad;
    private javax.swing.JTextField txtNombreEntidad;
    // End of variables declaration//GEN-END:variables
}
