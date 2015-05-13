/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * clase GestorEmail contiene la configuración necesaria para poder enviar 
 *  correos electrónicos desde la aplicación
 * 
 * @author Pablo Bueno
 * @version 4
 */
public class GestorEmail {
    
    private static final String EMAIL = "eulowareupt@gmail.com";
    private static final String PASSWORD = "eulowar12345";
  
    private final Properties properties = new Properties();
    private Session session;
    
    /**
     * public GestorEmail()
     * 
     * Constructor vacío para poder instanciar la clase
     */
    public GestorEmail() { 
    }
    
    /**
     * private void init()
     * 
     * Configura los parámetros necesarios para poder realizar los envíos de
     * los correos electrónicos
     */
    private void init() {
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.port", 587);
        properties.put("mail.smtp.mail.sender", EMAIL);
        properties.put("mail.smtp.password", PASSWORD);
        properties.put("mail.smtp.user", EMAIL);
        properties.put("mail.smtp.auth", "true");
        session = Session.getDefaultInstance(properties);
    }
    
    /**
     * public void send(String destino,String asunto, String mensaje)
     * 
     * Se encarga de realizar el envío del correo electrónico
     * 
     * @param destino el destinatario del email
     * @param asunto el asunto del email
     * @param mensaje el mensaje a enviar en el email
     */
    public void send(String destino,String asunto, String mensaje) {
        init();
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(
                    (String) properties.get("mail.smtp.mail.sender")));
            message.addRecipient(Message.RecipientType.TO, 
                    new InternetAddress(destino));
            message.setSubject(asunto);
            message.setText(mensaje);
            Transport t = session.getTransport("smtp");
            t.connect((String) properties.get("mail.smtp.user"), 
                    (String) properties.get("mail.smtp.password"));
            t.sendMessage(message, message.getAllRecipients());
            t.close();
        } catch (MessagingException e) {
            return;
        }
    }
    
}
