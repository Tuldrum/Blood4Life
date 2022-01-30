package Negocio;

import java.sql.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */


public class Cita {
	private int usuario_id; 
	private int lugar_id;  
	private Date fecha; 
	
    public Cita() {}

	public int getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(int usuario_id) {
		this.usuario_id = usuario_id;
	}

	public int getLugar_id() {
		return lugar_id;
	}

	public void setLugar_id(int lugar_id) {
		this.lugar_id = lugar_id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public void prueba3() {
		
	}
	
}
