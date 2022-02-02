
package blood4life.Client.access;

import blood4life.commons.domain.UsuarioCliente;
import blood4life.commons.infra.JsonError;
import blood4life.commons.infra.Protocol;
import com.google.gson.Gson;
import blood4life.Client.infra.Blood4LifeClientSocket;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioClienteImplSockets implements ICustomerAcces {
    
    private Blood4LifeClientSocket mySocket;

    public UsuarioClienteImplSockets() {
        mySocket = new Blood4LifeClientSocket();
    }

    @Override
    public UsuarioCliente findCustomer(String id) throws Exception {
        String jsonResponse = null;
        String requestJson = doFindCustomerRequestJson(id);
        System.out.println(requestJson);
        try {
            mySocket.connect();
            jsonResponse = mySocket.sendRequest(requestJson);
            mySocket.disconnect();

        } catch (IOException ex) {
            Logger.getLogger(UsuarioClienteImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
        }
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor. Revise la red o que el servidor esté escuchando. ");
        } else {
            if (jsonResponse.contains("error")) {
                //Devolvió algún error
                Logger.getLogger(UsuarioClienteImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                //Encontró el customer
                UsuarioCliente customer = jsonToCustomer(jsonResponse);
                Logger.getLogger(UsuarioClienteImplSockets.class.getName()).log(Level.INFO, "Lo que va en el JSon: ("+jsonResponse.toString()+ ")");
                return customer;
            }
        }

    }

    @Override
    public String createCustomer(UsuarioCliente customer) throws Exception {
        String jsonResponse = null;
        String requestJson = doCreateCustomerRequestJson(customer);
        try {
            mySocket.connect();
            jsonResponse = mySocket.sendRequest(requestJson);
            mySocket.disconnect();

        } catch (IOException ex) {
            Logger.getLogger(UsuarioClienteImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
        }
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor");
        } else {

            if (jsonResponse.contains("error")) {
                //Devolvió algún error                
                Logger.getLogger(UsuarioClienteImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                //Agregó correctamente, devuelve la cedula del customer 
                return "El usuario " + customer.getUser_id() + " se agregó correctamente";
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

    private String doFindCustomerRequestJson(String idCustomer) {

        Protocol protocol = new Protocol();
        protocol.setResource("customer");
        protocol.setAction("get");
        protocol.addParameter("id", idCustomer);

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);

        return requestJson;
    }

    private String doCreateCustomerRequestJson(UsuarioCliente customer) {

        Protocol protocol = new Protocol();
        protocol.setResource("customer");
        protocol.setAction("post");
        protocol.addParameter("id", String.valueOf(customer.getUser_id()));
        protocol.addParameter("fistName", customer.getName());
        protocol.addParameter("lastName", customer.getLastname());
        protocol.addParameter("email", customer.getMail());
        protocol.addParameter("mobile", String.valueOf(customer.getNumeroTelefono()));
        protocol.addParameter("blood", String.valueOf(customer.getSangre()));

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        return requestJson;
    }

    private UsuarioCliente jsonToCustomer(String jsonCustomer) {

        Gson gson = new Gson();
        UsuarioCliente customer = gson.fromJson(jsonCustomer, UsuarioCliente.class);
        return customer;

    }

}
