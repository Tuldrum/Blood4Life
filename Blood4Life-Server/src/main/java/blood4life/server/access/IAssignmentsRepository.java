package blood4life.server.access;

import java.util.List;

import blood4life.commons.domain.Assignments;
import blood4life.commons.domain.CitaAsignada;
import java.sql.Date;

public interface IAssignmentsRepository {
    
    public List<Assignments> list(String Id); 

    public Assignments find(int lugar_id, Date fecha); 
    
    public boolean save(Assignments assis); 
            
    public boolean delete(Assignments assis);

    public Object find(Assignments assis);
}
