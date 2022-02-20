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
public class CitaAsignada {
    private Cita cita; 
    private UsuarioCliente cliente; 

    public CitaAsignada(Cita cita, UsuarioCliente cliente) {
        this.cita = cita;
        this.cliente = cliente;
    }

    public CitaAsignada() {
    }

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }

    public UsuarioCliente getCliente() {
        return cliente;
    }

    public void setCliente(UsuarioCliente cliente) {
        this.cliente = cliente;
    }
}
