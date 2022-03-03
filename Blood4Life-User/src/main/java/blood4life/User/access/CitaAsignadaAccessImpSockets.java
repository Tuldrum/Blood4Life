/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood4life.User.access;

import blood4life.User.infra.Blood4LifeClientSocket;
import blood4life.commons.domain.CitaAsignada;
import blood4life.commons.infra.JsonError;
import blood4life.commons.infra.Protocol;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class CitaAsignadaAccessImpSockets implements ICitaAsignadaAcces{

    private Blood4LifeClientSocket mySocket;

    public CitaAsignadaAccessImpSockets() {
        mySocket = new Blood4LifeClientSocket();
    }

    @Override
    public CitaAsignada findCitaAsiganada(String id) throws Exception {
        String jsonResponse = null;
        String requestJson = doFindCitaRequestJson(id);
        CitaAsignada cita = new CitaAsignada(); 
        jsonResponse = peticionSocket(requestJson);
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor. Revise la red o que el servidor esté escuchando. ");
        } else {
            if (jsonResponse.contains("error")) {
                //Devolvió algún error
                Logger.getLogger(CitaAccesImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                if(jsonResponse.contains("info: ")){
                    return null;  
                }else{
                    //Encontró el customer
                    cita = jsonToCitaAsignada(jsonResponse);
                    Logger.getLogger(CitaAccesImplSockets.class.getName()).log(Level.INFO, "Lo que va en el JSon: (" + jsonResponse.toString() + ")");
                    return cita;
                }
            }
        }
    }

    @Override
    public String createCitaAsignada(String cita_id, String user_id) throws Exception {
        String jsonResponse = null;
        String requestJson = doCreateCitaRequestJson(cita_id, user_id);
        jsonResponse = peticionSocket(requestJson);
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor");
        } else {

            if (jsonResponse.contains("error")) {
                //Devolvió algún error                
                Logger.getLogger(CitaAccesImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                //Agregó correctamente, devuelve el código del cita 
                return "Cita " + cita_id + " agendada";
            }

        }

    }

    @Override
    public String deleteCitaAsiganada(String cita_id, String user_id) throws Exception {
        String jsonResponse = null;
        String requestJson = doDeleteCitaRequestJson(cita_id, user_id);
        jsonResponse = peticionSocket(requestJson);
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor");
        } else {

            if (jsonResponse.contains("error")) {
                //Devolvió algún error                
                Logger.getLogger(CitaAccesImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                //Agregó correctamente, devuelve la cedula del cita 
                return "Cita " + cita_id + " cancelada";
            }

        }
    }

    @Override
    public List<String> listaCitasAsignadas() throws Exception {
        String jsonResponse = null;
        String requestJson = doGetTableCitaAsignadaJson();
        List<String> citas = new ArrayList<String>(); 
        jsonResponse = peticionSocket(requestJson);
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor. Revise la red o que el servidor esté escuchando. ");
        } else {
            if (jsonResponse.contains("error")) {
                //Devolvió algún error
                Logger.getLogger(CitaAccesImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                if(jsonResponse.contains("info: ")){
                    return null;  
                }else{
                    //Encontró el customer
                    citas = jsonToListaCitasAsignadas(jsonResponse);
                    Logger.getLogger(CitaAccesImplSockets.class.getName()).log(Level.INFO, "Lo que va en el JSon: (" + jsonResponse.toString() + ")");
                    return citas;
                }
            }
        }
    }

    private String doGetTableCitaAsignadaJson() {
        Protocol protocol = new Protocol();
        protocol.setResource("citaAsignada");
        protocol.setAction("getAll");

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        return requestJson;
    }

    private List<String> jsonToListaCitasAsignadas (String jsonResponse) {
        JsonArray jsonObject = JsonParser.parseString(jsonResponse).getAsJsonArray();
        List<String> listaCitasAsignadas = new ArrayList<String>();
        for (JsonElement citaAsignada : jsonObject) {
            JsonObject jsonInfo = citaAsignada.getAsJsonObject();
            listaCitasAsignadas.add(
              jsonInfo.get("nombreLugar").getAsString() + "," +
              jsonInfo.get("direccionLugar").getAsString() + "," +
              jsonInfo.get("fecha").getAsString() + "," +
              jsonInfo.get("hora").getAsString() + "," +
              jsonInfo.get("user_id").getAsString() + "," +
              jsonInfo.get("nombre").getAsString() + "," +
              jsonInfo.get("apellido").getAsString() + "," +
              jsonInfo.get("mail").getAsString() + "," +
              jsonInfo.get("telefono").getAsString() + "," +
              jsonInfo.get("tipo").getAsString() + "," +
              jsonInfo.get("rh").getAsString()
            );
        }
        return listaCitasAsignadas;
    }
   
    private String doFindCitaRequestJson(String user_id) {

        Protocol protocol = new Protocol();
        protocol.setResource("citaAsignada");
        protocol.setAction("get");
        protocol.addParameter("id", user_id);

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);

        return requestJson;
    }

    private String doCreateCitaRequestJson(String cita_id, String user_id) {

        Gson gson = new Gson();
        Protocol protocol = new Protocol();
        protocol.setResource("citaAsignada");
        protocol.setAction("post");
        protocol.addParameter("user_id", user_id);
        protocol.addParameter("cod_id", cita_id);

        String requestJson = gson.toJson(protocol);
        return requestJson;
    }

    private String doDeleteCitaRequestJson(String cita_id, String user_id) {
        Gson gson = new Gson();
        Protocol protocol = new Protocol();
        protocol.setResource("citaAsignada");
        protocol.setAction("delete");
        protocol.addParameter("user_id", user_id);
        protocol.addParameter("cod_id", cita_id);

        String requestJson = gson.toJson(protocol);
        return requestJson;
    }

    private String peticionSocket(String requestJson) {
        String jsonResponse = null;
        System.out.println(requestJson);
        try {
            mySocket.connect();
            jsonResponse = mySocket.sendRequest(requestJson);
            mySocket.disconnect();

        } catch (IOException ex) {
            Logger.getLogger(CitaAccesImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
        }
        return jsonResponse;
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
    
    private CitaAsignada jsonToCitaAsignada(String jsonCita) {
        Gson gson = new Gson();
        CitaAsignada cita = gson.fromJson(jsonCita, CitaAsignada.class);
        return cita;
    }
}
