/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blood4life.Client.access;

import blood4life.commons.domain.LugarRecogida;
import blood4life.commons.infra.JsonError;
import blood4life.commons.infra.Protocol;
import com.google.gson.Gson;
import blood4life.Client.infra.Blood4LifeClientSocket;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cerqu
 */
public class LugaresAccesImplSockets implements ILugaresAcces{
    
    private Blood4LifeClientSocket mySocket;

    public LugaresAccesImplSockets() {
        mySocket = new Blood4LifeClientSocket();
    }

    @Override
    public LugarRecogida findLugares(String id) throws Exception {
        String jsonResponse = null;
        String requestJson = doFindLugaresRequestJson(id);
        System.out.println(requestJson);
        try {
            mySocket.connect();
            jsonResponse = mySocket.sendRequest(requestJson);
            mySocket.disconnect();

        } catch (IOException ex) {
            Logger.getLogger(LugaresAccesImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
        }
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor. Revise la red o que el servidor esté escuchando. ");
        } else {
            if (jsonResponse.contains("error")) {
                //Devolvió algún error
                Logger.getLogger(LugaresAccesImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                //Encontró el lugar
                LugarRecogida lugares = jsonToLugares(jsonResponse);
                Logger.getLogger(LugaresAccesImplSockets.class.getName()).log(Level.INFO, "Lo que va en el JSon: ("+jsonResponse.toString()+ ")");
                return lugares;
            }
        }

    }

    @Override
    public String createLugar(LugarRecogida lugar) throws Exception {
        String jsonResponse = null;
        String requestJson = doCreateLugaresRequestJson(lugar);
        try {
            mySocket.connect();
            jsonResponse = mySocket.sendRequest(requestJson);
            mySocket.disconnect();

        } catch (IOException ex) {
            Logger.getLogger(LugaresAccesImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
        }
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor");
        } else {

            if (jsonResponse.contains("error")) {
                //Devolvió algún error                
                Logger.getLogger(LugaresAccesImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                //Agregó correctamente, devuelve la cedula del customer 
                return "El lugar " + lugar.getLugar_id() + " se agregó correctamente";
            }

        }

    }
    
    private String extractMessages(String jsonResponse) {
        JsonError[] errors = jsonToErrors(jsonResponse);
        String msjs = "";
        for (JsonError error : errors) {
            msjs += error.getMessage();
        }
        return msjs;
    }

    private JsonError[] jsonToErrors(String jsonError) {
        Gson gson = new Gson();
        JsonError[] error = gson.fromJson(jsonError, JsonError[].class);
        return error;
    }

    private String doFindLugaresRequestJson(String idLugar) {

        Protocol protocol = new Protocol();
        protocol.setResource("lugar");
        protocol.setAction("get");
        protocol.addParameter("id", idLugar);

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);

        return requestJson;
    }

    private String doCreateLugaresRequestJson(LugarRecogida lugar) {

        Protocol protocol = new Protocol();
        protocol.setResource("lugar");
        protocol.setAction("post");
        protocol.addParameter("id", String.valueOf(lugar.getLugar_id()));
        protocol.addParameter("dirección", lugar.getDireccion());
        protocol.addParameter("nombre", lugar.getNombre());

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        return requestJson;
    }

    private LugarRecogida jsonToLugares(String jsonLugar) {

        Gson gson = new Gson();
        LugarRecogida lugar = gson.fromJson(jsonLugar, LugarRecogida.class);
        return lugar;

    }
}
