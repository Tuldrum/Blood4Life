/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood4life.serversocket.serversockettemplate.infra;

import blood4life.serversocket.serversockettemplate.helpers.Utilities;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Julio Hurtado, Libardo Pantoja
 */
public class ExecuteServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         ServerSocketTemplate server;
            try {
                String className = Utilities.loadProperty("className");
                server = (ServerSocketTemplate)Class.forName(className).newInstance();
                server.startServer();
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                Logger.getLogger(ExecuteServer.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
}
