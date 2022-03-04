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
import blood4life.commons.domain.LugarRecogida;
import javax.swing.table.DefaultTableModel;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Interfaz gráfica de Consultar clientes
 *
 * @author Libardo Pantoja, Daniel Paz
 *
 */
public class GUILugares extends javax.swing.JFrame {

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

    /**
     * Constructor
     */
    public GUILugares() {
        invoker = new Invoker();
        serv = new GestorServicesImpl();
        initComponents();
        setSize(870, 300);
        loadDataTable();
        initStateButtons();
        setLocationRelativeTo(null);

    }

    /**
     * Poner los botones en su estado inicial
     */
    private void initStateButtons() {
        ConsultarCitas.setEnabled(false); 
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
            invoker.setCommand(new FindAllCommand(null, serv.getImpl(ServicesEnum.LugaresServices)));
            invoker.execute();
            FindAllCommand findAllCommand = (FindAllCommand) invoker.getCommand();
            List<LugarRecogida> components = (List<LugarRecogida>) findAllCommand.getList();
            DefaultTableModel modelTable = (DefaultTableModel) tblData.getModel();
            clearData(modelTable);
            for (LugarRecogida component : components) {
                Object[] fila = new Object[3];
                fila[0] = String.valueOf(component.getLugar_id());
                fila[1] = component.getNombre();
                fila[2] = component.getDireccion();
                modelTable.addRow(fila);
            }
        } catch (Exception ex) {
            Logger.getLogger(GUILugares.class.getName()).log(Level.SEVERE, null, ex);
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
        txtId = new javax.swing.JTextField();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblType = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        pnlSur = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUndo = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        ConsultarCitas = new javax.swing.JButton();
        pnlEste = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();

        setTitle("Lugares ");

        pnlCentro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlCentro.setLayout(new java.awt.GridLayout(3, 2));

        lblId.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblId.setText("*Id:");
        pnlCentro.add(lblId);

        txtId.setPreferredSize(new java.awt.Dimension(150, 32));
        txtId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIdFocusLost(evt);
            }
        });
        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIdKeyPressed(evt);
            }
        });
        pnlCentro.add(txtId);

        lblName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblName.setText("*Nombre:");
        pnlCentro.add(lblName);
        pnlCentro.add(txtName);

        lblType.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblType.setText("*Direccion");
        pnlCentro.add(lblType);
        pnlCentro.add(txtDireccion);

        getContentPane().add(pnlCentro, java.awt.BorderLayout.CENTER);

        pnlSur.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnAdd.setText("Agregar");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setText("Modificar");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Eliminar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUndo.setText("Deshacer");
        btnUndo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUndoActionPerformed(evt);
            }
        });

        btnClose.setText("Cerrar");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        ConsultarCitas.setText("Consultar Citas");
        ConsultarCitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultarCitasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSurLayout = new javax.swing.GroupLayout(pnlSur);
        pnlSur.setLayout(pnlSurLayout);
        pnlSurLayout.setHorizontalGroup(
            pnlSurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSurLayout.createSequentialGroup()
                .addGap(193, 193, 193)
                .addComponent(btnAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUndo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ConsultarCitas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClose)
                .addContainerGap())
        );
        pnlSurLayout.setVerticalGroup(
            pnlSurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSurLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(pnlSurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(btnAdd)
                    .addComponent(btnDelete)
                    .addComponent(btnUndo)
                    .addComponent(btnClose)
                    .addComponent(ConsultarCitas)))
        );

        getContentPane().add(pnlSur, java.awt.BorderLayout.SOUTH);

        pnlEste.setBorder(new javax.swing.border.MatteBorder(null));
        pnlEste.setLayout(new java.awt.BorderLayout());

        tblData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Dirección"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblData);

        pnlEste.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlEste, java.awt.BorderLayout.EAST);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed
    public String getTxtyId() {
        return txtId.getText();
    }

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        try {
            String name = txtName.getText();
            if (name.isEmpty()) {
                Messages.warningMessage("Debe agregar un nombre", "Atención");
                txtName.requestFocus();
                return;
            }

            int id = Integer.parseInt(txtId.getText());
            String direcccion = txtDireccion.getText();

            addLugar(id, name, direcccion);

            Messages.successMessage("Comida agregada con éxito", "Atención");
            clearControls();
            initStateButtons();
            loadDataTable();
        } catch (Exception ex) {
            Logger.getLogger(GUILugares.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnAddActionPerformed

    /**
     * Llama a la logica de negocio para agregar comida mediante el comando
     *
     * @param id identificador del lugar
     * @param name nombre del lugar
     * @param direccion direccion del lugar
     */
    private void addLugar(int id, String name, String direccion) throws Exception {
        LugarRecogida lugar = new LugarRecogida(id, direccion, name);
        //Fija el comando del invoker
        invoker.setCommand(new CreateCommand(lugar, serv.getImpl(ServicesEnum.LugaresServices)));
        //Ejecuta el comando
        invoker.execute();
    }


    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        String name = txtName.getText();
        if (name.isEmpty()) {
            Messages.warningMessage("Debe agregar un nombre", "Atención");
            txtName.requestFocus();
            return;
        }
        // Preparar los datos
        String id = txtId.getText();
        String direcccion = txtDireccion.getText();

        // Crea el lugar con los nuevos datos
        LugarRecogida lugar = new LugarRecogida(Integer.parseInt(id), direcccion, name);

        try {
            // Traer el lugar previa
            invoker.setCommand(new FindCommand(id, serv.getImpl(ServicesEnum.LugaresServices)));
        } catch (Exception ex) {
            Logger.getLogger(GUILugares.class.getName()).log(Level.SEVERE, null, ex);
        }
        FindCommand findcommand = (FindCommand) invoker.getCommand();
        findcommand.setArgs(id);
        invoker.execute();

        //el lugar previo debe crearse en una nueva instancia
        LugarRecogida compAux = (LugarRecogida) findcommand.getElement();
        LugarRecogida previous = new LugarRecogida(compAux.getLugar_id(), compAux.getDireccion(), compAux.getNombre());

        //Modifica el lugar y guarda el previo
        updatelugar(lugar, previous);

        Messages.successMessage("Lugar modificada con éxito", "Atención");
        clearControls();
        initStateButtons();
        try {
            loadDataTable();
        } catch (Exception ex) {
            Logger.getLogger(GUILugares.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed
    /**
     * Llama a la logica de negocio para modificar comida mediante el comando
     *
     * @param food lugar a editar
     * @param previous lugar antes de ser modificada
     */
    private void updatelugar(LugarRecogida lugar, LugarRecogida previous) {
        try {
            //Fija el UpdateCommand
            invoker.setCommand(new UpdateCommand(lugar, serv.getImpl(ServicesEnum.LugaresServices)));
            UpdateCommand updateCommand = (UpdateCommand) invoker.getCommand();
            //Fija el lugar  previo
            updateCommand.setPrevious(previous);
            //Ejecuta el comando
            invoker.execute();
        } catch (Exception ex) {
            Logger.getLogger(GUILugares.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void txtIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdFocusLost
        String strId = txtId.getText().trim();
        if (strId.isEmpty()) {
            return;
        }

        try {
            //Fija el comando del invoker para buscar comida por id
            invoker.setCommand(new FindCommand(null, serv.getImpl(ServicesEnum.LugaresServices)));
        } catch (Exception ex) {
            Logger.getLogger(GUILugares.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Pasa parámetros al comando
        FindCommand findByIdCommand = (FindCommand) invoker.getCommand();
        findByIdCommand.setArgs(strId);
        //Ejecuta el comando
        invoker.execute();
        LugarRecogida lugar = (LugarRecogida) findByIdCommand.getElement();

        if (lugar == null) {
            //Agregar
            btnAdd.setEnabled(true);
            btnUndo.setEnabled(false);
            btnUpdate.setEnabled(false);
            btnDelete.setEnabled(false);
            ConsultarCitas.setEnabled(false); 

        } else {
            //Editar
            btnUpdate.setEnabled(true);
            btnDelete.setEnabled(true);
            btnUndo.setEnabled(false);
            ConsultarCitas.setEnabled(true); 
            txtName.setText(lugar.getNombre());
            txtDireccion.setText(lugar.getDireccion());
        }

    }//GEN-LAST:event_txtIdFocusLost

    private void btnUndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUndoActionPerformed
        //Ejecuta el comando deshacer
        invoker.undo();
        try {
            loadDataTable();
        } catch (Exception ex) {
            Logger.getLogger(GUILugares.class.getName()).log(Level.SEVERE, null, ex);
        }
        initStateButtons();
    }//GEN-LAST:event_btnUndoActionPerformed

    private void txtIdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            txtIdFocusLost(null);
            txtName.requestFocus();
        }
    }//GEN-LAST:event_txtIdKeyPressed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            String strId = txtId.getText().trim();

            // Traer el lugar previo
            invoker.setCommand(new FindCommand(strId, serv.getImpl(ServicesEnum.LugaresServices)));
            FindCommand findByIdCommand = (FindCommand) invoker.getCommand();
            invoker.execute();
            LugarRecogida compAux = (LugarRecogida) findByIdCommand.getElement();
            LugarRecogida lugar = new LugarRecogida(compAux.getLugar_id(), compAux.getDireccion(), compAux.getNombre());

            //Elimina el lugar
            deleteLugar(lugar);

            Messages.successMessage("Comida eliminada con éxito", "Atención");
            clearControls();
            initStateButtons();
            loadDataTable();
        } catch (Exception ex) {
            Logger.getLogger(GUILugares.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void ConsultarCitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultarCitasActionPerformed
        String strId = txtId.getText().trim();
        if (!strId.isEmpty()) {
            LugarRecogida lugar = new LugarRecogida();

            String name = txtName.getText();
            String direcccion = txtDireccion.getText();
            lugar.setDireccion(direcccion);
            lugar.setLugar_id(Integer.parseInt(strId));
            lugar.setNombre(name);

            GUICitas citas = new GUICitas(lugar, serv);
            citas.setVisible(true);
        }
    }//GEN-LAST:event_ConsultarCitasActionPerformed
    /**
     * Llama a la logica de negocio para lugar comida mediante el comando
     *
     * @param lugar lugar a eliminar
     *
     */
    private void deleteLugar(LugarRecogida lugar) {
        try {
            //Fija el comando del invoker
            invoker.setCommand(new DeleteCommand(lugar, serv.getImpl(ServicesEnum.LugaresServices)));
            DeleteCommand cmd = (DeleteCommand) invoker.getCommand();
            cmd.setPrevious(lugar);
            //Ejecuta el comando
            invoker.execute();
        } catch (Exception ex) {
            Logger.getLogger(GUILugares.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Limpia las cajas de texto
     */
    public void clearControls() {
        txtId.setText("");
        txtName.setText("");
        txtDireccion.setText("");
    }

    public static void main(String[] args) {
        GUILugares gui = new GUILugares();
        gui.setVisible(true);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ConsultarCitas;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUndo;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblType;
    private javax.swing.JPanel pnlCentro;
    private javax.swing.JPanel pnlEste;
    private javax.swing.JPanel pnlSur;
    private javax.swing.JTable tblData;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
