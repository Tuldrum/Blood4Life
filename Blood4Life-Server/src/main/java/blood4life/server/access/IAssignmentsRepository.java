package blood4life.server.access;

import java.util.List;

import blood4life.commons.domain.Assignments;
import java.sql.Date;

public interface IAssignmentsRepository {
    
    public List<Assignments> list();

    public Assignments find(int lugar_id, Date fecha, int sangre_id); 
}
