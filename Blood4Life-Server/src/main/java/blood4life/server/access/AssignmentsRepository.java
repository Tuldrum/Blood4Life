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
import blood4life.commons.infra.Utilities;
import java.sql.Date;
import java.sql.PreparedStatement;

public class AssignmentsRepository implements IAssignmentsRepository {

    private Connection conn;
    private ILugaresRepository lugares; 
    private IEntidadRepository entidades;  
    
    public AssignmentsRepository(IConnectionRepository connection, ILugaresRepository lugares,  IEntidadRepository entidades) {
        conn = connection.getConn();
        this.lugares = lugares;  
        this.entidades = entidades;  
    }

    @Override
    public List<Assignments> list(String Id) {
        List<Assignments> products = new ArrayList<>();
        try {
            String sql = "SELECT lugar_id, entidad_id, fecha FROM Assignments where entidad_id = " + Id
                    + "AND fecha >= CAST('" + Utilities.ActualDateToDateSQL().toString()+ "' to date)";
            //this.connect();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Assignments newAssignment = new Assignments();
                newAssignment.setLugar(lugares.find(rs.getInt("lugar_id")));
                newAssignment.setEntidad(entidades.find(rs.getInt("entidad_id")));
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
            
            String sql = "SELECT lugar_id, entidad_id, fecha FROM Assignments where lugar_id =" +
                    String.valueOf(lugar_id) + " and fecha=" + fecha.toString();
            
            //this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            if (rs.next()) {
                assis = new Assignments();  
                assis.setLugar(lugares.find(rs.getInt("lugar_id")));
                assis.setEntidad(entidades.find(rs.getInt("entidad_id")));
                assis.setFecha(rs.getDate("fecha"));
            }
            //this.disconnect();
            
        } catch (SQLException ex) {
            Logger.getLogger(AssignmentsRepository.class.getName()).log(Level.SEVERE, "Error al buscar el producto en la base de datos", ex);
        }
        return assis;
    }
    
    @Override
    public boolean save(Assignments assis) {
        try {
            //Validate product
            if (assis == null || assis.getEntidad() == null || assis.getLugar() == null) {
                return false;
            }

            if (lugares.find(assis.getLugar().getLugar_id()) == null
                    || entidades.find(assis.getEntidad().getEntidad_id()) == null) {
                return false;
            }

            String sql = "INSERT INTO assignments (lugar_id, entidad_id, fecha)"
                    + "VALUES ( ?, ?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, assis.getLugar().getLugar_id());
            pstmt.setInt(2, assis.getEntidad().getEntidad_id());
            pstmt.setDate(2, assis.getFecha());
            pstmt.executeUpdate();
            //this.disconnect();
            
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(AssignmentsRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    @Override
    public boolean delete(Assignments assis) {
        if (assis == null) {
            return false;
        }
        try {
            String sql = "DELETE FROM assignments"
                    + " WHERE (lugar_id = " + String.valueOf(assis.getLugar().getLugar_id())
                    + " AND entidad_id = " + String.valueOf(assis.getEntidad().getEntidad_id()) + ");";

            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(AssignmentsRepository.class.getName()).log(Level.SEVERE, "Error al eliminar la cita en la base de datos", ex);
        }
        return true;
    }

    @Override
    public Object find(Assignments assis2) {
        Assignments assis = null;
        try {
            
            String sql = "SELECT lugar_id, entidad_id, fecha FROM Assignments where lugar_id =" +
                    String.valueOf(assis2.getLugar().getLugar_id()) 
                    + " and entidad_id = " + String.valueOf(assis2.getEntidad().getEntidad_id()) 
                    + " and fecha=" + assis2.getFecha();
            
            //this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            if (rs.next()) {
                assis = new Assignments();  
                assis.setLugar(lugares.find(rs.getInt("lugar_id")));
                assis.setEntidad(entidades.find(rs.getInt("entidad_id")));
                assis.setFecha(rs.getDate("fecha"));
            }
            //this.disconnect();
            
        } catch (SQLException ex) {
            Logger.getLogger(AssignmentsRepository.class.getName()).log(Level.SEVERE, "Error al buscar el producto en la base de datos", ex);
        }
        return assis;
    }
    
}
