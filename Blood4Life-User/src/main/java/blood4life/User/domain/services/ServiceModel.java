/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood4life.User.domain.services;

import blood4life.User.access.FactoryImpl;
import blood4life.User.access.ICitaAcces;
import blood4life.User.access.ICitaAsignadaAcces;
import blood4life.User.access.ILugaresAcces;
import blood4life.User.access.Users.IClienteAcces;
import blood4life.User.access.Users.IUserAccess;
import blood4life.commons.domain.Cita;
import blood4life.commons.domain.CitaAsignada;
import blood4life.commons.domain.LugarRecogida;
import blood4life.commons.domain.User;
import blood4life.commons.domain.UsuarioCliente;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class ServiceModel {

    private FactoryImpl instance;
    private IClienteAcces client;
    private ILugaresAcces lugares;
    private ICitaAcces citas;
    private ICitaAsignadaAcces citasAsi; 
    private IUserAccess usuarios;

    public ServiceModel() {
        instance = FactoryImpl.getInstance();
        client = instance.getCustomerAcces();
        lugares = instance.getLugaresAcces();
        citas = instance.getCitaAcces();
        citasAsi = instance.getCitaAsignadaAcces(); 
        usuarios = instance.getUsuarioAccess();
    }

    public User logear(String id, String pw) throws Exception {
        return usuarios.logInUser(id, pw);
    }

    public Cita findCita(String id) throws Exception {
        return citas.findCita(id);
    }

    public String createCita(Cita cita) throws Exception {
        return citas.createCita(cita);
    }

    public String updateCita(Cita cita) throws Exception {
        return citas.updateCita(cita);
    }

    public List<Cita> citasDisponibles(Date before, Date after, int id_lugar) throws Exception {
        return citas.CitasDisponibles(before, after, id_lugar);
    }

    public LugarRecogida findLugares(String id) throws Exception {
        return lugares.findLugares(id);
    }

    public List<LugarRecogida> listLugaresDisponibles(Date before, Date after) throws Exception {
        return lugares.listLugaresDisponibles(before, after);
    }

    public String createLugar(LugarRecogida lugar) throws Exception {
        return lugares.createLugar(lugar);
    }

    public User findCustomer(String id) throws Exception {
        return client.findCustomer(id);
    }

    public String createCustomer(UsuarioCliente customer) throws Exception {
        return client.createCustomer(customer);
    }
    
    public CitaAsignada findCitaAsiganada(String id) throws Exception{
        return citasAsi.findCitaAsiganada(id); 
    }

    public String createCitaAsignada(String cita_id, String user_id) throws Exception{
        return citasAsi.createCitaAsignada(cita_id, user_id); 
    }

    public String deleteCitaAsiganada(String cita_id, String user_id) throws Exception{
        return citasAsi.deleteCitaAsiganada(cita_id, user_id);  
    }

}
