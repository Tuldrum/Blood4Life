/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blood4life.User.access;

import blood4life.commons.domain.Cita;
import blood4life.commons.infra.JsonError;
import blood4life.commons.infra.Protocol;
import com.google.gson.Gson;
import blood4life.User.infra.Blood4LifeClientSocket;
import com.google.common.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cerqu
 */
public class CitaAccesImplSockets implements ICitaAcces {

    private Blood4LifeClientSocket mySocket;

    public CitaAccesImplSockets() {
        mySocket = new Blood4LifeClientSocket();
    }

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
                Logger.getLogger(CitaAccesImplSockets.class.getName()).log(Level.INFO, "Lo que va en el JSon: ({0})", jsonResponse);
                return cita;
            }
        }

    }

    @Override
    public List<Cita> CitasDisponibles(Date before, Date after, int id_lugar) throws Exception {
        String jsonResponse = null;
        String requestJson = doCitasDisponiblesRequestJson(before, after, id_lugar);
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
            } else if (jsonResponse.toLowerCase().contains("info:")) {
                Logger.getLogger(CitaAccesImplSockets.class.getName()).log(Level.INFO, "Lo que va en el JSon: ({0})", jsonResponse);
                return null;
            } else {
                //Encontró las citas
                List<Cita> citas = jsonToList(jsonResponse);
                Logger.getLogger(CitaAccesImplSockets.class.getName()).log(Level.INFO, "Lo que va en el JSon: ({0})", jsonResponse);
                return citas;
            }
        }
    }

    @Override
    public String createCita(Cita cita) throws Exception {
        String jsonResponse = null;
        String requestJson = doCreateCitaRequestJson(cita);
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
                return "Cita " + cita.getCodigo() + " creada";
            }

        }

    }

    @Override
    public String updateCita(Cita cita) throws Exception {
        String jsonResponse = null;
        String requestJson = doUpdateCitaRequestJson(cita);
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

    @Override
    public List<Cita> CitasDisponibles(Date date, int id_lugar) throws Exception {
        String jsonResponse = null;
        String requestJson = doCitasListaRequestJson(date, id_lugar);
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
            } else if (jsonResponse.toLowerCase().contains("info:")) {
                Logger.getLogger(CitaAccesImplSockets.class.getName()).log(Level.INFO, "Lo que va en el JSon: ({0})", jsonResponse);
                return null;
            } else {
                //Encontró las citas
                List<Cita> citas = jsonToList(jsonResponse);
                Logger.getLogger(CitaAccesImplSockets.class.getName()).log(Level.INFO, "Lo que va en el JSon: ({0})", jsonResponse);
                return citas;
            }
        }
    }

    @Override
    public String delete(Cita cita) throws Exception {
        String jsonResponse = null;
        String requestJson = doDeleteCitaRequestJson(cita);
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
                return "Cita " + cita.getCodigo() + " eliminada";
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

    private String doFindCitaRequestJson(String idCita) {

        Protocol protocol = new Protocol();
        protocol.setResource("cita");
        protocol.setAction("get");
        protocol.addParameter("id", idCita);

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);

        return requestJson;
    }

    private String doCitasDisponiblesRequestJson(Date before, Date after, int id_lugar) {

        Protocol protocol = new Protocol();
        protocol.setResource("cita");
        protocol.setAction("getlistadisponibles");
        protocol.addParameter("before", before.toString());
        protocol.addParameter("after", after.toString());
        protocol.addParameter("id_lugar", String.valueOf(id_lugar));
        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        return requestJson;
    }

    private String doCitasListaRequestJson(Date date, int id_lugar) {
        Protocol protocol = new Protocol();
        protocol.setResource("cita");
        protocol.setAction("getlista");
        protocol.addParameter("id_lugar", String.valueOf(id_lugar));
        protocol.addParameter("date", date.toString());

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        return requestJson;

    }

    private String doCreateCitaRequestJson(Cita cita) {

        Gson gson = new Gson();
        Protocol protocol = new Protocol();
        protocol.setResource("cita");
        protocol.setAction("post");
        protocol.addParameter("id", String.valueOf(cita.getCodigo()));
        protocol.addParameter("fecha", cita.getFecha().toString());
        protocol.addParameter("lugar", gson.toJson(cita.getLugar()));
        protocol.addParameter("cupos", gson.toJson(cita.getCupos()));
        protocol.addParameter("hora", gson.toJson(cita.getHora()));

        String requestJson = gson.toJson(protocol);
        return requestJson;
    }

    private String doUpdateCitaRequestJson(Cita cita) {

        Gson gson = new Gson();
        Protocol protocol = new Protocol();
        protocol.setResource("cita");
        protocol.setAction("update");
        protocol.addParameter("id", String.valueOf(cita.getCodigo()));
        protocol.addParameter("fecha", cita.getFecha().toString());
        protocol.addParameter("lugar", gson.toJson(cita.getLugar()));
        protocol.addParameter("cupos", gson.toJson(cita.getCupos()));
        protocol.addParameter("hora", gson.toJson(cita.getHora().toString()));

        String requestJson = gson.toJson(protocol);
        return requestJson;
    }

    private Cita jsonToCita(String jsonCita) {
        Gson gson = new Gson();
        Cita cita = gson.fromJson(jsonCita, Cita.class);
        return cita;
    }

    private List<Cita> jsonToList(String jsonLista) {
        if (jsonLista.contains("info:")) {
            return null;
        } else {
            Gson gson = new Gson();
            Type type2 = new TypeToken<List<Cita>>() {
            }.getType();
            List<Cita> aux = gson.fromJson(jsonLista, type2);
            return aux;
        }
    }

    private String doDeleteCitaRequestJson(Cita cita) {
        Gson gson = new Gson();
        Protocol protocol = new Protocol();
        protocol.setResource("cita");
        protocol.setAction("delete");
        protocol.addParameter("id", String.valueOf(cita.getCodigo()));
        protocol.addParameter("fecha", cita.getFecha().toString());
        protocol.addParameter("lugar", gson.toJson(cita.getLugar()));
        protocol.addParameter("cupos", gson.toJson(cita.getCupos()));
        protocol.addParameter("hora", gson.toJson(cita.getHora().toString()));

        String requestJson = gson.toJson(protocol);
        return requestJson;
    }

}
