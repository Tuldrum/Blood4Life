package Acceso;

import blood4life.commons.domain.LugarRecogida;

public interface ILugaresAcces {
	public LugarRecogida findLugares(String id) throws Exception;
	public String createLugar(LugarRecogida lugar) throws Exception; 
}
