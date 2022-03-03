/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood4life.server.access;

import blood4life.commons.domain.Entidad;

/**
 *
 * @author ASUS
 */
public interface IEntidadRepository {
    public Entidad find(int id); 
    public boolean save(Entidad entidad);  
    public boolean update(Entidad entidad);
}
