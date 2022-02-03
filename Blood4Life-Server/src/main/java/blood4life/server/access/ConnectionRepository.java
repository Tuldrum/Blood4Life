package blood4life.server.access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionRepository implements IConnectionRepository {

    private Connection conn;

    public ConnectionRepository() {
        initDatabase();
    }

    private void initDatabase() {

        try {
            this.connect();
            Statement stmt = conn.createStatement();
            ArrayList<String> tablas = configStrBaseDatos();
            for (int i = 0; i < tablas.size(); i++) {
                stmt.execute(tablas.get(i));
            }
            // this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(ConnectionRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void connect() {
        String driver = "com.mysql.cj.jdbc.Driver";
        String cadenaCon = "jdbc:mysql://127.0.0.1/Blood4Life";
        String usuario = "root";
        String passwd = "";
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

    private ArrayList<String> configStrBaseDatos() {
        // SQL statement for creating a new table
        ArrayList<String> tablas = new ArrayList<String>();

        tablas.add("CREATE TABLE IF NOT EXISTS UsuarioCliente (\n"
                + "	user_id integer PRIMARY KEY,\n"
                + "	nombre text NOT NULL,\n"
                + "	apellido text NOT NULL,\n"
                + "	mail text NOT NULL,\n"
                + "	telefono text NOT NULL,\n"
                + " sangre_id integer NOT NULL\n" + ");");

        tablas.add("CREATE TABLE IF NOT EXISTS cita (\n"
                + " cod_id integer PRIMARY KEY,\n"
                + " lugar_id integer NOT NULL,\n"
                + " user_id integer NOT NULL,\n"
                + " fecha Date NOT NULL\n" + ");");

        tablas.add("CREATE TABLE IF NOT EXISTS LugarRecogida (\n"
                + " lugar_id integer PRIMARY KEY,\n"
                + " direccion text NOT NULL,\n"
                + " nombre text\n" + ");");

        tablas.add("CREATE TABLE IF NOT EXISTS Sangre (\n"
                + " sangre_id integer PRIMARY KEY,\n"
                + " tipo text NOT NULL,\n"
                + " RH text NOT NULL" + ");");

        tablas.add("CREATE TABLE IF NOT EXISTS Entidad (\n"
                + " entidad_id integer PRIMARY KEY,\n"
                + " nombre text NOT NULL\n" + ");");

        tablas.add("CREATE TABLE IF NOT EXISTS UsuarioFuncionario (\n"
                + " user_id integer PRIMARY KEY,\n"
                + " nombre text NOT NULL,\n"
                + " apellido text NOT NULL\n" + ");");

        tablas.add("CREATE TABLE IF NOT EXISTS UserAccess (\n"
                + " user integer PRIMARY KEY,\n"
                + " password integer NOT NULL\n" + ");");

        tablas.add("CREATE TABLE IF NOT EXISTS Assignments (\n"
                + " lugar_id integer PRIMARY KEY,\n"
                + " sangre_id integer NOT NULL,\n"
                + " fecha Date NOT NULL\n" + ");");

        return tablas;
    }

}
