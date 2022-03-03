/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood4life.User.access;

import blood4life.commons.domain.Assignments;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface IAssignmentsAccess {

    public Assignments findAssignment(int lugar_id, Date fecha) throws Exception;

    public String createAssigment(int entidad_id, Date fecha, int lugar_id) throws Exception;
    
    public String deleteAssigment(int entidad_id, Date fecha, int lugar_id) throws Exception; 
    
    public List<Assignments> listAssignment(int entidad_id) throws Exception; 
}
