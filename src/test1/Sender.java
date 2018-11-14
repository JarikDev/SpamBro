/*
package test1;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class Sender {
    public static void main(String[] args) throws IOException, MessagingException {
        final Properties properties = new Properties();
        properties.load(new FileInputStream("src/mail.properties"));

        Session mailSession = Session.getDefaultInstance(properties);
        MimeMessage message = new MimeMessage(mailSession);
        message.setFrom(new InternetAddress("***@gmail.com"));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress("sxln1@mail.ru"));
        message.setSubject("Hello email !!!");
        message.setText("HI! this is my test message");

        for (int i = 0; i < 3; i++) {
            Transport transport=mailSession.getTransport();
            transport.connect(null,"***");
            transport.sendMessage(message,message.getAllRecipients());
            transport.close();
        }


    }
}





*/
