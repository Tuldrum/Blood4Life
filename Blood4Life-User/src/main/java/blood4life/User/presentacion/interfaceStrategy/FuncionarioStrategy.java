package blood4life.User.presentacion.interfaceStrategy;

import blood4life.User.presentacion.Funcionario.GUIFuncionario;

public class FuncionarioStrategy implements IStrategy{

    @Override
    public void desplegarInterfaz() {
        GUIFuncionario ventanaFuncionario = new GUIFuncionario();
        ventanaFuncionario.setVisible(true);
    }
}
