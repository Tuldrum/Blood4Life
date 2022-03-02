/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood4life.User.domain.services;

import blood4life.User.access.ILugaresAcces;
import blood4life.commons.domain.LugarRecogida;
import java.sql.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class LugaresServices implements ServiceImpl {

    private ILugaresAcces impl;

    public LugaresServices(ILugaresAcces impl) {
        this.impl = impl;
    }

    @Override
    public String create(Object elements) {
        try {
            LugarRecogida lugar = (LugarRecogida) elements;
            return impl.createLugar(lugar);
        } catch (Exception ex) {
            Logger.getLogger(LugaresServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Error: desconocido";
    }

    @Override
    public Object find(Object elements) {
        try {
            String id = (String) elements;
            return impl.findLugares(id);
        } catch (Exception ex) {
            Logger.getLogger(LugaresServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Object list(Object elements) {
        try {
            ArrayList<Object> objects = (ArrayList<Object>) elements;
            Date before = (Date) objects.get(0);
            Date After = (Date) objects.get(1);
            return impl.listLugaresDisponibles(before, After);
        } catch (Exception ex) {
            Logger.getLogger(LugaresServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Deprecated
    @Override
    public String update(Object elements) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Deprecated
    @Override
    public String delete(Object elements) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
