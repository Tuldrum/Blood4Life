package blood4life.commons.domain;

import java.sql.Date;

public class Assignments {

    private LugarRecogida lugar_id;
    private Sangre sangre_id;
    private Date fecha;

   

    public Assignments(LugarRecogida lugar_id, Sangre sangre_id, Date fecha) {
        this.lugar_id = lugar_id;
        this.sangre_id = sangre_id;
        this.fecha = fecha;
    }

    public Assignments() {
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public LugarRecogida getLugar_id() {
        return lugar_id;
    }

    public void setLugar_id(LugarRecogida lugar_id) {
        this.lugar_id = lugar_id;
    }

    public Sangre getSangre_id() {
        return sangre_id;
    }

    public void setSangre_id(Sangre sangre_id) {
        this.sangre_id = sangre_id;
    }
    

}
