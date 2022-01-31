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
import blood4life.server.domain.services.ServiceModel;

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
            Logger.getLogger(ServiceModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }
}
