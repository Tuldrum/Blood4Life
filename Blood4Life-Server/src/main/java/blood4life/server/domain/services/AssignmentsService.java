/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood4life.server.domain.services;

import blood4life.commons.domain.Assignments;
import blood4life.server.access.IAssignmentsRepository;
import blood4life.serversocket.serversockettemplate.helpers.JsonError;
import com.google.gson.Gson;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import jdk.nashorn.internal.ir.Assignment;

/**
 *
 * @author ASUS
 */
public class AssignmentsService {

    private IAssignmentsRepository repo;

    public AssignmentsService(IAssignmentsRepository repo) {
        this.repo = repo;
    }

    public synchronized Assignments find(int lugar_id, Date fecha) {
        return repo.find(lugar_id, fecha);
    }

    public synchronized List<Assignments> list(String Id) {
        return repo.list(Id);
    }

    public synchronized String delete(Assignments assis) {
        List<JsonError> errors = new ArrayList<>();
        // Validaciones y reglas de negocio
        if (assis.getEntidad() == null || assis.getLugar() == null || assis.getFecha() == null) {
            errors.add(new JsonError("400", "BAD_REQUEST", "el lugar, y la información de la entidad son obligatorios."));
        }

        if (repo.find(assis) == null) {
            errors.add(new JsonError("400", "BAD_REQUEST", "No Existe esta asignación"));
        }

        if (!errors.isEmpty()) {
            Gson gson = new Gson();
            String errorsJson = gson.toJson(errors);
            return errorsJson;
        }

        if (repo.delete(assis)) {
            return "info: Eliminado con éxito" + assis.toString();
        }
        return "error: Algo salió mal, consulte con el administrador del sistema";
    }

    public synchronized String create(Assignments assis) {
        List<JsonError> errors = new ArrayList<>();

        if (assis.getEntidad() == null || assis.getLugar() == null || assis.getFecha() == null) {
            errors.add(new JsonError("400", "BAD_REQUEST", "el lugar, y la información de la entidad son obligatorios."));
        }

        if (repo.find(assis) != null) {
            errors.add(new JsonError("400", "BAD_REQUEST", "Existe esta asignación"));
        }

        if (!errors.isEmpty()) {
            Gson gson = new Gson();
            String errorsJson = gson.toJson(errors);
            return errorsJson;
        }

        if (repo.save(assis)) {
            return "info: Guardado con éxito" + assis.toString();
        }
        return "Error: algo salió mal..consultar con el administrador del sistema";
    }


}
