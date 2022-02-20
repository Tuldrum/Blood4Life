/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood4life.server.domain.services;

import blood4life.commons.domain.Cita;
import blood4life.server.access.ICitaRepository;
import blood4life.serversocket.serversockettemplate.helpers.JsonError;
import com.google.gson.Gson;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class CitaService {

    private ICitaRepository repo;

    public CitaService(ICitaRepository repo) {
        this.repo = repo;
    }

    public synchronized Cita find(int cod_cita) {
        return repo.find(cod_cita);
    }
    
    public synchronized List<Cita> citas(Date dateSqlBefore, Date dateSqlAfter, int user_id){
        return repo.list(dateSqlBefore, dateSqlAfter, user_id);  
    }

    public synchronized String save(Cita cita) {
        List<JsonError> errors = new ArrayList<>();

        // Validaciones y reglas de negocio
        if (cita.getLugar() == null || cita.getCodigo() < 0 || cita.getFecha() == null) {
            errors.add(new JsonError("400", "BAD_REQUEST", "cod_id, lugar_id, user_id, fecha son obligatorios."));
        }

        if (find(cita.getCodigo()) != null) {
            errors.add(new JsonError("400", "BAD_REQUEST", "Ya existe una cita asignada. "));
        }

        if (!errors.isEmpty()) {
            Gson gson = new Gson();
            String errorsJson = gson.toJson(errors);
            return errorsJson;
        }

        if (repo.save(cita)) {
            return "Guardado con éxito" + cita.toString();
        }
        return "Error: algo salió mal..consultar con el administrador del sistema";
    }

    public synchronized String update(Cita cita) {
        List<JsonError> errors = new ArrayList<>();

        // Validaciones y reglas de negocio
        if (cita.getLugar() == null || cita.getCodigo() < 0 || cita.getFecha() == null ) {
            errors.add(new JsonError("400", "BAD_REQUEST", "cod_id, lugar_id, fecha son obligatorios."));
        }

        if (find(cita.getCodigo()) == null) {
            errors.add(new JsonError("400", "BAD_REQUEST", "No existe una cita con ese código."));
        }

        if (!errors.isEmpty()) {
            Gson gson = new Gson();
            String errorsJson = gson.toJson(errors);
            return errorsJson;
        }

        if (repo.update(cita)) {
            return "Actualizado con éxito" + cita.toString();
        }
        return "Error: algo salió mal..consultar con el administrador del sistema";
    }

}
