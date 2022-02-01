package blood4life.server.app;

import blood4life.server.infra.Blood4LifeServerSocket;

public class Blood4LifeApplication {
    public static void main(String args[]){
        Blood4LifeServerSocket server = new Blood4LifeServerSocket();
        server.startServer();
    }
}
