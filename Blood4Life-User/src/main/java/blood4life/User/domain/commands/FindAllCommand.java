/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood4life.User.domain.commands;

import blood4life.User.domain.services.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author ASUS
 */
public class FindAllCommand extends Command {
    
    private Object args; 
    private Object list;  
    
    public FindAllCommand(Object args, ServiceImpl impl){
        super(impl); 
        this.args = args; 
        this.hasUndo = false; 
    }
    
    @Override
    public void execute() {
        Logger logger= LoggerFactory.getLogger(FindAllCommand.class); 
        logger.info("Comando de buscar todos los elementos ejecutado." );            
        list = service.list(args);
    }

    public Object getList() {
        return list;
    }
    
    @Deprecated
    @Override
    public void undo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
