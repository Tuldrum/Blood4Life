package blood4life.commons.domain;

public class UsuarioFuncionario extends User {

    protected static UsuarioFuncionario instance;
    private String nombreOrganizacion;

    public static UsuarioFuncionario getInstance() {
        if (instance == null) {
            instance = new UsuarioFuncionario();
        }
        return instance;
    }
    public static UsuarioFuncionario getInstance(int user_id, String name, String lastname, String mail, String numeroTelefono, String org) {
        if (instance == null) {
            instance = new UsuarioFuncionario(user_id, name, lastname, mail, numeroTelefono, org);
        }
        return instance;
    }

    private UsuarioFuncionario() {}

    private UsuarioFuncionario(int user_id, String name, String lastname, String mail, String numeroTelefono, String nombreOrganizacion) {
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
