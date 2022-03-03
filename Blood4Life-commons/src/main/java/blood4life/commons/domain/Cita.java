package blood4life.commons.domain;

import java.sql.Date;
import java.sql.Time; 

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class Cita {

    private int codigo;
    private LugarRecogida lugar;
    private Date fecha;
    private Time hora; 
    private int cupos; 

    /*
    public Cita(int codigo, int cupos, LugarRecogida lugar_id, Date fecha, Time hora) {
        this.codigo = codigo;
        this.cupos = cupos;
        this.lugar = lugar_id;
        this.fecha = fecha;
    }*/
    
    /**
     * Constructor para usar en la GUICitas
     * @param codigo
     * @param cupos
     * @param fecha
     * @param hora 
     */
    public Cita(int codigo, int cupos, Date fecha, Time hora) {
        this.codigo = codigo;
        this.cupos = cupos;
        this.fecha = fecha;
        this.hora = hora;
    }
    
    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public Cita() {
    }

    public int getCupos() {
        return cupos ;
    }

    public void setCupos(int cupos) {
        this.cupos = cupos;
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
