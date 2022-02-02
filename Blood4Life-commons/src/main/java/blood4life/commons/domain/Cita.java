package blood4life.commons.domain;

import java.sql.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class Cita {

    private int codigo;
    private UsuarioCliente usuario;
    private LugarRecogida lugar;
    private Date fecha;

    public Cita(int codigo, UsuarioCliente usuario_id, LugarRecogida lugar_id, Date fecha) {
        this.codigo = codigo;
        this.usuario = usuario_id;
        this.lugar = lugar_id;
        this.fecha = fecha;
    }

    public Cita() {
    }

    public UsuarioCliente getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioCliente usuario) {
        this.usuario = usuario;
    }

    public LugarRecogida getLugar() {
        return lugar;
    }

    public void setLugar(LugarRecogida lugar) {
        this.lugar = lugar;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String infoCita() {
        return "Información:\nFecha: " + getFecha().toString() + "\nLugar: " + getLugar().getNombre() + " - " + getLugar().getDireccion();
    }
}
