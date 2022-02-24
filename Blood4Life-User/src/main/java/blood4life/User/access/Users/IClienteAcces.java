package blood4life.User.access.Users;

import blood4life.commons.domain.User;
import blood4life.commons.domain.UsuarioCliente; 

public interface IClienteAcces {
    
    public User findCustomer(String id) throws Exception;
    
    public String createCustomer(UsuarioCliente customer) throws Exception;
}
