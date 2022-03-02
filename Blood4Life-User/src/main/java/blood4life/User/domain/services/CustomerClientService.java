/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood4life.User.domain.services;

import blood4life.User.access.Users.IClienteAcces;
import blood4life.commons.domain.UsuarioCliente;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class CustomerClientService implements ServiceImpl {

    private IClienteAcces customerAcces;

    public CustomerClientService(IClienteAcces customerAcces) {
        this.customerAcces = customerAcces;
    }

    @Override
    public String create(Object elements) {
        try {
            UsuarioCliente customer = (UsuarioCliente) elements;
            return customerAcces.createCustomer(customer);
        } catch (Exception ex) {
            Logger.getLogger(CustomerClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "error: desconocido";
    }

    @Override
    public Object find(Object elements) {
        try {
            String id = (String) elements;
            return customerAcces.findCustomer(id);

        } catch (Exception ex) {
            Logger.getLogger(CustomerClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Deprecated
    @Override
    public String update(Object elements) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Deprecated
    @Override
    public String delete(Object elements) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Deprecated
    @Override
    public Object list(Object elements) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
