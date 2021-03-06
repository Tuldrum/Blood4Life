/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood4life.User.domain.services;

import blood4life.User.access.IEntidadAccess;
import blood4life.commons.domain.Entidad;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class EntidadesService implements ServiceImpl {

    private IEntidadAccess impl; 
    public EntidadesService(IEntidadAccess impl){
        this.impl = impl; 
    }
    
    
    @Override
    public String create(Object elements) {
        try {
            Entidad entidad = (Entidad) elements;
            return impl.createEntidad(entidad);    
        } catch (Exception ex) {
            Logger.getLogger(EntidadesService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String delete(Object elements) {
        try {
            Entidad entidad = (Entidad) elements;
            return impl.deleteEntidad(entidad);    
        } catch (Exception ex) {
            Logger.getLogger(EntidadesService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Object find(Object elements) {
        String id = (String) elements;  
        try {
            return impl.findEntidad(id);
        } catch (Exception ex) {
            Logger.getLogger(EntidadesService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null; 
    }
    
    @Deprecated
    @Override
    public String update(Object elements) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Deprecated
    @Override
    public Object list(Object elements) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
