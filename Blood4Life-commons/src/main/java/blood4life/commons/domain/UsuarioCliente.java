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
public class UsuarioCliente {

    private int user_id;
    private String name;
    private String lastname;
    private String mail;
    private int numeroTelefono;
    private int sangre;

    /**
     * @param user_id
     * @param name
     * @param lastname
     * @param mail
     * @param numeroTelefono
     * @param sangre
     */
    public UsuarioCliente(int user_id, String name, String lastname, String mail, int numeroTelefono, int sangre) {
        this.user_id = user_id;
        this.name = name;
        this.lastname = lastname;
        this.mail = mail;
        this.numeroTelefono = numeroTelefono;
        this.sangre = sangre;
    }

    public UsuarioCliente() {
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(int numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public int getSangre() {
        return sangre;
    }

    public void setSangre(int sangre) {
        this.sangre = sangre;
    }

}
