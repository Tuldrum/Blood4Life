/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood4life.User.domain.services;

import blood4life.User.access.FactoryImpl;
import java.util.EnumMap;
import java.util.Map;

/**
 *
 * @author ASUS
 */
public class GestorServicesImpl {
    private Map<ServicesEnum, ServiceImpl> implsServices; 
    private FactoryImpl instance;  
    
    public GestorServicesImpl(){
        implsServices = new EnumMap<>(ServicesEnum.class);
        instance = FactoryImpl.getInstance();  
        implsServices.put(ServicesEnum.CitaAsignadaService, new CitaAsignadaService(instance.getCitaAsignadaAcces()));  
        implsServices.put(ServicesEnum.CitaService, new CitaService(instance.getCitaAcces()));  
        implsServices.put(ServicesEnum.LugaresServices, new LugaresServices(instance.getLugaresAcces()));  
        
    }
    
    public ServiceImpl getImpl(ServicesEnum impl){
        return implsServices.get(impl);  
    }
    
}
