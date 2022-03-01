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
public class UpdateCommand extends Command{
    private Object actual;  
    private Object previous;
    
    public UpdateCommand(Object actual, ServiceImpl impl){
        super(impl);
        this.actual = actual;
        this.hasUndo = true;  
    }
    
     @Override
    public void execute() {
        Logger logger= LoggerFactory.getLogger(UpdateCommand.class); 
        logger.info("Comando de edición se ha ejecutado. Se grabó el elemento " + actual);            
        service.update(actual);
    }

    @Override
    public void undo() {
        Logger logger= LoggerFactory.getLogger(UpdateCommand.class); 
        logger.info("Comando de edición se ha deshecho. Se grabó el elemento " + previous);             
        service.update(previous);
    }

    public Object getPrevious() {
        return previous;
    }

    public void setPrevious(Object previous) {
        this.previous = previous;
    }
    
    
    
}
