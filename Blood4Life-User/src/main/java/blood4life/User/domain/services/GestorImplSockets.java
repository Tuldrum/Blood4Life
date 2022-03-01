/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood4life.User.domain.services;

import blood4life.User.access.Factory;
import java.util.EnumMap;
import java.util.Map;

/**
 *
 * @author ASUS
 */
public class GestorImplSockets {
    private Map<Impls, Object> impls; 
    private Factory instance;  
    public GestorImplSockets(){
        impls = new EnumMap<>(Impls.class);
        instance = Factory.getInstance();  
        impls.put(Impls.IClienteAcces, instance.getCustomerAcces());  
        impls.put(Impls.ICitaAcces, instance.getCitaAcces());  
        impls.put(Impls.ICitaAsignadaAcces, instance.getCitaAsignadaAcces());  
        impls.put(Impls.ILugaresAcces, instance.getLugaresAcces());  
        impls.put(Impls.IUserAccess, instance.getUsuarioAccess());  
    }
    
    public Object getImpl(Impls impl){
        return impls.get(impl);  
    }
    
}
