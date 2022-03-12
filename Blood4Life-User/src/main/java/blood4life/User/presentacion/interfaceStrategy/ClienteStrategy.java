package blood4life.User.presentacion.interfaceStrategy;

import blood4life.User.presentacion.Cliente.GUICliente;
import blood4life.commons.domain.UsuarioCliente;  

public class ClienteStrategy implements IStrategy {

    @Override
    public void desplegarInterfaz(Object args) {
        GUICliente ventanaClientes = new GUICliente((UsuarioCliente)args);
        ventanaClientes.setVisible(true);
    }
}