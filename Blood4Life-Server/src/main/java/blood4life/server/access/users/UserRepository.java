package blood4life.server.access.users;

import java.sql.Connection;
import java.sql.PreparedStatement;

import blood4life.commons.domain.User;
import blood4life.server.access.IConnectionRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import blood4life.commons.domain.UsuarioCliente;
import blood4life.commons.domain.UsuarioFuncionario;
import blood4life.server.access.ISangreRepository;

public class UserRepository implements IUserRepository {

    private Connection conn;
    private ISangreRepository sangre;

    public UserRepository(IConnectionRepository conn, ISangreRepository sangre) {
        this.conn = conn.getConn();
        this.sangre = sangre;
    }

    @Override
    public User login(int id, String password) {
        User user = null;
        user = consultarTablaUser("usuariocliente", id, password);
        if (user != null) {
            return user;
        }
        user = consultarTablaUser("usuariofuncionario", id, password);
        if (user != null) {
            return user;
        }
        return user;
    }

    @Override
    public String signup(int id, String password) {
        if (!userExists(id)) {
            return crearUsuario(id, password);
        }
        return "error: info: Usuario existente";
    }
    
    private String crearUsuario(int id, String password) {
        try {
            String sql = "INSERT INTO useraccess (user, password) VALUES ( ?, ? )";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.setString(2, password);
            
            pstmt.executeUpdate();
            return "Creado con exito";
        } catch (SQLException ex) {
            Logger.getLogger(ClienteRepository.class.getName()).log(Level.SEVERE, "Error al buscar el producto en la base de datos", ex);
        }
        return "error: info: algo salio mal";
    }

    private boolean userExists (int id) {
        try {
            String sql = "SELECT * FROM useraccess WHERE user = " + String.valueOf(id);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteRepository.class.getName()).log(Level.SEVERE, "Error al buscar el producto en la base de datos", ex);
        }
        return false;
    }

    private User consultarTablaUser(String tabla, int id, String password) {
        User user = null;
        try {
            String sql = "SELECT u.* FROM " +tabla +" u " +
                         "JOIN useraccess ua ON ua.user = u.user_id " + 
                         "WHERE ua.user = "+ String.valueOf(id) +
                         " and ua.password = '"+ password + "';";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            if (rs.next()) {
                return construirTipoUsuario(rs, tabla);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteRepository.class.getName()).log(Level.SEVERE, "Error al buscar el producto en la base de datos", ex);
        }
        return user;
    }

    private User construirTipoUsuario (ResultSet rs, String tipo) throws SQLException {
        switch (tipo) {
            case "usuariocliente": // Nombres de la tabla de la base de datos
                return new UsuarioCliente(
                    rs.getInt("user_id"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("mail"),
                    rs.getString("telefono"),
                    sangre.find(rs.getInt("sangre_id"))
                    );
            case "usuariofuncionario":
                return new UsuarioFuncionario(
                    rs.getInt("user_id"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("mail"),
                    rs.getString("telefono"),
                    rs.getString("organizacion")
                    );
            default:
                return null;
        }
    }
}
