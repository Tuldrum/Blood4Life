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
    private static ITwilioWhatsappMessager serWhatsAppReminder;
    
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

    /*public String saveCita(Cita cita, UsuarioCliente cliente){
        String res  = serCitas.update(cita);
        if(res.contains("BAD_REQUEST")){
            return "info: No se pudo asignar la cita";
        }
        String numCel = cliente.getNumeroTelefono();
        if (numCel.isEmpty())
            return "Error: Número de teléfono no indicado";
        String infoCita = cita.infoCita();
        enviarRecordatorio(numCel, infoCita);
        cita.setUsuario(cliente);
        return res;
    }*/

    // Equis
    public void enviarRecordatorio (String numCel, String infoCita) {
        serWhatsAppReminder.sendReminder(numCel, infoCita);
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
    
   /* public String updateCitaUsuario(Cita cita){
        UsuarioCliente user = cita.getUsuario();
        String numCel = user.getNumeroTelefono();
        if (numCel.isEmpty())
            return "Error: Número de teléfono no indicado";
        String infoCita = cita.infoCita();
        enviarRecordatorio(numCel, infoCita);
        return serCitas.update(cita);
    }*/
    
    public List<Cita> listCitasDisponible(Date dateSqlBefore, Date dateSqlAfter, int lugar_id){
        return serCitas.citas(dateSqlBefore, dateSqlAfter, lugar_id); 
    }
    
    public List<LugarRecogida> listLugaresDisp(Date before, Date after){
        return serLug.listLugaresDisp(before, after);  
    }
    
    public String updatecita(Cita cita){
       return serCitas.update(cita);  
    }    
}
