package blood4life.User.access.Users;

import java.io.IOException;

import com.google.gson.Gson;

import blood4life.User.infra.Blood4LifeClientSocket;
import blood4life.commons.domain.User;
import blood4life.commons.domain.UsuarioCliente;
import blood4life.commons.domain.UsuarioFuncionario;
import blood4life.commons.infra.JsonError;
import blood4life.commons.infra.Protocol;

import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioImplSockets implements IUserAccess {

    private Blood4LifeClientSocket mySocket;

    public UsuarioImplSockets() {
        mySocket = new Blood4LifeClientSocket();
    }

    @Override
    public User logInUser(String id, String pw) throws Exception {
        String jsonResponse = null;
        String requestJson = doLoggerRequestJson(id, pw);
        System.out.println(requestJson);
        try {
            mySocket.connect();
            jsonResponse = mySocket.sendRequest(requestJson);
            mySocket.disconnect();
        } catch (IOException ex) {
            Logger.getLogger(UsuarioImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
        }
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor. Revise la red o que el servidor esté escuchando. ");
        } else {
            if (jsonResponse.contains("error")) {
                //Devolvió algún error
                Logger.getLogger(UsuarioImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                //Encontró el customer
                User customer = jsonToUser(jsonResponse);
                Logger.getLogger(UsuarioImplSockets.class.getName()).log(Level.INFO, "Lo que va en el JSon: ("+jsonResponse+ ")");
                return customer;
            }
        }
    }

    @Override 
    public String signUpUser (String id, String pw) throws Exception {
        String jsonResponse = null;
        String requestJson = doSignUpRequestJson(id, pw);
        System.out.println(requestJson);
        try {
            mySocket.connect();
            jsonResponse = mySocket.sendRequest(requestJson);
            mySocket.disconnect();
        } catch (IOException ex) {
            Logger.getLogger(UsuarioImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
        }
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor. Revise la red o que el servidor esté escuchando. ");
        }
        if (jsonResponse.contains("error")) {
            //Devolvió algún error
            Logger.getLogger(UsuarioImplSockets.class.getName()).log(Level.INFO, jsonResponse);
            throw new Exception(extractMessages(jsonResponse));
        }
        // Se registró el customer
        Logger.getLogger(UsuarioImplSockets.class.getName()).log(Level.INFO, "Lo que va en el JSon: ("+jsonResponse+ ")");
        return jsonResponse;
    }

    private String doSignUpRequestJson(String id, String password) {
        Protocol protocol = new Protocol();
        protocol.setResource("user");
        protocol.setAction("post");
        protocol.addParameter("id", id);
        protocol.addParameter("pw", password);

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);

        return requestJson;
    }

    private String doLoggerRequestJson(String idUser, String pwUser) {
        Protocol protocol = new Protocol();
        protocol.setResource("user");
        protocol.setAction("get");
        protocol.addParameter("id", idUser);
        protocol.addParameter("pw", pwUser);

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);

        return requestJson;
    }

    private User jsonToUser(String jsonUser) {
        Gson gson = new Gson();
        if (jsonUser.contains("sangre")){
            return gson.fromJson(jsonUser, UsuarioCliente.class);
        }
        if (jsonUser.contains("organizacion")){
            return gson.fromJson(jsonUser, UsuarioFuncionario.class);
        }
        Logger.getLogger(UsuarioImplSockets.class.getName()).log(Level.SEVERE, "El objeto devuelto por el servidor no es apto para crear un tipo de usuario");
        return null;
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
}
