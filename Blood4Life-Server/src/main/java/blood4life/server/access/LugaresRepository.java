package blood4life.server.access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import blood4life.commons.domain.LugarRecogida;
import blood4life.server.domain.services.ServiceModel;

public class LugaresRepository implements ILugaresRepository {
private Connection conn; 
	
	public LugaresRepository(IConnectionRepository connection) {
		this.conn = connection.getConn();  
	}
	
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
            pstmt.setInt(1,newLugar.getLugar_id());
            pstmt.setString(2,newLugar.getDireccion());
            pstmt.setString(3,newLugar.getNombre());
           	pstmt.executeUpdate();
           	//this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ServiceModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public LugarRecogida find(int id) {
    	LugarRecogida lugar = null;
        try {

        	String sql = "SELECT lugar_id, direccion, nombre" 
                	+" FROM LugarRecogida Where lugar_id =" + id;
        	
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
            Logger.getLogger(ServiceModel.class.getName()).log(Level.SEVERE, "Error al buscar el producto en la base de datos", ex);
        }
        return lugar;
    }
}
