/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood4life.User.access;

import blood4life.User.infra.Blood4LifeClientSocket;
import blood4life.commons.domain.Assignments;
import blood4life.commons.infra.JsonError;
import blood4life.commons.infra.Protocol;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import java.io.IOException;
import java.lang.reflect.Type;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class AssignmentsImplSockets implements IAssignmentsAccess {

    private Blood4LifeClientSocket mySocket;

    public AssignmentsImplSockets() {
        mySocket = new Blood4LifeClientSocket();
    }

    @Override
    public Assignments findAssignment(int lugar_id, Date fecha) throws Exception {
        String jsonResponse = null;
        String requestJson = doFindAssignment(lugar_id, fecha);
        Assignments assis = new Assignments();
        jsonResponse = peticionSocket(requestJson);
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor. Revise la red o que el servidor esté escuchando. ");
        } else {
            if (jsonResponse.contains("error")) {
                //Devolvió algún error
                Logger.getLogger(AssignmentsImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                if (jsonResponse.contains("info: ")) {
                    return null;
                } else {
                    //Encontró el customer
                    assis = jsonToAssignments(jsonResponse);
                    Logger.getLogger(AssignmentsImplSockets.class.getName()).log(Level.INFO, "Lo que va en el JSon: (" + jsonResponse + ")");
                    return assis;
                }
            }
        }
    }

    @Override
    public String createAssigment(int entidad_id, Date fecha, int lugar_id) throws Exception {
        String jsonResponse = null;
        String requestJson = doCreateAssigment(entidad_id, fecha, lugar_id);
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
                return "Assigment  ligado a entidad " + entidad_id + " y lugar " + lugar_id + "creado";
            }

        }

    }

    @Override
    public String deleteAssigment(int entidad_id, Date fecha, int lugar_id) throws Exception {
        String jsonResponse = null;
        String requestJson = doDeleteAssigment(entidad_id, fecha, lugar_id);
        jsonResponse = peticionSocket(requestJson);
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor");
        } else {

            if (jsonResponse.contains("error")) {
                //Devolvió algún error                
                Logger.getLogger(AssignmentsImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                //Agregó correctamente, devuelve la cedula del cita 
                return "Assigment eliminado";
            }

        }
    }

    @Override
    public List<Assignments> listAssignment(int entidad_id) throws Exception {
        String jsonResponse = null;
        String requestJson = dolistAssignmentRequestJson(entidad_id);
        jsonResponse = peticionSocket(requestJson);

        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor. Revise la red o que el servidor esté escuchando. ");
        } else {
            if (jsonResponse.contains("error")) {
                //Devolvió algún error
                Logger.getLogger(AssignmentsImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else if (jsonResponse.toLowerCase().contains("info:")) {
                Logger.getLogger(AssignmentsImplSockets.class.getName()).log(Level.INFO, "Lo que va en el JSon: ({0})", jsonResponse);
                return null;
            } else {
                //Encontró las citas
                List<Assignments> assis = jsonToList(jsonResponse);
                Logger.getLogger(AssignmentsImplSockets.class.getName()).log(Level.INFO, "Lo que va en el JSon: ({0})", jsonResponse);
                return assis;
            }
        }
    }

    private String doFindAssignment(int lugar_id, Date fecha) {

        Protocol protocol = new Protocol();
        protocol.setResource("assignments");
        protocol.setAction("get");
        protocol.addParameter("lugar_id", String.valueOf(lugar_id));
        protocol.addParameter("fecha", fecha.toString());
        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);

        return requestJson;
    }

    private String doCreateAssigment(int entidad_id, Date fecha, int lugar_id) {

        Gson gson = new Gson();
        Protocol protocol = new Protocol();
        protocol.setResource("assignments");
        protocol.setAction("post");
        protocol.addParameter("entidad_id", String.valueOf(entidad_id));
        protocol.addParameter("fecha", fecha.toString());
        protocol.addParameter("lugar_id", String.valueOf(lugar_id));

        String requestJson = gson.toJson(protocol);
        return requestJson;
    }

    private String doDeleteAssigment(int entidad_id, Date fecha, int lugar_id) {
        Gson gson = new Gson();
        Protocol protocol = new Protocol();
        protocol.setResource("assignments");
        protocol.setAction("delete");
        protocol.addParameter("entidad_id", String.valueOf(entidad_id));
        protocol.addParameter("fecha", fecha.toString());
        protocol.addParameter("lugar_id", String.valueOf(lugar_id));

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

    private Assignments jsonToAssignments(String jsonAssignments) {
        Gson gson = new Gson();
        Assignments assis = gson.fromJson(jsonAssignments, Assignments.class);
        return assis;
    }

    private String dolistAssignmentRequestJson(int entidad_id) {
        Gson gson = new Gson();
        Protocol protocol = new Protocol();
        protocol.setResource("assignments");
        protocol.setAction("getList");
        protocol.addParameter("entidad_id", String.valueOf(entidad_id));
        String requestJson = gson.toJson(protocol);
        return requestJson;
    }

    private List<Assignments> jsonToList(String jsonLista) {
        if (jsonLista.contains("info:")) {
            return null;
        } else {
            Gson gson = new Gson();
            Type type2 = new TypeToken<List<Assignments>>() {
            }.getType();
            List<Assignments> aux = gson.fromJson(jsonLista, type2);
            return aux;
        }
    }

}
