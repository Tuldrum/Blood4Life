/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood4life.server.infra;

import blood4life.commons.domain.Cita;
import blood4life.commons.domain.LugarRecogida;
import blood4life.commons.domain.Sangre;
import blood4life.commons.domain.UsuarioCliente;

import com.google.gson.Gson;

import blood4life.commons.infra.JsonError;
import blood4life.commons.infra.Protocol;
import blood4life.server.domain.services.ServiceModel;
import blood4life.serversocket.serversockettemplate.infra.ServerHandler;
import java.sql.Date;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ahurtado
 */
public class Blood4LifeHandler extends ServerHandler {

    private Gson gson = new Gson();
    
    private static ServiceModel service;

    public static ServiceModel getService() {
        return service;
    }

    public static void setService(ServiceModel service) {
        Blood4LifeHandler.service = service;
    }

    @Override
    public void processRequest(String requestJson) {
        // Convertir la solicitud a objeto Protocol para poderlo procesar
        Protocol protocolRequest = gson.fromJson(requestJson, Protocol.class);

        switch (protocolRequest.getResource()) {
            case "customer":
                if (protocolRequest.getAction().equals("get")) {
                    // Consultar un customer
                    proccesGetUsuarioCliente(protocolRequest);
                }

                if (protocolRequest.getAction().equals("post")) {
                    // Agregar un customer    
                    processPostUsuarioCliente(protocolRequest);
                }
                break;
            case "cita": 
                if (protocolRequest.getAction().equals("get")) {
                    // Consultar un customer
                    proccesGetCita(protocolRequest);
                }

                if (protocolRequest.getAction().equals("post")) {
                    // Agregar un customer    
                    processPostCita(protocolRequest);
                }
                if (protocolRequest.getAction().equals("update")){
                    proccesUpdateCita(protocolRequest);  
                }
                break;
            case "lugar":
                if (protocolRequest.getAction().equals("get")) {
                    // Consultar un customer
                    proccesGetLugarRecogida(protocolRequest);
                }

                if (protocolRequest.getAction().equals("post")) {
                    // Agregar un customer    
                    proccesPostLugarRecogida(protocolRequest);
                }
                if (protocolRequest.getAction().equals("getlistadisponibles")){                    
                    processGetLugaresDisp(protocolRequest); 
                }
                break;
        }
    }

    private void proccesGetCita(Protocol protocolRequest) {
        String id = protocolRequest.getParameters().get(0).getValue();
        Cita cita = getService().findCita(Integer.parseInt(id));
        if (cita == null) {
            String errorJson = generateNotFoundErrorJson("Cita no encontrada. ");
            respond(errorJson);
        } else {
            respond(objectToJSON(cita));
        }
    }

    private void processPostCita(Protocol protocolRequest) {
        Cita cita = new Cita();
        // Reconstruir el customer a partid de lo que viene en los parámetros
        cita.setCodigo(Integer.parseInt(protocolRequest.getParameters().get(0).getValue()));
        cita.setFecha(Date.valueOf(protocolRequest.getParameters().get(1).getValue()));
        cita.setLugar(gson.fromJson(protocolRequest.getParameters().get(2).getValue(), LugarRecogida.class));
        cita.setUsuario(gson.fromJson(protocolRequest.getParameters().get(3).getValue(), UsuarioCliente.class));
        String response = getService().saveCita(cita);
        respond(response);
    }
    
    private void processGetCitasDisp(Protocol protocolRequest) {
        Date before = Date.valueOf(protocolRequest.getParameters().get(0).getValue()); 
        Date after = Date.valueOf(protocolRequest.getParameters().get(1).getValue()); 
        int id_lugar = Integer.parseInt(protocolRequest.getParameters().get(2).getValue()); 
        List<Cita> disp = getService().listCitasDisponible(before, after, id_lugar); 
        if (disp == null) {
            String errorJson = generateNotFoundErrorJson("Sin coincidencias.");
            respond(errorJson);
        } else {
            if(disp.isEmpty()){
               respond(new Gson().toJson("Info: Sin coincidencias")); 
            }else{
               respond(listToJson(disp)); 
            }
        }
    }
    
    private void proccesUpdateCita(Protocol protocolRequest) {
        Cita cita = new Cita();
        // Reconstruir el customer a partid de lo que viene en los parámetros
        cita.setCodigo(Integer.parseInt(protocolRequest.getParameters().get(0).getValue()));
        cita.setFecha(Date.valueOf(protocolRequest.getParameters().get(1).getValue()));
        cita.setLugar(gson.fromJson(protocolRequest.getParameters().get(2).getValue(), LugarRecogida.class));
        cita.setUsuario(gson.fromJson(protocolRequest.getParameters().get(3).getValue(), UsuarioCliente.class));
        String response = getService().updateCitaUsuario(cita);
        respond(response);
    }

    private void proccesGetUsuarioCliente(Protocol protocolRequest) {
        String id = protocolRequest.getParameters().get(0).getValue();
        UsuarioCliente cliente = getService().findCustomer(Integer.parseInt(id));
        if (cliente == null) {
            String errorJson = generateNotFoundErrorJson("Cita no encontrada. ");
            respond(errorJson);
        } else {
            respond(objectToJSON(cliente));
        }
    }

    private void processPostUsuarioCliente(Protocol protocolRequest) {
        UsuarioCliente cliente = new UsuarioCliente();
        // Reconstruir el customer a partid de lo que viene en los parámetros
        cliente.setUser_id(Integer.parseInt(protocolRequest.getParameters().get(0).getValue()));
        cliente.setName(protocolRequest.getParameters().get(1).getValue());
        cliente.setLastname(protocolRequest.getParameters().get(2).getValue());
        cliente.setMail(protocolRequest.getParameters().get(3).getValue());
        cliente.setNumeroTelefono(protocolRequest.getParameters().get(4).getValue());
        cliente.setSangre(gson.fromJson(protocolRequest.getParameters().get(5).getValue(),Sangre.class));
        String response = getService().createCustomer(cliente);
        respond(response);
    }

    private void proccesGetLugarRecogida(Protocol protocolRequest) {
        String id = protocolRequest.getParameters().get(0).getValue();
        LugarRecogida lugar = getService().findLugar(Integer.parseInt(id));
        if (lugar == null) {
            String errorJson = generateNotFoundErrorJson("Información del lugar no encontrada.");
            respond(errorJson);
        } else {
            respond(objectToJSON(lugar));
        }
    }

    private void proccesPostLugarRecogida(Protocol protocolRequest) {
        LugarRecogida lugar = new LugarRecogida();

        lugar.setLugar_id(Integer.parseInt(protocolRequest.getParameters().get(0).getValue()));
        lugar.setDireccion(protocolRequest.getParameters().get(1).getValue());
        lugar.setNombre(protocolRequest.getParameters().get(2).getValue());
        String response = getService().crearLugarRecogida(lugar);
        respond(response);
    }
    
    private void processGetLugaresDisp(Protocol protocolRequest) {
        Date before = Date.valueOf(protocolRequest.getParameters().get(0).getValue()); 
        Date after = Date.valueOf(protocolRequest.getParameters().get(1).getValue()); 
        List<LugarRecogida> disp = getService().listLugaresDisp(before, after); 
        if (disp == null) {
            String errorJson = generateNotFoundErrorJson("Sin coincidencias.");
            respond(errorJson);
        } else {
            if(disp.isEmpty()){
               respond(new Gson().toJson("Info: Sin coincidencias")); 
            }else{
               respond(listToJson(disp)); 
            }
        }
    }

    private String generateNotFoundErrorJson(String msg) {
        List<JsonError> errors = new ArrayList<>();
        JsonError error = new JsonError();
        error.setCode("404");
        error.setError("NOT_FOUND");
        error.setMessage(msg);
        errors.add(error);

        Gson gson = new Gson();
        String errorsJson = gson.toJson(errors);

        return errorsJson;
    }

}
