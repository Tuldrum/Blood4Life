package blood4life.commons.domain;

public class UsuarioFuncionario extends User {

    private String nombreOrganizacion;

    public UsuarioFuncionario() {}

    public UsuarioFuncionario(int user_id, String name, String lastname, String mail, String numeroTelefono, String nombreOrganizacion) {
        super(user_id, name, lastname, mail, numeroTelefono);
        this.nombreOrganizacion = nombreOrganizacion;
    }

    public String getNombreOrganizacion() {
        return nombreOrganizacion;
    }

    public void setNombreOrganizacion(String nombreOrganizacion) {
        this.nombreOrganizacion = nombreOrganizacion;
    }

}
