/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood4life.commons.domain;

/**
 *
 * @author ASUS
 */
public class UsuarioCliente extends User {
    
    protected static UsuarioCliente instance;
    
    private Sangre sangre;

    public UsuarioCliente() {}

    public UsuarioCliente(int user_id, String name, String lastname, String mail, String numeroTelefono, Sangre sangre) {
        super(user_id, name, lastname, mail, numeroTelefono);
        this.sangre = sangre;  
    }

    public Sangre getSangre() {
        return sangre;
    }

    public void setSangre(Sangre sangre) {
        this.sangre = sangre;
    }

    public boolean StatusCliente(){
        return this.sangre == null && Status(); 
    }

    @Override
    public String toString(){
        return "id: " + this.user_id + " name: " + this.name;
    }
}
