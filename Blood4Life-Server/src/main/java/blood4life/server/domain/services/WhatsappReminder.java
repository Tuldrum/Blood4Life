package blood4life.server.domain.services;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message; 
 
public class WhatsappReminder implements ITwilioWhatsappMessager { 
    // Find your Account Sid and Token at twilio.com/console 
    public static String ACCOUNT_SID = "";
    public static String AUTH_TOKEN = ""; 
 
    public WhatsappReminder() {
        ACCOUNT_SID = "AC5992ec956e3bb928637fdd9c3e348743"; 
        AUTH_TOKEN = "d6f536bab655f696b1dadf5f3c581b51"; 
    }

    @Override
    public boolean sendReminder(String numCel, String reminderMessage) { 
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN); 
        String destinataryNumber = "+57" + numCel;
        Message message = Message.creator(
            new com.twilio.type.PhoneNumber("whatsapp:"+destinataryNumber), 
            new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),  
            "Información de su cita: " + reminderMessage)
            .create(); 
 
        System.out.println(message.getSid()); 
        return true;
    }
}
