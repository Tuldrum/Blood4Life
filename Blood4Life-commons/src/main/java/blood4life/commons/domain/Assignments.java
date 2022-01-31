package blood4life.commons.domain;

import java.sql.Date;

public class Assignments {
	private int lugar_id;  
	private int sangre_id;  
	private Date fecha;
	
	public int getLugar_id() {
		return lugar_id;
	}
	
	public Assignments(int lugar_id, int sangre_id, Date fecha) {
		this.lugar_id = lugar_id;
		this.sangre_id = sangre_id;
		this.fecha = fecha;
	}

	public Assignments() {
	}

	public void setLugar_id(int lugar_id) {
		this.lugar_id = lugar_id;
	}
	
	public int getSangre_id() {
		return sangre_id;
	}
	
	public void setSangre_id(int sangre_id) {
		this.sangre_id = sangre_id;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	} 
	
}
