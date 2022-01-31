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
public class UsuarioCliente {
	private int user_client;
	private int user_acces;
	private String customer_name;
	private int identificacion;

	public UsuarioCliente(int user_client, int user_acces, String customer_name, int identificacion) {
		this.user_client = user_client;
		this.user_acces = user_acces;
		this.customer_name = customer_name;
		this.identificacion = identificacion;
	}

	public int getUser_client() {
		return user_client;
	}

	public void setUser_client(int user_client) {
		this.user_client = user_client;
	}

	public int getUser_acces() {
		return user_acces;
	}

	public void setUser_acces(int user_acces) {
		this.user_acces = user_acces;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public int getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(int identificacion) {
		this.identificacion = identificacion;
	}
}
