package blood4life.server.domain.services;

import com.google.gson.Gson;

import blood4life.commons.domain.Customer;
import blood4life.commons.infra.JsonError;
import blood4life.commons.infra.Utilities;
import blood4life.server.access.ICustomerRepository;

import java.util.ArrayList;
import java.util.List;


public class CustomerService {

    ICustomerRepository repo;

    public CustomerService(ICustomerRepository repo) {
        this.repo = repo;
    }
    
    public synchronized Customer findCustomer(String id) {
        return repo.findCustomer(id);
    }

    public synchronized String createCustomer(Customer customer) {
        List<JsonError> errors = new ArrayList<>();
  
        // Validaciones y reglas de negocio
        if (customer.getId().isEmpty() || customer.getFirstName().isEmpty()
                || customer.getLastName().isEmpty() || customer.getEmail().isEmpty()
                || customer.getGender().isEmpty()) {
           errors.add(new JsonError("400", "BAD_REQUEST","id, nombres, apellidos, email y género son obligatorios. "));
        }
        
        if (!customer.getEmail().contains("@")){
            errors.add(new JsonError("400", "BAD_REQUEST","Email debe tener una @. "));
        }
        
        if(!(customer.getGender().equalsIgnoreCase("M") || customer.getGender().equalsIgnoreCase("F"))){
            errors.add(new JsonError("400", "BAD_REQUEST","Sexo debo ser M o F. "));
        }      
        
        if(!Utilities.isNumeric(customer.getMobile())){
            errors.add(new JsonError("400", "BAD_REQUEST","Teléfono móvil debe contener sólo dígitos "));
            
        }
        
        Customer customerSearched = this.findCustomer(customer.getId());
        if (customerSearched != null){
            errors.add(new JsonError("400", "BAD_REQUEST","La cédula ya existe. "));
        }
        
       if (!errors.isEmpty()) {
            Gson gson = new Gson();
            String errorsJson = gson.toJson(errors);
            return errorsJson;
        }             
        return repo.createCustomer(customer);
    }


}
