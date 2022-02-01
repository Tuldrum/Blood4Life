package blood4life.server.access;

import blood4life.commons.domain.UsuarioCliente;

public interface IClienteRepository {

    public boolean save(UsuarioCliente newCliente);

    public UsuarioCliente find(int id);
}
