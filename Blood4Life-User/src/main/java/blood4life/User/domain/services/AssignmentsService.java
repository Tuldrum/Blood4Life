/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood4life.User.domain.services;

import blood4life.User.access.IAssignmentsAccess;
import java.sql.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class AssignmentsService implements ServiceImpl {

    private IAssignmentsAccess impl;

    public AssignmentsService(IAssignmentsAccess impl) {
        this.impl = impl;
    }

    @Override
    public String create(Object elements) {
        try {
            ArrayList<Object> args = (ArrayList<Object>) elements;
            int entidad_id = (int) args.get(0);
            Date fecha = (Date) args.get(1);
            int lugar_id = (int) args.get(2);
            return impl.createAssigment(entidad_id, fecha, lugar_id);
        } catch (Exception ex) {
            Logger.getLogger(AssignmentsService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String delete(Object elements) {
        try {
            ArrayList<Object> args = (ArrayList<Object>) elements;
            int entidad_id = (int) args.get(0);
            Date fecha = (Date) args.get(1);
            int lugar_id = (int) args.get(2);
            return impl.deleteAssigment(entidad_id, fecha, lugar_id);
        } catch (Exception ex) {
            Logger.getLogger(AssignmentsService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Object find(Object elements) {
        try {
            ArrayList<Object> args = (ArrayList<Object>) elements;
            int lugar_id = (int) args.get(0);
            Date fecha = (Date) args.get(1); 
            return impl.findAssignment(lugar_id, fecha);
        } catch (Exception ex) {
            Logger.getLogger(AssignmentsService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;  
    }

    @Override
    public Object list(Object elements) {
        try {
            int entidad_id = (int) elements; 
            return impl.listAssignment(entidad_id);
        } catch (Exception ex) {
            Logger.getLogger(AssignmentsService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;  
    }

    @Deprecated
    @Override
    public String update(Object elements) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
