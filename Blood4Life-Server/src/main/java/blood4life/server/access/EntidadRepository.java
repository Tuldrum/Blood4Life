/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood4life.server.access;

import blood4life.commons.domain.Entidad;
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
public class EntidadRepository implements IEntidadRepository {

    private Connection conn;

    public EntidadRepository(IConnectionRepository conn) {
        this.conn = conn.getConn();
    }

    @Override
    public boolean save(Entidad entidad) {

        try {
            //Validate product
            if (entidad == null || entidad.getEntidad_id() < 0 || entidad.getNombre().isEmpty() || entidad.getTelefono().isEmpty()) {
                return false;
            }
            //this.connect();

            String sql = "INSERT INTO entidad (entidad_id, nombre, direccion, telefono)"
                    + "VALUES ( ?, ?, ?, ? )";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,entidad.getEntidad_id());
            pstmt.setString(2, entidad.getNombre());
            pstmt.setString(3, entidad.getDireccion());
            pstmt.setString(4, entidad.getTelefono());
            pstmt.executeUpdate();
            //this.disconnect();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(EntidadRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean update(Entidad entidad) {
        try {
            //Validate product
             if (entidad == null || entidad.getEntidad_id() < 0 || 
                     entidad.getNombre().isEmpty() || entidad.getTelefono().isEmpty()) {
                return false;
            }
            if (find(entidad.getEntidad_id()) == null) {
                return false;
            }
            //this.connect();
            String sql = "UPDATE entidad "
                    + "SET entidad_id = ?, "
                    + " nombre = ?,"
                    + "direccion = ?,"
                    + "telefono = ?,"
                    + "WHERE cod_id = " + String.valueOf(entidad.getEntidad_id());
            
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,entidad.getEntidad_id());
            pstmt.setString(2, entidad.getNombre());
            pstmt.setString(3, entidad.getDireccion());
            pstmt.setString(4, entidad.getTelefono());
            pstmt.executeUpdate();
            //this.disconnect();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(EntidadRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Entidad find(int id) {
        Entidad entidad = null;
        try {

            String sql = "SELECT entidad_id, nombre, direccion, telefono "
                    + "FROM entidad WHERE entidad_id = " + String.valueOf(id);

            //this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                entidad = new Entidad();
                entidad.setEntidad_id(rs.getInt("entidad_id"));
                entidad.setNombre(rs.getString("nombre"));
                entidad.setDireccion(rs.getString("direccion"));
                entidad.setTelefono(rs.getString("telefono"));
            }
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(EntidadRepository.class.getName()).log(Level.SEVERE, "Error al buscar el producto en la base de datos", ex);
        }
        return entidad;
    }

}
