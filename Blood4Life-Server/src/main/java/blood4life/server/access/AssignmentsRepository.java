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
    private ILugaresRepository lugares; 
    private ISangreRepository sangres;  
    
    public AssignmentsRepository(IConnectionRepository connection, ILugaresRepository lugares, ISangreRepository sangres) {
        conn = connection.getConn();
        this.lugares = lugares;  
        this.sangres = sangres; 
    }

    @Override
    public List<Assignments> list() {
        List<Assignments> products = new ArrayList<>();
        try {
            String sql = "SELECT lugar_id, sangre_id, fecha FROM Assignments";
            //this.connect();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Assignments newAssignment = new Assignments();
                newAssignment.setLugar_id(lugares.find(rs.getInt("lugar_id")));
                newAssignment.setSangre_id(sangres.find(rs.getInt("sangre_id")));
                newAssignment.setFecha(rs.getDate("fecha"));
                products.add(newAssignment);
            }
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(AssignmentsRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

    @Override
    public Assignments find(int lugar_id, Date fecha) {
        
        Assignments assis = null;
        try {
            
            String sql = "SELECT lugar_id, sangre_id, fecha FROM Assignments where lugar_id =" +
                    String.valueOf(lugar_id) + " and fecha=" + fecha.toString();
            
            //this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            if (rs.next()) {
                assis = new Assignments();  
                assis.setLugar_id(lugares.find(rs.getInt("lugar_id")));
                assis.setSangre_id(sangres.find(rs.getInt("sangre_id")));
                assis.setFecha(rs.getDate("fecha"));
            }
            //this.disconnect();
            
        } catch (SQLException ex) {
            Logger.getLogger(AssignmentsRepository.class.getName()).log(Level.SEVERE, "Error al buscar el producto en la base de datos", ex);
        }
        return assis;
    }
}
