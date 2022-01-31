package blood4life.commons.domain;

public class Sangre {
	private int sangre_id;  
	private String tipo;  
	private String RH; 
	
	public Sangre() {}
	
	/**
	 * @param sangre_id
	 * @param tipo
	 * @param rH
	 */
	public Sangre(int sangre_id, String tipo, String rH) {
		this.sangre_id = sangre_id;
		this.tipo = tipo;
		RH = rH;
	}

	public int getSangre_id() {
		return sangre_id;
	}

	public void setSangre_id(int sangre_id) {
		this.sangre_id = sangre_id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getRH() {
		return RH;
	}

	public void setRH(String rH) {
		RH = rH;
	}	
	
}
