/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood4life.User.domain.services;

import blood4life.User.access.ICitaAsignadaAcces;
import blood4life.User.access.ITwilioWhatsappMessager;
import blood4life.User.access.WhatsappReminder;
import blood4life.commons.domain.Cita;
import blood4life.commons.domain.User;

import java.sql.Date;
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
            Cita cita = (Cita) objects.get(0);
            User user = (User) objects.get(1);
            enviarInfoCitaAsignada(cita, user.getNumeroTelefono());
            return impl.createCitaAsignada(String.valueOf(cita.getCodigo()), String.valueOf(user.getUser_id()));
        } catch (Exception ex) {
            Logger.getLogger(CitaAsignadaService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Error: desconocido"; 
    }

    private void enviarInfoCitaAsignada(Cita cita, String telefono) {
        ITwilioWhatsappMessager reminder = new WhatsappReminder();
        String reminderMessage = "Informacion de su cita:"+
            "\nLugar: " + cita.getLugar().getNombre() + 
            "\nDireccion: " + cita.getLugar().getDireccion() +
            "\nFecha y hora: " + cita.getFecha() + " | " + cita.getHora();
        reminder.sendReminder(telefono, reminderMessage);
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
            String cita_cod = String.valueOf(args.get(0));
            String cod_user = String.valueOf(args.get(1));   
            String telefonos = impl.deleteCitaAsiganada(cita_cod, cod_user);
            notificarCancelacionCita(telefonos);
            return "Cita cancelada con exito";
        } catch (Exception ex) {
            Logger.getLogger(CitaAsignadaService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;  
    }

    private void notificarCancelacionCita (String telefonos) {
        ITwilioWhatsappMessager reminder = new WhatsappReminder();
        String reminderMessage = "Informacion cancelacion de cita de donacion:"+
            "\nSu cita ha sido cancelada, por favor ingrese a la aplicacion si desea asignar una nueva cita";
        for (String telefono: telefonos.split(",")) {
            reminder.sendReminder(telefono, reminderMessage);
        }
    }
    
    @Deprecated
    @Override
    public String update(Object elements) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public Object list(Object elements) {
        try {
            ArrayList<Object> list = (ArrayList<Object>) elements;
            int lugarId = (int) list.get(0);
            Date today = (Date) list.get(1);
            return impl.listaCitasAsignadas(lugarId, today);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
