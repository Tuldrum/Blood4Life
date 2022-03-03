/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood4life.server.access;

import blood4life.commons.domain.Cita;
import java.sql.Connection;
import java.sql.Date;
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
public class CitaRepository implements ICitaRepository {

    private Connection conn;
    private ILugaresRepository lugares;

    public CitaRepository(IConnectionRepository connection, ILugaresRepository lugares) {
        conn = connection.getConn();
        this.lugares = lugares;
    }

    @Override
    public boolean save(Cita cita) {

        try {
            //Validate product
            if (cita == null || cita.getCodigo() < 0 || cita.getFecha() == null || cita.getLugar() == null) {
                return false;
            }
            //this.connect();

            String sql = "INSERT INTO cita ( cod_id, lugar_id, cupos, fecha, hora)"
                    + "VALUES ( ?, ?, ?, ? )";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, cita.getCodigo());
            pstmt.setInt(2, cita.getLugar().getLugar_id());
            pstmt.setInt(3, cita.getCupos());
            pstmt.setDate(4, cita.getFecha());
            pstmt.setTime(5, cita.getHora());
            pstmt.executeUpdate();
            //this.disconnect();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(CitaRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<Cita> list(Date dateSqlBefore, Date dateSqlAfter, int lugar_id) {
        List<Cita> products = new ArrayList<>();
        try {
            String sql = "SELECT cod_id, lugar_id, cupos, fecha, hora FROM cita c\n"
                    + "WHERE c.cupos > 0 AND c.lugar_id = " + String.valueOf(lugar_id) + " \n"
                    + "AND c.fecha > CAST('" + dateSqlBefore.toString() + "' AS date)\n"
                    + "AND c.fecha <= CAST('" + dateSqlAfter.toString() + "' AS date)";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Cita cita = new Cita();
                cita.setCodigo(rs.getInt("cod_id"));
                cita.setLugar(lugares.find(rs.getInt("lugar_id")));
                cita.setCupos(rs.getInt("cupos"));
                cita.setFecha(rs.getDate("fecha"));
                cita.setHora(rs.getTime("hora"));
                products.add(cita);
            }
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(CitaRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

    @Override
    public Cita find(int id) {
        Cita cita = null;
        try {

            String sql = "SELECT cod_id, lugar_id, cupos, fecha, hora "
                    + "FROM cita WHERE cod_id = " + String.valueOf(id);

            //this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                cita = new Cita();
                cita.setCodigo(rs.getInt("cod_id"));
                cita.setLugar(lugares.find(rs.getInt("lugar_id")));
                cita.setCupos(rs.getInt("cupos"));
                cita.setFecha(rs.getDate("fecha"));
                cita.setHora(rs.getTime("hora"));
            }
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(CitaRepository.class.getName()).log(Level.SEVERE, "Error al buscar el producto en la base de datos", ex);
        }
        return cita;
    }

    @Override
    public boolean update(Cita cita) {
        try {
            //Validate product
            if (cita == null || cita.getCodigo() < 0 || cita.getFecha() == null
                    || cita.getCodigo() < 0 || cita.getLugar() == null) {
                return false;
            }
            if (find(cita.getCodigo()) == null) {
                return false;
            }
            //this.connect();
            String sql = "UPDATE cita "
                    + "SET cod_id = ?, "
                    + "lugar_id = ?,"
                    + "cupos = ?,"
                    + "fecha = ?,"
                    + "hora =? "
                    + "WHERE cod_id = " + String.valueOf(cita.getCodigo());

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, cita.getCodigo());
            pstmt.setInt(2, cita.getLugar().getLugar_id());
            pstmt.setInt(3, cita.getCupos());
            pstmt.setDate(4, cita.getFecha());
            pstmt.setTime(5, cita.getHora());
            pstmt.executeUpdate();
            //this.disconnect();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(CitaRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    } 
    
    @Override
    public List<Cita> list(Date sqlDate, int lugar_id) {
        List<Cita> products = new ArrayList<>();
        try {
            String sql = "SELECT cod_id, lugar_id, cupos, fecha, hora FROM cita c\n"
                    + "WHERE c.lugar_id = " + String.valueOf(lugar_id) + " \n"
                    + "AND c.fecha >= CAST('" + sqlDate.toString() + "' AS date);";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Cita cita = new Cita();
                cita.setCodigo(rs.getInt("cod_id"));
                cita.setLugar(lugares.find(rs.getInt("lugar_id")));
                cita.setCupos(rs.getInt("cupos"));
                cita.setFecha(rs.getDate("fecha"));
                cita.setHora(rs.getTime("hora"));
                products.add(cita);
            }
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(CitaRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }
}
