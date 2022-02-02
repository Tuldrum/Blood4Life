package blood4life.server.infra;

import blood4life.commons.domain.Cita;
import blood4life.commons.domain.LugarRecogida;
import blood4life.commons.domain.UsuarioCliente;
import blood4life.commons.infra.JsonError;
import blood4life.commons.infra.Protocol;
import blood4life.commons.infra.Utilities;
import blood4life.server.domain.services.ServiceModel;
import blood4life.serversocket.serversockettemplate.infra.ServerSocketTemplate;

import com.google.gson.Gson;

import java.sql.Date;

import java.util.ArrayList;
import java.util.List;

/**
 * Servidor Socket que está escuchando permanentemente solicitudes de los
 * clientes. Cada solicitud la atiende en un hilo de ejecución
 *
 * @author Libardo, Julio
 */
public class Blood4LifeServerSocket extends ServerSocketTemplate {

    /**
     * Servicio de clientes
     */
    private ServiceModel service;

    /**
     * Constructor
     */
    public Blood4LifeServerSocket() {

    }

    /**
     * Inicialización
     *
     * @return este mismo objeto
     */
    @Override
    protected ServerSocketTemplate init() {
        String portString = Utilities.loadProperty("server.port");
        PORT = Integer.parseInt(portString);
        this.setService(new ServiceModel());
        return this;
    }

    /**
     * Procesar la solicitud que proviene de la aplicación cliente
     *
     * @param requestJson petición que proviene del cliente socket en formato
     * json que viene de esta manera:
     * "{"resource":"customer","action":"get","parameters":[{"name":"id","value":"1"}]}"
     *
     */
    @Override
    protected void processRequest(String requestJson) {
        // Convertir la solicitud a objeto Protocol para poderlo procesar
        Gson gson = new Gson();
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
        cita.setLugar_id(Integer.valueOf(protocolRequest.getParameters().get(2).getValue()));
        cita.setUsuario_id(Integer.valueOf(protocolRequest.getParameters().get(3).getValue()));
        String response = getService().saveCita(cita);
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
        cliente.setNumeroTelefono(Integer.parseInt(protocolRequest.getParameters().get(4).getValue()));
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

    public ServiceModel getService() {
        return service;
    }

    public void setService(ServiceModel service) {
        this.service = service;
    }

}
