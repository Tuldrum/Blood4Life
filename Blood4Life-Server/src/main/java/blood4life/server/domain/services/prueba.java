package blood4life.server.domain.services;

import blood4life.commons.domain.Sangre;
import blood4life.commons.domain.UsuarioCliente;

public class prueba {
    public static void main(String args[]){
        UsuarioCliente cliente1 = new UsuarioCliente(1, "Diego", "Collazos", "pepeperez@gmail.com", "3228871674", new Sangre(1, "1", "2"));
        String infoCita = "Holacaradebola";
        ITwilioWhatsappMessager serWhatsAppReminder = new WhatsappReminder();
        serWhatsAppReminder.sendReminder(cliente1.getNumeroTelefono(), infoCita);
    }
}
