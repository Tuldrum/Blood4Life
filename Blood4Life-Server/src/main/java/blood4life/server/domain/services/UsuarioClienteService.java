/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood4life.server.domain.services;

import blood4life.commons.domain.UsuarioCliente;
import blood4life.commons.infra.JsonError;
import blood4life.commons.infra.Utilities;
import blood4life.server.access.IClienteRepository;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class UsuarioClienteService {

    private IClienteRepository repo;

    public UsuarioClienteService(IClienteRepository repo) {
        this.repo = repo;
    }

    public synchronized UsuarioCliente find(int id) {
        return repo.find(id);
    }

    public synchronized String createCustomer(UsuarioCliente customer) {
        List<JsonError> errors = new ArrayList<>();

        // Validaciones y reglas de negocio
        if (customer.getUser_id() < 0 || customer.getName().isEmpty() || customer.getLastname().isEmpty()
                || customer.getMail().isEmpty() || customer.getNumeroTelefono() != "" || customer.getSangre() == null) {
            errors.add(new JsonError("400", "BAD_REQUEST", "id, nombres, apellidos, email y sangre, telefono son obligatorios. "));
        }

        if (!customer.getMail().contains("@")) {
            errors.add(new JsonError("400", "BAD_REQUEST", "Email debe tener una @. "));
        }

        if (!Utilities.isNumeric(String.valueOf(customer.getNumeroTelefono()))) {
            errors.add(new JsonError("400", "BAD_REQUEST", "Teléfono móvil debe contener sólo dígitos "));
        }

        if (this.find(customer.getUser_id()) != null) {
            errors.add(new JsonError("400", "BAD_REQUEST", "La cédula ya existe. "));
        }

        if (!errors.isEmpty()) {
            Gson gson = new Gson();
            String errorsJson = gson.toJson(errors);
            return errorsJson;
        }
        repo.save(customer);
        return "Guardado con exito" + customer.toString();
    }

}
