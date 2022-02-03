package blood4life.Client.access;

import blood4life.commons.domain.LugarRecogida;
import java.sql.Date;
import java.util.List;

public interface ILugaresAcces {
	public LugarRecogida findLugares(String id) throws Exception;
	public String createLugar(LugarRecogida lugar) throws Exception; 
        public List<LugarRecogida> listLugaresDisponibles(Date before, Date After) throws Exception; 
}
