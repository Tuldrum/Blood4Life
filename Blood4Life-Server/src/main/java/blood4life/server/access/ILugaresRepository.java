package blood4life.server.access;

import blood4life.commons.domain.LugarRecogida;
import java.sql.Date;
import java.util.List;

public interface ILugaresRepository {

    public boolean save(LugarRecogida newLugar);

    public LugarRecogida find(int id);

    public boolean update(LugarRecogida lugar);

    public boolean delete(LugarRecogida newLugar);

    public List<LugarRecogida> list(Date before, Date after);
    
    public List<LugarRecogida> list(); 
}
