/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood4life.server.domain.services;

import blood4life.commons.domain.Entidad;
import blood4life.server.access.IEntidadRepository;
import blood4life.serversocket.serversockettemplate.helpers.JsonError;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class EntidadService {

    private IEntidadRepository entidadRepository;

    public EntidadService(IEntidadRepository entidadRepository) {
        this.entidadRepository = entidadRepository;

    }

    public synchronized Entidad find(int id) {
        return entidadRepository.find(id);
    }

    public synchronized String create(Entidad entidad) {
        List<JsonError> errors = new ArrayList<>();

        // Validaciones y reglas de negocio
        if (entidad.getTelefono() == null || entidad.getDireccion() == null
                || entidad.getNombre()== null || entidad.getEntidad_id() < 0) {
            errors.add(new JsonError("400", "BAD_REQUEST", "código entidad, direccion, telefono, nombbre son obligatorios."));
        }

        if (find(entidad.getEntidad_id()) != null) {
            errors.add(new JsonError("400", "BAD_REQUEST", "Ya existe una cita asignada. "));
        }

        if (!errors.isEmpty()) {
            Gson gson = new Gson();
            String errorsJson = gson.toJson(errors);
            return errorsJson;
        }

        if (entidadRepository.save(entidad)) {
            return "Guardado con éxito" + entidad.toString();
        }
        return "Error: algo salió mal..consultar con el administrador del sistema";
    }

    public synchronized String delete(Entidad entidad) {
        List<JsonError> errors = new ArrayList<>();

        // Validaciones y reglas de negocio
        if (entidad.getEntidad_id() < 0) {
            errors.add(new JsonError("400", "BAD_REQUEST", "codigo de entidad obligatorio."));
        }

        if (find(entidad.getEntidad_id()) == null) {
            errors.add(new JsonError("400", "BAD_REQUEST", "No existe una entidad con ese código."));
        }

        if (!errors.isEmpty()) {
            Gson gson = new Gson();
            String errorsJson = gson.toJson(errors);
            return errorsJson;
        }

        if (entidadRepository.update(entidad)) {
            return "Eliminado con éxito" + entidad.toString();
        }
        return "Error: algo salió mal..consultar con el administrador del sistema";
    }

}
