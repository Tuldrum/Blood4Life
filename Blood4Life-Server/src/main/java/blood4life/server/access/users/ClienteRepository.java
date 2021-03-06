package blood4life.server.access.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import blood4life.commons.domain.UsuarioCliente;
import blood4life.server.access.IConnectionRepository;
import blood4life.server.access.ISangreRepository;

public class ClienteRepository implements IClienteRepository {

    private Connection conn;
    private ISangreRepository sangre;  
    public ClienteRepository(IConnectionRepository connection, ISangreRepository sangre) {
        this.conn = connection.getConn();
        this.sangre = sangre;  
    }

    @Override
    public boolean save(UsuarioCliente newCliente) {
        try {
            //Validate product
            if (!newCliente.Status()) {
                return false;
            }
            //this.connect();

            String sql = "INSERT INTO UsuarioCliente ( user_id, nombre, apellido, mail, telefono, sangre_id) "
                    + "VALUES ( ?, ?, ?, ?, ?, ? )";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, newCliente.getUser_id());
            pstmt.setString(2, newCliente.getName());
            pstmt.setString(3, newCliente.getLastname());
            pstmt.setString(4, newCliente.getMail());
            pstmt.setString(5, newCliente.getNumeroTelefono());
            pstmt.setInt(6, newCliente.getSangre().getSangre_id());
            pstmt.executeUpdate();
            //this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public UsuarioCliente find(int id) {
        UsuarioCliente cliente = null;
        try {

            String sql = "SELECT user_id, nombre, apellido, mail, telefono, sangre_id"
                    + " FROM UsuarioCliente Where user_id =" + String.valueOf(id);

            //this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                cliente = new UsuarioCliente(
                    rs.getInt("user_id"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("mail"),
                    rs.getString("telefono"),
                    sangre.find(rs.getInt("sangre_id"))
                );
            }
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(ClienteRepository.class.getName()).log(Level.SEVERE, "Error al buscar el producto en la base de datos", ex);
        }
        return cliente;
    }
}
