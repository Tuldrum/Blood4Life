package blood4life.User.presentacion.interfaceStrategy;

import blood4life.User.presentacion.Cliente.GUICliente;  

public class ClienteStrategy implements IStrategy {

    @Override
    public void desplegarInterfaz() {
        GUICliente ventanaClientes = new GUICliente();
        ventanaClientes.setVisible(true);
    }
}