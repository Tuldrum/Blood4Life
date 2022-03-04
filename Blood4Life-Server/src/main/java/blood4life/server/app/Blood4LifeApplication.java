package blood4life.server.app;

import blood4life.server.domain.services.GestorServicios;
import blood4life.server.infra.Blood4LifeHandler;
import blood4life.serversocket.serversockettemplate.infra.ServerSocketMultiThread;

public class Blood4LifeApplication {
    public static void main(String args[]){
        ServerSocketMultiThread myServer = new ServerSocketMultiThread(3000);
        Blood4LifeHandler myHandler = new Blood4LifeHandler();
        myHandler.setService(new GestorServicios());
        myServer.setServerHandler(myHandler);
        myServer.startServer();
    }
}
