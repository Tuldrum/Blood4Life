/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood4life.server.infra;

import blood4life.commons.domain.Assignments;
import blood4life.commons.domain.Cita;
import blood4life.commons.domain.CitaAsignada;
import blood4life.commons.domain.Entidad;
import blood4life.commons.domain.LugarRecogida;
import blood4life.commons.domain.UsuarioCliente;

import com.google.gson.Gson;

import blood4life.commons.infra.JsonError;
import blood4life.commons.infra.Protocol;
import blood4life.server.domain.services.AssignmentsService;
import blood4life.server.domain.services.CitaAsignadaService;
import blood4life.server.domain.services.CitaService;
import blood4life.server.domain.services.EntidadService;
import blood4life.server.domain.services.GestorServicios;
import blood4life.server.domain.services.LugaresRecogidaService;
import blood4life.server.domain.services.ServicesEnum;
import blood4life.server.domain.services.UsuarioClienteService;
import blood4life.serversocket.serversockettemplate.infra.ServerHandler;
import java.sql.Date;
import java.sql.Time;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ahurtado
 */
public class Blood4LifeHandler extends ServerHandler {

    private Gson gson = new Gson();

    private static GestorServicios services;

    public static GestorServicios getService() {
        return services;
    }

    public void setService(GestorServicios services) {
        Blood4LifeHandler.services = services;
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
                if (protocolRequest.getAction().equals("update")) {
                    proccesUpdateCita(protocolRequest);
                }
                if (protocolRequest.getAction().equals("getlistadisponibles")) {
                    processGetCitasDisp(protocolRequest);
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
                if (protocolRequest.getAction().equals("getlistadisponibles")) {
                    processGetLugaresDisp(protocolRequest);
                }
                break;
            case "citaAsignada":
                procesarCitaAsignada(protocolRequest);
                break;

            case "assignments":
                procesarAssignments(protocolRequest);
                break;
                
            case "entidades":
                procesarEntidades(protocolRequest);
                break;
        }
    }

    private void procesarEntidades(Protocol protocolRequest) {
        if (protocolRequest.getAction().equals("get")) {
            proccesGetEntidades(protocolRequest);
        }
        if (protocolRequest.getAction().equals("post")) {
            proccesPostEntidades(protocolRequest);
        }
        if (protocolRequest.getAction().equals("delete")) {
            proccesDeleteEntidades(protocolRequest);
        }
    }
    
    private void procesarAssignments(Protocol protocolRequest) {
        if (protocolRequest.getAction().equals("get")) {
            proccesGetAssignment(protocolRequest);
        }

        if (protocolRequest.getAction().equals("post")) {
            proccesPostAssignment(protocolRequest);
        }
        if (protocolRequest.getAction().equals("delete")) {
            proccesDeleteAssignment(protocolRequest);
        }
        if (protocolRequest.getAction().equals("getList")) {
            proccesGetListAssignment(protocolRequest);
        }

    }

    private void procesarCitaAsignada(Protocol protocolRequest) {
        if (protocolRequest.getAction().equals("get")) {
            proccesGetCitaAsiganda(protocolRequest);
        }

        if (protocolRequest.getAction().equals("post")) {
            proccesPostCitaAsignada(protocolRequest);
        }
        if (protocolRequest.getAction().equals("delete")) {
            proccesDeleteCitaAsignada(protocolRequest);
        }
    }

    private void proccesGetCitaAsiganda(Protocol protocolRequest) {
        String id = protocolRequest.getParameters().get(0).getValue();
        UsuarioCliente cliente = ((UsuarioClienteService) getService(ServicesEnum.UsuarioClienteService)).find(Integer.parseInt(id));
        if (cliente == null) {
            String errorJson = generateNotFoundErrorJson("Usuario no encontrado. ");
            respond(errorJson);
        } else {
            CitaAsignada cita = ((CitaAsignadaService) getService(ServicesEnum.CitaAsignadaService)).find(cliente);
            if (cita == null) {
                String errorJson = "info: sin citas proximas";
                respond(errorJson);
            }
            respond(objectToJSON(cita));
        }
    }

    private void proccesPostCitaAsignada(Protocol protocolRequest) {
        int cod_user = Integer.parseInt(protocolRequest.getParameters().get(0).getValue());
        int cod_cit = Integer.parseInt(protocolRequest.getParameters().get(1).getValue());
        CitaAsignada cita = new CitaAsignada();
        cita.setCita(((CitaService) getService(ServicesEnum.CitaService)).find(cod_cit));
        cita.setCliente(((UsuarioClienteService) getService(ServicesEnum.UsuarioClienteService)).find(cod_user));
        String saveCitaAsignada = ((CitaAsignadaService) getService(ServicesEnum.CitaAsignadaService)).create(cita);
        respond(saveCitaAsignada);
    }

    private void proccesDeleteCitaAsignada(Protocol protocolRequest) {
        int cod_user = Integer.parseInt(protocolRequest.getParameters().get(0).getValue());
        int cod_cit = Integer.parseInt(protocolRequest.getParameters().get(1).getValue());
        CitaAsignada cita = new CitaAsignada();
        cita.setCita(((CitaService) getService(ServicesEnum.CitaService)).find(cod_cit));
        cita.setCliente(((UsuarioClienteService) getService(ServicesEnum.UsuarioClienteService)).find(cod_user));
        String deleteCitaAsignada = ((CitaAsignadaService) getService(ServicesEnum.CitaAsignadaService)).delete(cita);
        respond(deleteCitaAsignada);
    }

    private void proccesGetCita(Protocol protocolRequest) {
        String id = protocolRequest.getParameters().get(0).getValue();
        Cita cita = ((CitaService) getService(ServicesEnum.CitaService)).find(Integer.parseInt(id));
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
        cita.setCupos(Integer.parseInt(protocolRequest.getParameters().get(3).getValue()));
        String response = ((CitaService) getService(ServicesEnum.CitaService)).create(cita);
        respond(response);
    }

    private void proccesUpdateCita(Protocol protocolRequest) {
        Cita cita = new Cita();
        // Reconstruir el customer a partid de lo que viene en los parámetros
        cita.setCodigo(Integer.parseInt(protocolRequest.getParameters().get(0).getValue()));
        cita.setFecha(Date.valueOf(protocolRequest.getParameters().get(1).getValue()));
        cita.setLugar(gson.fromJson(protocolRequest.getParameters().get(2).getValue(), LugarRecogida.class));
        cita.setCupos(Integer.parseInt(protocolRequest.getParameters().get(3).getValue()));
        String s = protocolRequest.getParameters().get(4).getValue();
        cita.setHora(Time.valueOf(simpleformat(s)));
        String response = ((CitaService) getService(ServicesEnum.CitaService)).update(cita);
        respond(response);
    }

    private String simpleformat(String param) {
        String aux[] = param.split("\"");
        return aux[1];
    }

    private void processGetCitasDisp(Protocol protocolRequest) {
        Date before = Date.valueOf(protocolRequest.getParameters().get(0).getValue());
        Date after = Date.valueOf(protocolRequest.getParameters().get(1).getValue());
        int id_lugar = Integer.parseInt(protocolRequest.getParameters().get(2).getValue());
        List<Cita> disp = ((CitaService) getService(ServicesEnum.CitaService)).list(before, after, id_lugar);
        if (disp == null) {
            String errorJson = generateNotFoundErrorJson("Sin coincidencias.");
            respond(errorJson);
        } else {
            if (disp.isEmpty()) {
                respond(new Gson().toJson("Info: Sin coincidencias"));
            } else {
                respond(listToJson(disp));
            }
        }
    }

    private void proccesGetUsuarioCliente(Protocol protocolRequest) {
        String id = protocolRequest.getParameters().get(0).getValue();
        UsuarioCliente cliente = ((UsuarioClienteService) getService(ServicesEnum.UsuarioClienteService)).find(Integer.parseInt(id));
        if (cliente == null) {
            String errorJson = generateNotFoundErrorJson("Cita no encontrada. ");
            respond(errorJson);
        } else {
            respond(objectToJSON(cliente));
        }
    }

    private void processPostUsuarioCliente(Protocol protocolRequest) {
        UsuarioCliente cliente = UsuarioCliente.getInstance();
        // Se llama al singleton de UsuarioCliente
        // // Reconstruir el customer a partid de lo que viene en los parámetros
        // cliente.setUser_id(Integer.parseInt(protocolRequest.getParameters().get(0).getValue()));
        // cliente.setName(protocolRequest.getParameters().get(1).getValue());
        // cliente.setLastname(protocolRequest.getParameters().get(2).getValue());
        // cliente.setMail(protocolRequest.getParameters().get(3).getValue());
        // cliente.setNumeroTelefono(protocolRequest.getParameters().get(4).getValue());
        // cliente.setSangre(gson.fromJson(protocolRequest.getParameters().get(5).getValue(), Sangre.class));
        String response = ((UsuarioClienteService) getService(ServicesEnum.UsuarioClienteService)).create(cliente);
        respond(response);
    }

    private void proccesGetLugarRecogida(Protocol protocolRequest) {
        String id = protocolRequest.getParameters().get(0).getValue();
        LugarRecogida lugar = ((LugaresRecogidaService) getService(ServicesEnum.LugaresRecogidaService)).find(Integer.parseInt(id));
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
        String response = ((LugaresRecogidaService) getService(ServicesEnum.LugaresRecogidaService)).create(lugar);
        respond(response);
    }

    private void processGetLugaresDisp(Protocol protocolRequest) {
        Date before = Date.valueOf(protocolRequest.getParameters().get(0).getValue());
        Date after = Date.valueOf(protocolRequest.getParameters().get(1).getValue());
        List<LugarRecogida> disp = ((LugaresRecogidaService) getService(ServicesEnum.LugaresRecogidaService)).list(before, after);
        if (disp == null) {
            String errorJson = generateNotFoundErrorJson("Sin coincidencias.");
            respond(errorJson);
        } else {
            if (disp.isEmpty()) {
                respond(new Gson().toJson("Info: Sin coincidencias"));
            } else {
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

    public Object getService(ServicesEnum s_enum) {
        return services.getService(s_enum);
    }

    private void proccesGetAssignment(Protocol protocolRequest) {
        int lugar_id = Integer.parseInt(protocolRequest.getParameters().get(0).getValue());
        String sdate = protocolRequest.getParameters().get(1).getValue();
        Date fecha = Date.valueOf(sdate);

        Assignments assis = ((AssignmentsService) getService(ServicesEnum.AssignmentsService)).find(lugar_id, fecha);

        if (assis == null) {
            String errorJson = generateNotFoundErrorJson("Asignación no encontrada. ");
            respond(errorJson);
        } else {
            respond(objectToJSON(assis));
        }
    }

    private void proccesPostAssignment(Protocol protocolRequest) {
        Assignments assis = new Assignments();

        assis.setEntidad(
                ((EntidadService) getService(ServicesEnum.EntidadService))
                        .find(Integer.parseInt(protocolRequest.getParameters().get(0).getValue())));

        assis.setFecha(Date.valueOf(protocolRequest.getParameters().get(1).getValue()));

        assis.setLugar(((LugaresRecogidaService) getService(ServicesEnum.LugaresRecogidaService))
                .find(Integer.parseInt(protocolRequest.getParameters().get(2).getValue())));

        String response = ((AssignmentsService) getService(ServicesEnum.AssignmentsService)).create(assis);
        respond(response);
    }

    private void proccesDeleteAssignment(Protocol protocolRequest) {
        Assignments assis = new Assignments();

        assis.setEntidad(
                ((EntidadService) getService(ServicesEnum.EntidadService))
                        .find(Integer.parseInt(protocolRequest.getParameters().get(0).getValue())));

        assis.setFecha(Date.valueOf(protocolRequest.getParameters().get(1).getValue()));

        assis.setLugar(((LugaresRecogidaService) getService(ServicesEnum.LugaresRecogidaService))
                .find(Integer.parseInt(protocolRequest.getParameters().get(2).getValue())));

        String response = ((AssignmentsService) getService(ServicesEnum.AssignmentsService)).delete(assis);
        respond(response);

    }

    private void proccesGetListAssignment(Protocol protocolRequest) {
        String id = protocolRequest.getParameters().get(0).getValue();
        List<Assignments> list = ((AssignmentsService) getService(ServicesEnum.AssignmentsService)).list(id);

        if (list == null) {
            String errorJson = generateNotFoundErrorJson("Sin coincidencias.");
            respond(errorJson);
        } else {
            if (list.isEmpty()) {
                respond(new Gson().toJson("Info: Sin coincidencias"));
            } else {
                respond(listToJson(list));
            }
        }
    }
    
    private void proccesGetEntidades(Protocol protocolRequest) {
        int entidad_id = Integer.parseInt(protocolRequest.getParameters().get(0).getValue());
        Entidad entidad = ((EntidadService) getService(ServicesEnum.EntidadService)).find(entidad_id);
        if (entidad == null) {
            String errorJson = generateNotFoundErrorJson("Entidad no encontrada.");
            respond(errorJson);
        } else {
            respond(objectToJSON(entidad));
        }
    }

    private void proccesPostEntidades(Protocol protocolRequest) {
        Entidad entidad = new Entidad();
        entidad.setEntidad_id(Integer.parseInt(protocolRequest.getParameters().get(0).getValue()));
        entidad.setDireccion(protocolRequest.getParameters().get(1).getValue());
        entidad.setNombre(protocolRequest.getParameters().get(2).getValue());
        entidad.setTelefono(protocolRequest.getParameters().get(2).getValue());
        String response = ((EntidadService) getService(ServicesEnum.EntidadService)).create(entidad);
        respond(response); 
    }

    private void proccesDeleteEntidades(Protocol protocolRequest) {
        Entidad entidad = new Entidad();
        entidad.setEntidad_id(Integer.parseInt(protocolRequest.getParameters().get(0).getValue()));
        entidad.setDireccion(protocolRequest.getParameters().get(1).getValue());
        entidad.setNombre(protocolRequest.getParameters().get(2).getValue());
        entidad.setTelefono(protocolRequest.getParameters().get(2).getValue());
        String response = ((EntidadService) getService(ServicesEnum.EntidadService)).delete(entidad);
        respond(response); 
    }
}
