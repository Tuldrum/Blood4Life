/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood4life.server.domain.services;

import blood4life.commons.domain.LugarRecogida;
import blood4life.commons.infra.JsonError;
import blood4life.server.access.ILugaresRepository;
import com.google.gson.Gson;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class LugaresRecogidaService {
    private ILugaresRepository repo;  

    public LugaresRecogidaService(ILugaresRepository repo) {
        this.repo = repo;
    }
    
    public synchronized LugarRecogida find(int id){
        return repo.find(id); 
    }
    
    public synchronized List<LugarRecogida> list(Date before, Date after){
        return repo.list(before, after);  
    }
    
    public synchronized String create(LugarRecogida lugar){
        
        List<JsonError> errors = new ArrayList<>();
  
        // Validaciones y reglas de negocio
        if(lugar.getLugar_id()<0 || lugar.getDireccion().isEmpty()){
            errors.add(new JsonError("400", "BAD_REQUEST","Lugar_id, direccion son obligatorios."));
        }
        
        if (find(lugar.getLugar_id())!= null){
            errors.add(new JsonError("400", "BAD_REQUEST","La cédula ya existe. "));
        }
        
       if (!errors.isEmpty()) {
            Gson gson = new Gson();
            String errorsJson = gson.toJson(errors);
            return errorsJson;
       }
       repo.save(lugar);  
        return "Guardado con éxito" + lugar.toString();  
    }
}
