package blood4life.server.app;

import blood4life.server.infra.TravelAgencyServerSocket;

public class AgenciaViajesApplication {
    public static void main(String args[]){
        TravelAgencyServerSocket server = new TravelAgencyServerSocket();
        server.startServer();
    }
}
