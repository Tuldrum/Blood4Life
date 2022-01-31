
package co.unicauca.travelagency.server.domain;

import java.util.Date;
import org.junit.jupiter.api.Test;

import blood4life.commons.domain.Customer;
import blood4life.server.access.Factory;
import blood4life.server.access.ICustomerRepository;
import blood4life.server.domain.services.CustomerService;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Libardo, Julio
 */
public class CustomerServiceTest {


    @Test
    public void testFindCustomer() {
        System.out.println("findCustomer");
        String id = "98000001";
        ICustomerRepository repo = Factory.getInstance().getRepository();
        CustomerService instance = new CustomerService(repo);
        String expResult = "98000001";
        Customer result = instance.findCustomer(id);
        assertEquals(expResult, result.getId());
        
        // Customer que no existe
        result = instance.findCustomer("12345678");
        assertEquals(null, result);

    }
    
    @Test
    public void testCreateCustomer() {
        Customer customer = new Customer();
        customer.setId("123");
        customer.setFirstName("Juan");
        customer.setLastName("Perez");
        customer.setAddress("Calle 12 no. 12-12 Popayan");
        customer.setEmail("juanperez@gmail.com");
        customer.setGender("M");
        customer.setMobile("31234234");
        
        ICustomerRepository repo = Factory.getInstance().getRepository();
        CustomerService instance = new CustomerService(repo);
        String expResult = "123";
        String result = instance.createCustomer(customer);
        assertEquals(expResult, result);
        
        // Validar un dato erroneo
        customer.setFirstName("");
        result = instance.createCustomer(customer);
        assertTrue(result.contains("BAD_REQUEST"));
        
                
    }    
    
}
