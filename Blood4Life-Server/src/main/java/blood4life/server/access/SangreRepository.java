/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood4life.server.access;

import blood4life.commons.domain.Sangre;
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
public class SangreRepository implements ISangreRepository {

    private Connection conn;

    public SangreRepository(IConnectionRepository connection) {
        this.conn = connection.getConn();
    }

    @Override
    public boolean save(Sangre sangre) {

        try {
            //Validate product
            if (sangre == null || sangre.getSangre_id() < 0 || sangre.getTipo()
                    .isEmpty() || sangre.getRH().isEmpty()) {
                return false;
            }
            //this.connect();

            String sql = "INSERT INTO Sangre ( sangre_id, tipo, RH) "
                    + "VALUES ( ?, ?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, sangre.getSangre_id());
            pstmt.setString(2, sangre.getTipo());
            pstmt.setString(3, sangre.getRH());
            pstmt.executeUpdate();
            //this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(LugaresRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Sangre find(int id) {
        Sangre sangre = null;
        try {

            String sql = "SELECT sangre_id, tipo, RH"
                    + " FROM sangre Where sangre_id =" + String.valueOf(id);

            //this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                sangre = new Sangre();
                sangre.setSangre_id(rs.getInt("sangre_id"));
                sangre.setTipo(rs.getString("tipo"));
                sangre.setRH(rs.getString("RH"));
            }
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(LugaresRepository.class.getName()).log(Level.SEVERE, "Error al buscar el producto en la base de datos", ex);
        }
        return sangre;
    }
}
