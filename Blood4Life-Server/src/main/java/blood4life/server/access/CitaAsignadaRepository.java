/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood4life.server.access;

import blood4life.commons.domain.Cita;
import blood4life.commons.domain.CitaAsignada;
import blood4life.commons.domain.UsuarioCliente;
import blood4life.commons.infra.Utilities;
import blood4life.server.access.users.IClienteRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class CitaAsignadaRepository implements ICitaAsignadaRepository {

    private ICitaRepository citarepo;
    private IClienteRepository repoclie;
    private Connection conn;

    public CitaAsignadaRepository(ICitaRepository citarepo,
            IClienteRepository repoclie,
            IConnectionRepository conn) {
        this.citarepo = citarepo;
        this.repoclie = repoclie;
        this.conn = conn.getConn();
    }

    @Override
    public boolean save(CitaAsignada cita) {
        try {
            //Validate product
            if (cita.getCita() == null || cita.getCliente() == null || cita.getCita().getCodigo() < 0
                    || cita.getCita().getFecha() == null || cita.getCita().getLugar() == null
                    || cita.getCita().getCupos() <= 0
                    || !cita.getCliente().Status()) {
                return false;
            }

            if (repoclie.find(cita.getCliente().getUser_id()) == null
                    || citarepo.find(cita.getCita().getCodigo()) == null) {
                return false;
            }

            String sql = "INSERT INTO citasasignadas ( user_id, cod_id)"
                    + "VALUES ( ?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, cita.getCliente().getUser_id());
            pstmt.setInt(2, cita.getCita().getCodigo());
            pstmt.executeUpdate();
            //this.disconnect();
            
            Cita citaUpd = cita.getCita();
            citaUpd.setCupos(citaUpd.getCupos() - 1);
            citarepo.update(citaUpd);


            return true;

        } catch (SQLException ex) {
            Logger.getLogger(CitaAsignadaRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public CitaAsignada find(UsuarioCliente cliente) {
        CitaAsignada cita = new CitaAsignada();
        int cod_cita = -1;
        boolean banNull = false;
        if (!cliente.Status()) {
            return null;
        }
        try {

            String sql = "SELECT c.cod_id FROM citasasignadas ca, cita c "
                    + "WHERE (ca.cod_id = c.cod_id "
                    + "AND c.fecha >= CAST('"
                    + Utilities.ActualDateToDateSQL().toString() +"' AS date) "
                    + "AND ca.user_id = "+ String.valueOf(cliente.getUser_id()) +" );";

            //this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                cod_cita = rs.getInt("cod_id");
                banNull = (rs.wasNull());
            }

            if (banNull || cod_cita == -1) {
                return null;
            }
            cita.setCita(citarepo.find(cod_cita));
            cita.setCliente(cliente);

        } catch (SQLException ex) {
            Logger.getLogger(CitaRepository.class.getName()).log(Level.SEVERE, "Error al buscar el producto en la base de datos", ex);
        }
        return cita;
    }

    @Override
    public CitaAsignada find(CitaAsignada cita) {
        boolean banNull = false;
        if (cita.getCita() == null || cita.getCliente() == null || cita.getCita().getCodigo() < 0
                || cita.getCita().getFecha() == null || cita.getCita().getLugar() == null
                || cita.getCita().getCupos() <= 0
                || !cita.getCliente().Status()) {
            return null;
        }
        try {

            String sql = "SELECT user_id, cod_id FROM citasasignadas"
                    + " WHERE (user_id = " + String.valueOf(cita.getCliente().getUser_id()) 
                    + " and cod_id = " + String.valueOf(cita.getCita().getCodigo()) + ");"; 

            //this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {

                rs.getInt("cod_id");
                banNull = rs.wasNull();
                rs.getInt("cod_id");
                banNull = rs.wasNull();
            }
            if (banNull) {
                return null;
            }

        } catch (SQLException ex) {
            Logger.getLogger(CitaRepository.class.getName()).log(Level.SEVERE, "Error al buscar el producto en la base de datos", ex);
        }
        return cita;
    }

    @Override
    public boolean delete(CitaAsignada citaAsi) {
        if (citaAsi == null) {
            return false;
        }
        try {

            String sql = "DELETE FROM citasasignadas"
                    + " WHERE (user_id = " + String.valueOf(citaAsi.getCliente().getUser_id())
                    + " AND cod_id = " + String.valueOf(citaAsi.getCita().getCodigo()) + ");";

            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);

            Cita citaUpd = citaAsi.getCita();
            citaUpd.setCupos(citaUpd.getCupos() + 1);
            citarepo.update(citaUpd);

        } catch (SQLException ex) {
            Logger.getLogger(CitaRepository.class.getName()).log(Level.SEVERE, "Error al eliminar la cita en la base de datos", ex);
        }
        return true;
    }
    
    
}
