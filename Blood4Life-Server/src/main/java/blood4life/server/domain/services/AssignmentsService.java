/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood4life.server.domain.services;

import blood4life.commons.domain.Assignments;
import blood4life.server.access.IAssignmentsRepository;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class AssignmentsService {
    private IAssignmentsRepository repo;

    public AssignmentsService(IAssignmentsRepository repo) {
        this.repo = repo;
    }
    
    public synchronized Assignments find(int lugar_id, Date fecha){
        return repo.find(lugar_id, fecha); 
    }
    
    public synchronized List<Assignments> list(){
        return repo.list();  
    }
    
}
