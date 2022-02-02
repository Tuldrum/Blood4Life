/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood4life.server.access;

import blood4life.commons.domain.Sangre;

/**
 *
 * @author ASUS
 */
public interface ISangreRepository {
    public Sangre find(int id);  
    public boolean save(Sangre sangre);  
}
