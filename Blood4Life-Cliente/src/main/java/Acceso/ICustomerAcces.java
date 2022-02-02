package Acceso;

import blood4life.commons.domain.UsuarioCliente; 



public interface ICustomerAcces {
    

    public UsuarioCliente findCustomer(String id) throws Exception;
    
    public String createCustomer(UsuarioCliente customer) throws Exception;
}
