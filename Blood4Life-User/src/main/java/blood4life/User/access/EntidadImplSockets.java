/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood4life.User.access;

import blood4life.User.infra.Blood4LifeClientSocket;
import blood4life.commons.domain.Entidad;
import blood4life.commons.infra.JsonError;
import blood4life.commons.infra.Protocol;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class EntidadImplSockets implements IEntidadAccess {

    private Blood4LifeClientSocket mySocket;

    public EntidadImplSockets() {
        mySocket = new Blood4LifeClientSocket();
    }

    @Override
    public Entidad findEntidad(String id) throws Exception {
        String jsonResponse = null;
        String requestJson = doFindEntidad(id);
        Entidad entidad = new Entidad();
        jsonResponse = peticionSocket(requestJson);
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor. Revise la red o que el servidor esté escuchando. ");
        } else {
            if (jsonResponse.contains("error")) {
                //Devolvió algún error
                Logger.getLogger(CitaAccesImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                if (jsonResponse.contains("info: ")) {
                    return null;
                } else {
                    //Encontró el customer
                    entidad = jsonToEntidad(jsonResponse);
                    Logger.getLogger(EntidadImplSockets.class.getName()).log(Level.INFO, "Lo que va en el JSon: (" + jsonResponse.toString() + ")");
                    return entidad;
                }
            }
        }
    }

    @Override
    public String createEntidad(Entidad entidad) throws Exception {
        String jsonResponse = null;
        String requestJson = doCreateEntidad(entidad);
        jsonResponse = peticionSocket(requestJson);
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor");
        } else {

            if (jsonResponse.contains("error")) {
                //Devolvió algún error                
                Logger.getLogger(EntidadImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                //Agregó correctamente, devuelve el código del cita 
                return "Entidad " + entidad.getEntidad_id() + " creada";
            }

        }

    }

    @Override
    public String deleteEntidad(Entidad entidad) throws Exception {
        String jsonResponse = null;
        String requestJson = doDeleteEntidad(entidad);
        jsonResponse = peticionSocket(requestJson);
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor");
        } else {

            if (jsonResponse.contains("error")) {
                //Devolvió algún error                
                Logger.getLogger(EntidadImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                //Agregó correctamente, devuelve la cedula del cita 
                return "Entidad " + entidad.getEntidad_id() + " eliminada";
            }

        }
    }

    private String doFindEntidad(String user_id) {

        Protocol protocol = new Protocol();
        protocol.setResource("entidades");
        protocol.setAction("get");
        protocol.addParameter("id", user_id);

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);

        return requestJson;
    }

    private String doCreateEntidad(Entidad entidad) {

        Gson gson = new Gson();
        Protocol protocol = new Protocol();
        protocol.setResource("entidades");
        protocol.setAction("post");
        protocol.addParameter("entidad_id", String.valueOf(entidad.getEntidad_id()));
        protocol.addParameter("direccion", entidad.getDireccion());
        protocol.addParameter("nombre", entidad.getNombre());
        protocol.addParameter("telefono", entidad.getTelefono());
        String requestJson = gson.toJson(protocol);
        return requestJson;
    }

    private String doDeleteEntidad(Entidad entidad) {
        Gson gson = new Gson();
        Protocol protocol = new Protocol();
        protocol.setResource("entidades");
        protocol.setAction("delete");
        protocol.addParameter("entidad_id", String.valueOf(entidad.getEntidad_id()));
        protocol.addParameter("direccion", entidad.getDireccion());
        protocol.addParameter("nombre", entidad.getNombre());
        protocol.addParameter("telefono", entidad.getTelefono());
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
            Logger.getLogger(EntidadImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
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

    private Entidad jsonToEntidad(String jsonEntidad) {
        Gson gson = new Gson();
        Entidad entidad = gson.fromJson(jsonEntidad, Entidad.class);
        return entidad;
    }
}
