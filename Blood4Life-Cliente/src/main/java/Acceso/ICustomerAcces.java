package Acceso;

import blood4life.commons.domain.LugaresAcces;



public interface ICustomerAcces {
    

    public LugaresAcces findCustomer(String id) throws Exception;
    
    public String createCustomer(LugaresAcces customer) throws Exception;
}
