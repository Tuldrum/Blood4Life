/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Acceso;

import blood4life.commons.domain.Cita;
import blood4life.commons.infra.JsonError;
import blood4life.commons.infra.Protocol;
import com.google.gson.Gson;
import infra.Blood4LifeClientSocket;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cerqu
 */
public class CitaAccesImplSockets implements ICitaAcces{

    private Blood4LifeClientSocket mySocket;

    public CitaAccesImplSockets() {
        mySocket = new Blood4LifeClientSocket();
    }

    /**
     * Busca un Customer. Utiliza socket para pedir el servicio al servidor
     *
     * @param id cedula del cliente
     * @return Objeto Customer
     * @throws Exception cuando no pueda conectarse con el servidor
     */
    @Override
    public Cita findCita(String id) throws Exception {
        String jsonResponse = null;
        String requestJson = doFindCitaRequestJson(id);
        System.out.println(requestJson);
        try {
            mySocket.connect();
            jsonResponse = mySocket.sendRequest(requestJson);
            mySocket.disconnect();

        } catch (IOException ex) {
            Logger.getLogger(CitaAccesImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
        }
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor. Revise la red o que el servidor esté escuchando. ");
        } else {
            if (jsonResponse.contains("error")) {
                //Devolvió algún error
                Logger.getLogger(CitaAccesImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                //Encontró el customer
                Cita cita = jsonToCita(jsonResponse);
                Logger.getLogger(CitaAccesImplSockets.class.getName()).log(Level.INFO, "Lo que va en el JSon: ("+jsonResponse.toString()+ ")");
                return cita;
            }
        }

    }

    /**
     * Crea un Customer. Utiliza socket para pedir el servicio al servidor
     *
     * @param cita cliente de la agencia de viajes
     * @return devuelve la cedula del cliente creado
     * @throws Exception error crear el cliente
     */
    @Override
    public String createCita(Cita cita) throws Exception {
        String jsonResponse = null;
        String requestJson = doCreateCustomerRequestJson(cita);
        try {
            mySocket.connect();
            jsonResponse = mySocket.sendRequest(requestJson);
            mySocket.disconnect();

        } catch (IOException ex) {
            Logger.getLogger(CitaAccesImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
        }
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor");
        } else {

            if (jsonResponse.contains("error")) {
                //Devolvió algún error                
                Logger.getLogger(CitaAccesImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                //Agregó correctamente, devuelve la cedula del cita 
                return "Cita " + cita.getCodigo() + " agendada";
            }

        }

    }
    /**
     * Extra los mensajes de la lista de errores
     * @param jsonResponse lista de mensajes json
     * @return Mensajes de error
     */
    private String extractMessages(String jsonResponse) {
        JsonError[] errors = jsonToErrors(jsonResponse);
        String msjs = "";
        for (JsonError error : errors) {
            msjs += error.getMessage();
        }
        return msjs;
    }

    /**
     * Convierte el jsonError a un array de objetos jsonError
     *
     * @param jsonError
     * @return objeto MyError
     */
    private JsonError[] jsonToErrors(String jsonError) {
        Gson gson = new Gson();
        JsonError[] error = gson.fromJson(jsonError, JsonError[].class);
        return error;
    }

    /**
     * Crea una solicitud json para ser enviada por el socket
     *
     *
     * @param idCita identificación del cliente
     * @return solicitud de consulta del cliente en formato Json, algo como:
     * {"resource":"customer","action":"get","parameters":[{"name":"id","value":"98000001"}]}
     */
    private String doFindCitaRequestJson(String idCita) {

        Protocol protocol = new Protocol();
        protocol.setResource("cita");
        protocol.setAction("get");
        protocol.addParameter("id", idCita);

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);

        return requestJson;
    }

    /**
     * Crea la solicitud json de creación del cita para ser enviado por el
 socket
     *
     * @param cita objeto cita
     * @return devulve algo como:
 {"resource":"cita","action":"post","parameters":[{"name":"id","value":"980000012"},{"name":"fistName","value":"Juan"},...}]}
     */
    private String doCreateCustomerRequestJson(Cita cita) {

        Protocol protocol = new Protocol();
        protocol.setResource("cita");
        protocol.setAction("post");
        protocol.addParameter("id", String.valueOf(cita.getCodigo()));
        protocol.addParameter("fecha", cita.getFecha().toString());
        protocol.addParameter("lugar", String.valueOf(cita.getLugar_id()));
        protocol.addParameter("usuario", String.valueOf(cita.getUsuario_id()));

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        return requestJson;
    }

    /**
     * Convierte jsonCita, proveniente del server socket, de json a un
 objeto Customer
     *
     * @param jsonCita objeto cliente en formato json
     */
    private Cita jsonToCita(String jsonCita) {

        Gson gson = new Gson();
        Cita cita = gson.fromJson(jsonCita, Cita.class);
        return cita;

    }
}
