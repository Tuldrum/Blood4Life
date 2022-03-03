/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood4life.server.domain.services;

import blood4life.server.access.Factory;
import java.util.EnumMap;
import java.util.Map;

/**
 *
 * @author ASUS
 */
public class GestorServicios {
    
    private Factory factory;  
    private Map<ServicesEnum,Object> servicios;  
    
    public GestorServicios(){
        factory = Factory.getInstance();
        servicios = new EnumMap<>(ServicesEnum.class);  
        AssignmentsService s1 = new AssignmentsService(factory.getAssigmentRepository());  
        CitaAsignadaService s2 = new CitaAsignadaService(factory.getCitaAsignadaRepository());
        CitaService s3 =  new CitaService(factory.getCitaRepository());  
        LugaresRecogidaService s4 = new LugaresRecogidaService(factory.getLugaresRepository());    
        UsuarioClienteService s5 = new UsuarioClienteService(factory.getClienteRepository());
        EntidadService s6 = new EntidadService(factory.getEntidadRepository()); 
        
        
        servicios.put(ServicesEnum.AssignmentsService, s1);  
        servicios.put(ServicesEnum.CitaAsignadaService, s2 );    
        servicios.put(ServicesEnum.CitaService, s3);  
        servicios.put(ServicesEnum.LugaresRecogidaService, s4);    
        servicios.put(ServicesEnum.UsuarioClienteService, s5);  
        servicios.put(ServicesEnum.EntidadService, s6);  
    }
    
    public Object getService(ServicesEnum s_enum){
        return servicios.get(s_enum);
    }
    
}
