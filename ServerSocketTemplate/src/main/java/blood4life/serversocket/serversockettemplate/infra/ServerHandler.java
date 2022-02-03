/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood4life.serversocket.serversockettemplate.infra;

import blood4life.serversocket.serversockettemplate.helpers.JsonError;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Type;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ahurtado
 */
public abstract class ServerHandler extends Thread implements Cloneable {

    private Socket s;
    private Scanner input;
    private PrintStream output;

    public abstract void processRequest(String request);

    public ServerHandler() {
    }

    public void setParameters(Socket s, InputStream in, OutputStream out) {
        this.s = s;
        input = new Scanner(in);
        output = new PrintStream(out);
    }

    /**
     * Cuerpo del hilo
     */
    @Override
    public void run() {
        try {
            //createStreams();
            readStream();
            closeStream();

        } catch (IOException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Eror al leer el flujo", ex);
        }
    }

    /**
     * Lee el flujo del socket
     */
    private void readStream() {
        if (input.hasNextLine()) {
            // Extrae el flujo que envió la aplicación cliente
            String request = input.nextLine();
            processRequest(request);

        } else {
            output.flush();
            String errorJson = generateErrorJson();
            output.println(errorJson);
        }
    }

    /**
     * Cierra los flujos de entrada y salida
     *
     * @throws IOException
     */
    private void closeStream() throws IOException {
        output.close();
        input.close();
        s.close();
    }

    /**
     * Genera un ErrorJson genérico
     *
     * @return error en formato json
     */
    private String generateErrorJson() {
        List<JsonError> errors = new ArrayList<>();
        JsonError error = new JsonError();
        error.setCode("400");
        error.setError("BAD_REQUEST");
        error.setMessage("Error en la solicitud");
        errors.add(error);

        Gson gson = new Gson();
        String errorJson = gson.toJson(errors);

        return errorJson;
    }

    /**
     * Convierte el objeto Customer a json para que el servidor lo envie como
     * respuesta por el socket
     *
     * @param customer cliente
     * @return customer en formato json
     */
    protected String objectToJSON(Object customer) {
        Gson gson = new Gson();
        String strObject = gson.toJson(customer);
        return strObject;
    }

    protected String listToJson(List results) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<Object>>() {
        }.getType();
        gson = new GsonBuilder().create();
        String json = gson.toJson(results, type);
        return json;
    }

    protected void respond(String response) {
        output.println(response);
    }

    /**
     * @return the s
     */
    public Socket getSocket() {
        return s;
    }

    /**
     * @param s the s to set
     */
    public void setSocket(Socket s) {
        this.s = s;
    }

}
