package blood4life.User.domain.services;

import java.util.logging.Level;
import java.util.logging.Logger;

import blood4life.User.access.ISangreAcces;

public class SangreService implements ServiceImpl {
    private ISangreAcces impl;

    public SangreService(ISangreAcces impl) {
        this.impl = impl;
    }

    @Override
    public String create(Object elements) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String update(Object elements) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String delete(Object elements) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object find(Object elements) {
        int id = (int) elements;  
        try { 
            return impl.findSangre(id);
        } catch (Exception ex) {
            Logger.getLogger(CitaAsignadaService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;  
    }

    @Override
    public Object list(Object elements) {
        try {
            return impl.listaSangres();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
}
