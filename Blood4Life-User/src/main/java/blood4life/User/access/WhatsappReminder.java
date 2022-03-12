package blood4life.User.access;

import com.twilio.Twilio; 
import com.twilio.rest.api.v2010.account.Message;
import io.github.cdimascio.dotenv.Dotenv;
 
public class WhatsappReminder implements ITwilioWhatsappMessager { 
    // Find your Account Sid and Token at twilio.com/console 
    public static String ACCOUNT_SID;
    public static String AUTH_TOKEN;
 
    public boolean sendReminder(String destinataryNumber, String reminderMessage) {
        connectTwilio();
        Message message = Message.creator(
            new com.twilio.type.PhoneNumber("whatsapp:+57"+destinataryNumber), 
            new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),  
            reminderMessage)
            .create();
        System.out.println(message.getSid()); 
        return true;
    }

    private void connectTwilio() {
        Dotenv dotenv = Dotenv.configure().load();
        ACCOUNT_SID = dotenv.get("TWILIO_ACCOUNT_SID");
        AUTH_TOKEN = dotenv.get("TWILIO_AUTH_TOKEN");
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    }
}
