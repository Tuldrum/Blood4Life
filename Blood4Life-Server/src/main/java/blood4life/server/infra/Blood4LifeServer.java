/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood4life.server.infra;

import blood4life.server.domain.services.ServiceModel;
import blood4life.serversocket.serversockettemplate.infra.ServerSocketMultiThread;


/**
 *
 * @author ahurtado
 */
public class Blood4LifeServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ServerSocketMultiThread myServer = new ServerSocketMultiThread(5000);
        Blood4LifeHandler myHandler = new Blood4LifeHandler();
        Blood4LifeHandler.setService(new ServiceModel());
        myServer.setServerHandler(myHandler);
        myServer.startServer();
    }
    
}
