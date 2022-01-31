package blood4life.server.access;

import blood4life.commons.domain.LugarRecogida;

public interface ILugaresRepository {
	 public boolean save(LugarRecogida newLugar);
	 public LugarRecogida find(int id); 
}
