package blood4life.server.access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import blood4life.commons.domain.UsuarioCliente;
import blood4life.server.domain.services.ServiceModel;

public class ClienteRepository implements IClienteRepository{
	private Connection conn; 
	
	public ClienteRepository(IConnectionRepository connection) {
		this.conn = connection.getConn();  
	}
	
    public boolean save(UsuarioCliente newCliente) {

        try {
            //Validate product
            if (newCliente == null || newCliente.getUser_id() < 0 || newCliente.getName().isEmpty()) {
                return false;
            }
            //this.connect();

            String sql = "INSERT INTO UsuarioCliente ( user_id, nombre, apellido, mail, telefono, sangre) "
                    + "VALUES ( ?, ?, ?, ?, ?, ? )";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,newCliente.getUser_id() );
            pstmt.setString(2,newCliente.getName() );
            pstmt.setString(3,newCliente.getLastname());
            pstmt.setString(4,newCliente.getMail());
            pstmt.setInt(5,newCliente.getNumeroTelefono());
            pstmt.setInt(6,newCliente.getSangre());
           	pstmt.executeUpdate();
           	//this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ServiceModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public UsuarioCliente find(int id) {
    	UsuarioCliente cliente = null;
        try {

        	String sql = "SELECT user_id, nombre, apellido, mail, telefono, sangre" 
                	+" FROM UsuarioCliente Where user_id =" + id;
            
            //this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
            	cliente = new UsuarioCliente();
            	cliente.setUser_id(rs.getInt("user_id"));
            	cliente.setName(rs.getString("nombre"));
            	cliente.setLastname(rs.getString("apellido"));
            	cliente.setMail(rs.getString("mail"));
            	cliente.setNumeroTelefono(rs.getInt("telefono"));
            	cliente.setSangre(rs.getInt("sangre"));
            }
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(ServiceModel.class.getName()).log(Level.SEVERE, "Error al buscar el producto en la base de datos", ex);
        }
        return cliente;
    }
	
	
}
