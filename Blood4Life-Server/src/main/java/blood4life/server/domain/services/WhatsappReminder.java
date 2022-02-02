package blood4life.server.domain.services;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message; 
 
public class WhatsappReminder implements ITwilioWhatsappMessager { 
    // Find your Account Sid and Token at twilio.com/console 
    public static final String ACCOUNT_SID = "";
    public static final String AUTH_TOKEN = ""; 
 
    public WhatsappReminder() {
        ACCOUNT_SID = "AC5992ec956e3bb928637fdd9c3e348743"; 
        AUTH_TOKEN = "d0a75f952a9a7193eac2db60ec7fa260"; 
    }

    public boolean sendReminder(int numCel, String reminderMessage) { 
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN); 
        String destinataryNumber = "+57" + String.valueOf(numCel);
        Message message = Message.creator(
            new com.twilio.type.PhoneNumber("whatsapp:"+destinataryNumber), 
            new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),  
            reminderMessage)
            .create(); 
 
        System.out.println(message.getSid()); 
        return true;
    } 
}
