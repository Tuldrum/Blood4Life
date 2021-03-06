package blood4life.server.access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import blood4life.commons.domain.LugarRecogida;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class LugaresRepository implements ILugaresRepository {

    private Connection conn;

    public LugaresRepository(IConnectionRepository connection) {
        this.conn = connection.getConn();
    }

    @Override
    public boolean save(LugarRecogida newLugar) {

        try {
            //Validate product
            if (newLugar == null || newLugar.getLugar_id() < 0 || newLugar.getDireccion().isEmpty()) {
                return false;
            }
            //this.connect();

            String sql = "INSERT INTO LugarRecogida ( lugar_id, direccion, nombre) "
                    + "VALUES ( ?, ?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, newLugar.getLugar_id());
            pstmt.setString(2, newLugar.getDireccion());
            pstmt.setString(3, newLugar.getNombre());
            pstmt.executeUpdate();
            //this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(LugaresRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public LugarRecogida find(int id) {
        LugarRecogida lugar = null;
        try {

            String sql = "SELECT lugar_id, direccion, nombre"
                    + " FROM LugarRecogida Where lugar_id =" + id;

            //this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                lugar = new LugarRecogida();
                lugar.setLugar_id(rs.getInt("lugar_id"));
                lugar.setDireccion(rs.getString("direccion"));
                lugar.setNombre(rs.getString("nombre"));
            }
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(LugaresRepository.class.getName()).log(Level.SEVERE, "Error al buscar el producto en la base de datos", ex);
        }
        return lugar;
    }

@Override
    public boolean update(LugarRecogida lugar) {
        try {
            //Validate product
            if (lugar == null || lugar.getLugar_id()< 0 || lugar.getNombre() == null
                    || lugar.getDireccion() == null) {
                return false;
            }
            if (find(lugar.getLugar_id()) == null) {
                return false;
            }
            //this.connect();
            String sql = 
                   
                    "UPDATE LugarRecogida "
                    + "SET lugar_id = ?,"
                    + "direccion = ?,"
                    + "nombre =  ?"
                    + "WHERE lugar_id = " + String.valueOf(lugar.getLugar_id())+ ";";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, lugar.getLugar_id());
            pstmt.setString(2, lugar.getDireccion());
            pstmt.setString(3, lugar.getNombre());
            pstmt.executeUpdate();
            //this.disconnect();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(CitaRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(LugarRecogida lugar) {
        if (lugar == null) {
            return false;
        }
        try {

            String sql = "DELETE FROM lugarrecogida"
                    + " WHERE (lugar_id = " + String.valueOf(lugar.getLugar_id()) + ");";

            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);

        } catch (SQLException ex) {
            Logger.getLogger(CitaRepository.class.getName()).log(Level.SEVERE, "Error al eliminar la cita en la base de datos", ex);
        }
        return true;
    }

    @Override
    public List<LugarRecogida> list(Date before, Date after) {
        List<LugarRecogida> lugares = new ArrayList<>();
        try {

            String sql = "SELECT l.lugar_id, direccion, nombre FROM LugarRecogida l, cita c \n"
                    + "where (l.lugar_id = c.lugar_id \n"
                    + "       AND c.fecha > CAST('" + before.toString() + "' AS date)\n"
                    + "       AND c.fecha <= CAST('" + after.toString() + "' AS date)) \n"
                    + "GROUP BY l.lugar_id;";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                LugarRecogida lugar = new LugarRecogida();
                lugar.setLugar_id(rs.getInt("lugar_id"));
                lugar.setDireccion(rs.getString("direccion"));
                lugar.setNombre(rs.getString("nombre"));
                lugares.add(lugar);
            }
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(CitaRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lugares;
    }

    @Override
    public List<LugarRecogida> list() {
        List<LugarRecogida> lugares = new ArrayList<>();
        try {

            String sql = "SELECT l.lugar_id, direccion, nombre FROM LugarRecogida l";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                LugarRecogida lugar = new LugarRecogida();
                lugar.setLugar_id(rs.getInt("lugar_id"));
                lugar.setDireccion(rs.getString("direccion"));
                lugar.setNombre(rs.getString("nombre"));
                lugares.add(lugar);
            }
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(CitaRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lugares;
    }

}
