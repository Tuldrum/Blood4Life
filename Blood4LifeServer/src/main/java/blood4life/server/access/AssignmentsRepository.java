package blood4life.server.access;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import blood4life.commons.domain.Assignments;
import java.sql.Date;

public class AssignmentsRepository implements IAssignmentsRepository {

    private Connection conn;

    public AssignmentsRepository(IConnectionRepository connection) {
        conn = connection.getConn();
    }

    public List<Assignments> list() {
        List<Assignments> products = new ArrayList<>();
        try {
            String sql = "SELECT lugar_id, sangre_id, fecha FROM Assignments";
            //this.connect();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Assignments newAssignment = new Assignments();
                newAssignment.setLugar_id(rs.getInt("lugar_id"));
                newAssignment.setSangre_id(rs.getInt("sangre_id"));
                newAssignment.setFecha(rs.getDate("fecha"));

                products.add(newAssignment);
            }
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(AssignmentsRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

    public Assignments find(int lugar_id, Date fecha, int sangre_id) {
        
        Assignments assis = null;
        try {
            
            String sql = "SELECT lugar_id, sangre_id, fecha FROM Assignments where lugar_id =" +
                    String.valueOf(lugar_id) + " and fecha=" + fecha.toString() +
                    "and sangre_id=" + String.valueOf(sangre_id);
            
            //this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            if (rs.next()) {
                assis = new Assignments();  
                assis.setLugar_id(rs.getInt("lugar_id"));
                assis.setSangre_id(rs.getInt("sangre_id"));
                assis.setFecha(rs.getDate("fecha"));
            }
            //this.disconnect();
            
        } catch (SQLException ex) {
            Logger.getLogger(AssignmentsRepository.class.getName()).log(Level.SEVERE, "Error al buscar el producto en la base de datos", ex);
        }
        return assis;
    }
}
