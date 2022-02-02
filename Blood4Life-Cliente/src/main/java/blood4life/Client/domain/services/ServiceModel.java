/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood4life.Client.domain.services;

import blood4life.Client.access.Factory;
import blood4life.Client.access.ICitaAcces;
import blood4life.Client.access.ICustomerAcces;
import blood4life.Client.access.ILugaresAcces;
import blood4life.commons.domain.Cita;
import blood4life.commons.domain.LugarRecogida;
import blood4life.commons.domain.UsuarioCliente;

/**
 *
 * @author ASUS
 */
public class ServiceModel {

    private Factory instance;
    private ICustomerAcces client;
    private ILugaresAcces lugares;
    private ICitaAcces citas;

    public ServiceModel() {
        instance = Factory.getInstance();
        client = instance.getCustomerAcces();
        lugares = instance.getLugaresAcces();
        citas = instance.getCitaAcces();
    }

    public Cita findCita(String id) throws Exception {
        return citas.findCita(id);
    }

    public String createCita(Cita cita) throws Exception {
        return citas.createCita(cita);
    }

    public LugarRecogida findLugares(String id) throws Exception {
        return lugares.findLugares(id);
    }

    public String createLugar(LugarRecogida lugar) throws Exception {
        return lugares.createLugar(lugar);
    }
    
    public UsuarioCliente findCustomer(String id) throws Exception {
        return client.findCustomer(id); 
    }
    
    public String createCustomer(UsuarioCliente customer) throws Exception {
        return client.createCustomer(customer); 
    }
}
