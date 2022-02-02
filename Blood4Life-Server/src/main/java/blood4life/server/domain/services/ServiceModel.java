/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood4life.server.domain.services;

import blood4life.commons.domain.Assignments;
import blood4life.commons.domain.Cita;
import blood4life.commons.domain.LugarRecogida;
import blood4life.commons.domain.UsuarioCliente;
import blood4life.server.access.Factory;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class ServiceModel {
    private static Factory factory;  
    private AssignmentsService serAssis; 
    private LugaresRecogidaService serLug; 
    private UsuarioClienteService serUsuCli; 
    private CitaService serCitas;
    private ITwilioWhatsappMessager serWhatsAppReminder;
    
    public ServiceModel() {
        factory = Factory.getInstance();
        serAssis = new AssignmentsService(factory.getAssigmentRepository());
        serLug = new LugaresRecogidaService(factory.getLugaresRepository()); 
        serUsuCli = new UsuarioClienteService(factory.getClienteRepository());
        serCitas = new CitaService(factory.getCitaRepository());
        serWhatsAppReminder = new WhatsappReminder();
    }
    
    public Assignments find(int lugar_id, Date fecha, int sangre_id){
        return serAssis.find(lugar_id, fecha);  
    }
    
    public List<Assignments> list(){
        return serAssis.list();  
    }
    
    public Cita findCita(int cod_cita){
        return serCitas.find(cod_cita); 
    }
    
    public String saveCita(Cita cita){
        return serCitas.save(cita);
    }

    public String saveCita(Cita cita, UsuarioCliente cliente){
        int numCel = cliente.getNumeroTelefono();
        String infoCita = cita.infoCita();
        serWhatsAppReminder.sendReminder(numCel, infoCita);

        cita.setUsuario(cliente);
        return saveCita(cita);
    }
    
    public String crearLugarRecogida(LugarRecogida lugar){
        return serLug.crearLugarRecogida(lugar); 
    }
    
    public LugarRecogida findLugar(int id){
        return serLug.find(id);  
    }
    
    public String createCustomer(UsuarioCliente customer){
        return serUsuCli.createCustomer(customer);  
    }
    
    public UsuarioCliente findCustomer(int id){
        return serUsuCli.find(id);  
    }
}
