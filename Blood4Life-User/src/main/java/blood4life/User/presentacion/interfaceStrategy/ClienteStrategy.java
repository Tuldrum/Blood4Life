package blood4life.User.presentacion.interfaceStrategy;

import blood4life.User.presentacion.Cliente.VisualizarLugares;

public class ClienteStrategy implements IStrategy {

    @Override
    public void desplegarInterfaz() {
        VisualizarLugares ventanaClientes = new VisualizarLugares();
        ventanaClientes.setVisible(true);
    }
}
