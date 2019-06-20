package fr.oc.projet.batch;

import fr.oc.projet.model.beans.utilisateur.Abonne;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EnvoyerMail {

    public void sendMessage(String objet, String contenu,Abonne abonne) {


        final String username = "applimail09@gmail.com";
        final String password = "Yocorps17";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(abonne.getEmail())
            );
            message.setSubject(objet);
            message.setText(contenu);
            Transport.send(message);
        } catch (MessagingException e) {

            e.printStackTrace();
        }
    }
}
