/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author ASUS
 */
public class LugarRecogida {
	private int lugar_id;
	private String direccion;
	private String nombre;

	public LugarRecogida() {
		super();
	}

	public LugarRecogida(int lugar_id, String direccion, String nombre) {
		super();
		this.lugar_id = lugar_id;
		this.direccion = direccion;
		this.nombre = nombre;
	}

	public int getLugar_id() {
		return lugar_id;
	}

	public void setLugar_id(int lugar_id) {
		this.lugar_id = lugar_id;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
