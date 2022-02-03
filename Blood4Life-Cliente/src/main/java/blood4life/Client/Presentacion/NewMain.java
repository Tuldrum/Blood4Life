/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood4life.Client.Presentacion;

import blood4life.commons.domain.Cita;
import blood4life.commons.domain.LugarRecogida;
import blood4life.commons.domain.Sangre;
import blood4life.commons.domain.UsuarioCliente;
import blood4life.commons.infra.Protocol;
import com.google.gson.Gson;
import java.sql.Date;

/**
 *
 * @author ASUS
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        Gson gson = new Gson();
        Sangre sangre = new Sangre(1, "A", "+"); 
        UsuarioCliente newusuario = new UsuarioCliente(20000, "paco", "comerte", "paco@gmail.com", "31245678", sangre); 
        LugarRecogida lugar = new LugarRecogida(2500, "X", "Matawuarros"); 
        Cita cita = new Cita(1234566, newusuario, lugar, Date.valueOf("2022-02-02")); 
        Protocol protocol = new Protocol();
        protocol.setResource("cita");
        protocol.setAction("post");
        protocol.addParameter("id", String.valueOf(cita.getCodigo()));
        protocol.addParameter("fecha", cita.getFecha().toString());
        protocol.addParameter("lugar", gson.toJson(cita.getLugar()));
        protocol.addParameter("usuario", gson.toJson(cita.getUsuario()));
        
        
        String requestJson = gson.toJson(protocol);
        System.out.println(requestJson); 
    }
    
}
