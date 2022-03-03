/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood4life.User.access;

import blood4life.commons.domain.Entidad;

/**
 *
 * @author ASUS
 */
public interface IEntidadAccess {

    public Entidad findEntidad(String id) throws Exception;

    public String createEntidad(Entidad entidad) throws Exception;

    public String deleteEntidad(Entidad entidad) throws Exception;
}
