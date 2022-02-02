package Acceso;

import com.twilio.Twilio; 
import com.twilio.converter.Promoter; 
import com.twilio.rest.api.v2010.account.Message; 
import com.twilio.type.PhoneNumber; 
 
import java.net.URI; 
import java.math.BigDecimal; 
 
public class WhatsappServlet { 
    // Find your Account Sid and Token at twilio.com/console 
    public static final String ACCOUNT_SID = "AC5992ec956e3bb928637fdd9c3e348743"; 
    public static final String AUTH_TOKEN = "[051afd69edf649a26b87b0194047829f]"; 
 
    public static void main(String[] args) { 
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN); 
        //Podría hacerse el recorrido de un arreglo con todos los teléfonos y mensajes de citas para automatizar
        //String destinataryNumber = Logica de acceso al teléfono del usuario
        String destinataryNumber = "+573105089540";
        //String reminderMessage = Logica de acceso a los datos de la cita
        String reminderMessage = "Señor caradepapa, su cita quedó para ayer a las 3AM";
        Message message = Message.creator(
            new com.twilio.type.PhoneNumber("whatsapp:"+destinataryNumber), 
            new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),  
            reminderMessage)
            .create(); 
 
        System.out.println(message.getSid()); 
    } 
}
