/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood4life.server.access;

import java.sql.Date;
import java.util.List;

import blood4life.commons.domain.CitaAsignada;
import blood4life.commons.domain.UsuarioCliente;

/**
 *
 * @author ASUS
 */
public interface ICitaAsignadaRepository {
    public boolean save(CitaAsignada cita);
    
    public CitaAsignada find(UsuarioCliente cliente); 
    
    public boolean delete(CitaAsignada citaAsi);
    
    public CitaAsignada find(CitaAsignada cita);

    public List<String> getAll(int lugarId, Date today);
}
