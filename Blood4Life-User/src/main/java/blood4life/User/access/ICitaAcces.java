/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood4life.User.access;

import blood4life.commons.domain.Cita;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface ICitaAcces {

    public String createCita(Cita cita) throws Exception;

    public Cita findCita(String id) throws Exception;

    public String updateCita(Cita cita) throws Exception;
    
    public List<Cita> CitasDisponibles(Date before, Date after, int id_lugar) throws Exception; 
    
    public List<Cita> CitasDisponibles(Date date, int id_lugar) throws Exception; 

    public String delete(Cita cita) throws Exception;
}
