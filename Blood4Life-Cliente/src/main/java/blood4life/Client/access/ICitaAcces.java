/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood4life.Client.access;

import blood4life.commons.domain.Cita;

/**
 *
 * @author ASUS
 */
public interface ICitaAcces {
    
    public String createCita(Cita cita) throws Exception; 

    public Cita findCita(String id) throws Exception;
    
}
