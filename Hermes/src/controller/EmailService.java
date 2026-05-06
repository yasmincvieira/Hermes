package controller;

import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.util.Properties;


public class EmailService {

    private static final String REMETENTE = "hermes.pi.ifsc@gmail.com"; 
    private static final String SENHA_APP = "tuzmipxspkbeiuob"; 

    public static void enviarCodigo(String destinatario, String codigo) throws MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(REMETENTE, SENHA_APP);
            }
        });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(REMETENTE));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
        message.setSubject("Código de verificação - HERMES");
        message.setText("Seu código de verificação é: " + codigo + "\n\nEle expira em 5 minutos.");

        Transport.send(message);
    }
}

