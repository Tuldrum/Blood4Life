package blood4life.server.domain.services;

public interface ITwilioWhatsappMessager {
    public boolean sendReminder(String numCel, String reminderMessage);
}
