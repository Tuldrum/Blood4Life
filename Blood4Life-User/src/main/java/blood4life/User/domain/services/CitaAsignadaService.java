/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood4life.User.domain.services;

import blood4life.User.access.ICitaAsignadaAcces;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class CitaAsignadaService implements ServiceImpl{
    private ICitaAsignadaAcces impl;  
    public CitaAsignadaService(ICitaAsignadaAcces impl){
        this.impl = impl;  
    }

    @Override
    @SuppressWarnings("unchecked")
    public String create(Object elements) {
        try {
            ArrayList<Object> objects = (ArrayList<Object>) elements;
            String cita_id = (String) objects.get(0);
            String user_id = (String) objects.get(1);  
            return impl.createCitaAsignada(cita_id, user_id);
        } catch (Exception ex) {
            Logger.getLogger(CitaAsignadaService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Error: desconocido"; 
    }
    
    @Override
    public Object find(Object elements){
        String id = (String) elements;  
        try { 
            return impl.findCitaAsiganada(id);
        } catch (Exception ex) {
            Logger.getLogger(CitaAsignadaService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;  
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public String delete(Object elements) {
        try {
            ArrayList<Object> args = (ArrayList<Object>) elements;
            String cita_cod = (String) args.get(0);
            String cod_user = (String) args.get(1);   
            return impl.deleteCitaAsiganada(cita_cod, cod_user);
        } catch (Exception ex) {
            Logger.getLogger(CitaAsignadaService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;  
    }
    
    @Deprecated
    @Override
    public String update(Object elements) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Object list(Object elements) {
        try {
            return impl.listaCitasAsignadas();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
