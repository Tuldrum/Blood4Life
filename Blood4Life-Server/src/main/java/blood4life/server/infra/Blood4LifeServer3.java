/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood4life.server.infra;

import blood4life.server.domain.services.GestorServicios;
import blood4life.serversocket.serversockettemplate.infra.ServerSocketMultiThread;


/**
 *
 * @author ahurtado
 */
public class Blood4LifeServer3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServerSocketMultiThread myServer = new ServerSocketMultiThread(5003);
        Blood4LifeHandler myHandler = new Blood4LifeHandler();
        myHandler.setService(new GestorServicios());
        myServer.setServerHandler(myHandler);
        myServer.startServer();
    }
    
}
