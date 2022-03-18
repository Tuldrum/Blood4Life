package blood4life.User.access;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.Gson;
import blood4life.User.infra.Blood4LifeClientSocket;
import blood4life.commons.domain.Sangre;
import blood4life.commons.infra.JsonError;
import blood4life.commons.infra.Protocol;
import java.util.Arrays;

public class SangreAccessImplSockets implements ISangreAcces {

    private Blood4LifeClientSocket mySocket;

    public SangreAccessImplSockets() {
        mySocket = new Blood4LifeClientSocket();
    }

    @Override
    public Sangre findSangre(int sangreId) {
        String jsonResponse = null;
        String requestJson = doFindSangreRequestJson(sangreId);
        Sangre sangre = new Sangre();
        jsonResponse = peticionSocket(requestJson);
        try {
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
                        sangre = jsonToSangre(jsonResponse);
                        Logger.getLogger(CitaAccesImplSockets.class.getName()).log(Level.INFO, "Lo que va en el JSon: (" + jsonResponse + ")");
                    }
                }
            }
        } catch (Exception e) {
            Logger.getLogger(CitaAccesImplSockets.class.getName()).log(Level.INFO, jsonResponse);
        }
        return sangre;
    }

    private String doFindSangreRequestJson(int sangreId) {
        Protocol protocol = new Protocol();
        protocol.setResource("sangre");
        protocol.setAction("getId");
        protocol.addParameter("id", String.valueOf(sangreId));

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);

        return requestJson;
    }

    @Override
    public List<Sangre> listaSangres() {
        String jsonResponse = null;
        String requestJson = doGetListSangreRequestJson();
        List<Sangre> sangre = new ArrayList<>();
        jsonResponse = peticionSocket(requestJson);
        try {
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
                        sangre = jsonToListSangre(jsonResponse);
                        Logger.getLogger(CitaAccesImplSockets.class.getName()).log(Level.INFO, "Lo que va en el JSon: (" + jsonResponse + ")");
                    }
                }
            }
        } catch (Exception e) {
            Logger.getLogger(CitaAccesImplSockets.class.getName()).log(Level.INFO, jsonResponse);
        }
        return sangre;
    }
    private String doGetListSangreRequestJson() {
        Protocol protocol = new Protocol();
        protocol.setResource("sangre");
        protocol.setAction("getAll");

        Gson gson = new Gson();
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
    private Sangre jsonToSangre(String jsonSangre) {
        Gson gson = new Gson();
        Sangre cita = gson.fromJson(jsonSangre, Sangre.class);
        return cita;
    }
    private List<Sangre> jsonToListSangre(String jsonSangres) {
        Gson gson = new Gson();
        Sangre[] sangres = gson.fromJson(jsonSangres, Sangre[].class);
        List<Sangre> listaSangres = new ArrayList<>();
        listaSangres.addAll(Arrays.asList(sangres));
        return listaSangres;
    }
}
