/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood4life.User.domain.commands;
import blood4life.User.domain.services.ServiceImpl;

/**
 *
 * @author ASUS
 */
public abstract class Command {
    protected ServiceImpl service;  
    public Command(ServiceImpl service){
        service = service;  
    }
    
    /**
     * ¿Tiene deshacer?
     *
     */
    protected boolean hasUndo;

    /**
     * Ejecuta el comando
     */
    public abstract void execute();

    /**
     * Dehace el comando
     */
    public abstract void undo();

    public boolean hasUndo() {
        return hasUndo;
    }

    public void setHasUndo(boolean hasUndo) {
        this.hasUndo = hasUndo;
    }
}
