package blood4life.User.access;

public interface ITwilioWhatsappMessager {
    public boolean sendReminder(String destinataryNumber, String reminderMessage);
}
