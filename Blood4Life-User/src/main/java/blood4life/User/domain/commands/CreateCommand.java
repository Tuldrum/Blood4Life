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
public class CreateCommand extends Command {

    private Object element; 
    
    public CreateCommand(Object element, ServiceImpl service){
        super(service); 
        this.element = element;   
        this.hasUndo = true; 
    }
    
    @Override
    public void execute() {
        Logger logger= LoggerFactory.getLogger(CreateCommand.class); 
        logger.info("Comando de creación ejecutado. Se creo el elemento " + element.toString());
        service.create(element);
    }

    @Override
    public void undo() {
        Logger logger= LoggerFactory.getLogger(CreateCommand.class); 
        logger.info("Comando de creación ejecutado. Se canceló la creación del elemento " + element.toString());
        service.delete(element);  
    }
    
}
