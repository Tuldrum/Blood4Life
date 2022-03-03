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
        ServiceImpl ser1 = new CitaAsignadaService(instance.getCitaAsignadaAcces());  
        ServiceImpl ser2 = new CitaService(instance.getCitaAcces()); 
        ServiceImpl ser3 = new LugaresServices(instance.getLugaresAcces()); 
        ServiceImpl ser4 = new CustomerClientService(instance.getCustomerAcces());
        ServiceImpl ser5 = new AssignmentsService(instance.getAssignmentsAccess());
        
        implsServices.put(ServicesEnum.CitaAsignadaService, ser1);  
        implsServices.put(ServicesEnum.CitaService, ser2);  
        implsServices.put(ServicesEnum.LugaresServices, ser3);  
        implsServices.put(ServicesEnum.CustomerClientService, ser4);  
        implsServices.put(ServicesEnum.AssignmentsService, ser5);
        
    }
    
    public ServiceImpl getImpl(ServicesEnum impl){
        for (ServicesEnum key : implsServices.keySet()) {
            if(key.toString().compareTo(impl.toString()) == 0){
                ServiceImpl ser = implsServices.get(key);  
                return ser;  
            }
        }
        return null;  
    }
    
}
