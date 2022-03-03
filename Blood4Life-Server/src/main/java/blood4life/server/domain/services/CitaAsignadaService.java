/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood4life.server.domain.services;

import blood4life.commons.domain.CitaAsignada;
import blood4life.commons.domain.UsuarioCliente;
import blood4life.server.access.ICitaAsignadaRepository;
import blood4life.serversocket.serversockettemplate.helpers.JsonError;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class CitaAsignadaService  {

    private ICitaAsignadaRepository repo;

    public CitaAsignadaService(ICitaAsignadaRepository repo) {
        this.repo = repo;
    }

    public synchronized CitaAsignada find(UsuarioCliente cliente) {
        return repo.find(cliente);
    }

    public synchronized List<String> getRepo () {
        return repo.getAll();
    }

    public synchronized String delete(CitaAsignada citaAsi) {
        List<JsonError> errors = new ArrayList<>();
        // Validaciones y reglas de negocio
        if (citaAsi.getCita() == null || citaAsi.getCliente() == null) {
            errors.add(new JsonError("400", "BAD_REQUEST", "el usuario, y la información de la cita son obligatorios."));
        }

        if (repo.find(citaAsi) == null) {
            errors.add(new JsonError("400", "BAD_REQUEST", "No existe esta cita "));
        }

        if (!errors.isEmpty()) {
            Gson gson = new Gson();
            String errorsJson = gson.toJson(errors);
            return errorsJson;
        }

        if (repo.delete(citaAsi)) {
            return "info: Eliminado con éxito" + citaAsi.toString();
        }
        return "error: Algo salió mal, consulte con el administrador del sistema";
    }

    public synchronized String create(CitaAsignada cita) {
        List<JsonError> errors = new ArrayList<>();

        // Validaciones y reglas de negocio
        if (cita.getCita() == null || cita.getCliente() == null) {
            errors.add(new JsonError("400", "BAD_REQUEST", "el usuario, y la información de la cita son obligatorios."));
        }

        if (find(cita.getCliente()) != null) {
            errors.add(new JsonError("400", "BAD_REQUEST", "Ya existe una cita asignada para las proximas fechas. "));
        }

        if (!errors.isEmpty()) {
            Gson gson = new Gson();
            String errorsJson = gson.toJson(errors);
            return errorsJson;
        }

        if (repo.save(cita)) {
            return "info: Guardado con éxito" + cita.toString();
        }
        return "Error: algo salió mal..consultar con el administrador del sistema";
    }
    
}
