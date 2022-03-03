package blood4life.commons.domain;

import java.sql.Date;

public class Assignments {

    private LugarRecogida lugar; 
    private Date fecha;
    private Entidad entidad;  

    public Assignments(LugarRecogida lugar_id, Date fecha, Entidad entidad) {
        this.lugar = lugar_id;
        this.fecha = fecha;
        this.entidad = entidad;
    }

    public Entidad getEntidad() {
        return entidad;
    }

    public void setEntidad(Entidad entidad) {
        this.entidad = entidad;
    }
    
    public Assignments() {
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public LugarRecogida getLugar() {
        return lugar;
    }

    public void setLugar(LugarRecogida lugar) {
        this.lugar = lugar;
    }    
}
