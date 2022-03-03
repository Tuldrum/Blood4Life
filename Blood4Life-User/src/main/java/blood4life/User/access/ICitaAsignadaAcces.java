/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood4life.User.access;

import java.util.List;

import blood4life.commons.domain.CitaAsignada;

/**
 *
 * @author ASUS
 */
public interface ICitaAsignadaAcces {

    public CitaAsignada findCitaAsiganada(String id) throws Exception; 

    public String createCitaAsignada(String cita_id, String user_id) throws Exception;

    public String deleteCitaAsiganada(String cita_id, String user_id) throws Exception;

    public List<String> listaCitasAsignadas() throws Exception;
}
