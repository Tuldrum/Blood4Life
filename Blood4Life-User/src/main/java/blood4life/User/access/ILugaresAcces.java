package blood4life.User.access;

import blood4life.commons.domain.LugarRecogida;
import java.sql.Date;
import java.util.List;

public interface ILugaresAcces {

    public LugarRecogida findLugares(String id) throws Exception;

    public String createLugar(LugarRecogida lugar) throws Exception;

    public String deleteLugares(LugarRecogida lugar) throws Exception;

    public String editLugares(LugarRecogida lugar) throws Exception;

    public List<LugarRecogida> listLugaresDisponibles(Date before, Date After) throws Exception;
	
    public List<LugarRecogida> listLugares() throws Exception; 
}
