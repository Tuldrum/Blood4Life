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
    private Map<Services,Object> servicios;  
    
    public GestorServicios(){
        factory = Factory.getInstance();
        servicios = new EnumMap<>(Services.class);  
        servicios.put(Services.AssignmentsService, new AssignmentsService(factory.getAssigmentRepository()));  
        servicios.put(Services.CitaAsignadaService, new CitaAsignadaService(factory.getCitaAsignadaRepository()));    
        servicios.put(Services.CitaService, new CitaService(factory.getCitaRepository()));  
        servicios.put(Services.LugaresRecogidaService, new LugaresRecogidaService(factory.getLugaresRepository()));    
        servicios.put(Services.UsuarioClienteService, new UsuarioClienteService(factory.getClienteRepository()));  
    }
    
    public Object getService(Services s_enum){
        return servicios.get(s_enum);
    }
    
}
