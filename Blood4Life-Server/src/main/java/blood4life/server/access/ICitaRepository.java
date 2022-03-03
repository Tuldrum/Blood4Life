/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood4life.server.access;

import blood4life.commons.domain.Cita;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface ICitaRepository {
    
    public boolean save(Cita cita); 

    public List<Cita> list(Date dateSqlBefore, Date dateSqlAfter, int lugar_id) ; 
    
    public Cita find(int id); 
    
    public boolean update(Cita cita); 
    
    public List<Cita> list(Date sqlDate, int lugar_id); 
    
}
