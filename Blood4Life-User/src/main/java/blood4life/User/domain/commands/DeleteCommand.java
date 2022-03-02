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
public class DeleteCommand extends Command {
      /**
     * id de la comida a eliminar 
     */
    private Object object; 
    private String result;  
    
    /**
     * Comida previa, que permitirá deshacer la operación de modificar
     */
    private Object previous;
    
    
    public DeleteCommand(Object object, ServiceImpl impl) {
        super(impl);
        this.object = object;    
        this.hasUndo = true;
    }

    @Override
    public void execute() {
        Logger logger= LoggerFactory.getLogger(DeleteCommand.class); 
        logger.info("Comando de eliminación ejecutado. Se borró la comida " + object.toString());
        result = service.delete(object);
    }

    @Override
    public void undo() {
        Logger logger= LoggerFactory.getLogger(DeleteCommand.class); 
        logger.info("Comando de eliminación deshecho. Se restauró la comida " + this.getPrevious().toString());        
        result = service.create(this.getPrevious());
    }
    
    public Object getPrevious() {
        return previous;
    }

    public void setPrevious(Object previous) {
        this.previous = previous;
    }
    
    public String getResult(){
        return result;  
    }
}
