/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood4life.User.domain.services;

import blood4life.User.access.ICitaAcces;
import blood4life.commons.domain.Cita;
import java.sql.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class CitaService implements ServiceImpl {
    
    private ICitaAcces CitaAccesImplSockets;  
    
    public CitaService(ICitaAcces CitaAccesImplSockets){
        this.CitaAccesImplSockets = CitaAccesImplSockets; 
    } 
    
    @Override
    public String create(Object elements) {
        try {
            Cita cita = (Cita) elements;  
            return CitaAccesImplSockets.createCita(cita);
        } catch (Exception ex) {
            Logger.getLogger(CitaService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Error: desconocido";  
    }

    @Override
    public String update(Object elements) {
        try { 
            Cita cita = (Cita) elements; 
            return CitaAccesImplSockets.updateCita(cita);
        } catch (Exception ex) {
            Logger.getLogger(CitaService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Error: desconocido";  
    }
    
    @Override
    public Object find(Object elements) {
        try {
            String id = (String) elements;  
            return CitaAccesImplSockets.findCita(id);
        } catch (Exception ex) {
            Logger.getLogger(CitaService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;  
    }
    
    @Override
    public Object list(Object elements) {
        try {
            ArrayList<Object> list = (ArrayList<Object>) elements;
            Date before = (Date) list.get(0);
            Date after = (Date) list.get(1);
            int id_lugar = (int) list.get(2);  
            return CitaAccesImplSockets.CitasDisponibles(before, after, id_lugar);
        } catch (Exception ex) {
            Logger.getLogger(CitaService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;  
    }
    
    @Deprecated
    @Override
    public String delete(Object elements) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
