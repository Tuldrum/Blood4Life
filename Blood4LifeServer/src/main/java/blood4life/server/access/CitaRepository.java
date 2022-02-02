/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood4life.server.access;

import blood4life.commons.domain.Cita;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class CitaRepository implements ICitaRepository{

    private Connection conn;

    public CitaRepository(IConnectionRepository connection) {
        conn = connection.getConn();
    }
    public CitaRepository(){
        
    } 

    public boolean save(Cita cita) {

        try {
            //Validate product
            if (cita == null || cita.getCodigo() < 0 || cita.getFecha() == null
                    || cita.getUsuario_id() < 0 || cita.getLugar_id() < 0) {
                return false;
            }
            //this.connect();

            String sql = "INSERT INTO UsuarioCliente ( cod_id, lugar_id, user_id, fecha)"
                    + "VALUES ( ?, ?, ?, ? )";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, cita.getCodigo());
            pstmt.setInt(2, cita.getLugar_id());
            pstmt.setInt(3, cita.getUsuario_id());
            pstmt.setDate(4, cita.getFecha());
            pstmt.executeUpdate();
            //this.disconnect();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(CitaRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public List<Cita> list() {
        List<Cita> products = new ArrayList<>();
        try {
            String sql = "SELECT cod_id, lugar_id, user_id, fecha FROM cita";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Cita cita = new Cita();
                cita.setCodigo(rs.getInt("cod_id"));
                cita.setLugar_id(rs.getInt("lugar_id"));
                cita.setUsuario_id(rs.getInt("user_id"));
                cita.setFecha(rs.getDate("fecha"));
                products.add(cita);
            }
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(CitaRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }
    
     public Cita find(int id) {
    	Cita cita = null;
        try {
            
            String sql = "SELECT cod_id, lugar_id, user_id, fecha FROM cita";
            
            //this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            if (rs.next()) {
                cita = new Cita();  
                cita.setCodigo(rs.getInt("cod_id"));
                cita.setLugar_id(rs.getInt("lugar_id"));
                cita.setUsuario_id(rs.getInt("user_id"));
                cita.setFecha(rs.getDate("fecha"));
            }
            //this.disconnect();
            
        } catch (SQLException ex) {
            Logger.getLogger(CitaRepository.class.getName()).log(Level.SEVERE, "Error al buscar el producto en la base de datos", ex);
        }
        return cita;
    }
}
