package blood4life.server.access;

import blood4life.commons.infra.Utilities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionRepository implements IConnectionRepository {

    private Connection conn;

    public ConnectionRepository() {
        initDatabase();
    }

    private void initDatabase() {
        this.connect();
    }

    public void connect() {
        String driver = Utilities.loadProperty("server.db.driver").toString(); 
        String cadenaCon = Utilities.loadProperty("server.db.url").toString(); 
        String usuario = Utilities.loadProperty("server.db.username").toString(); 
        String passwd = Utilities.loadProperty("server.db.password").toString(); 
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(cadenaCon, usuario, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void disconnect() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public Connection getConn() {
        return conn;
    }

}