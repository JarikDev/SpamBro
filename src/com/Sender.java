package com;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class Sender {
    public   void send( ) throws IOException, MessagingException {
        final Properties properties = new Properties();

        if (new MailService().getSelectedItem() == new MailService().getMail()) {
            properties.load(new FileInputStream("src/mailru.properties"));
        }
        if (new MailService().getSelectedItem() == new MailService().getYandex()) {
            properties.load(new FileInputStream("src/yandexru.properties"));
        }
        if (new MailService().getSelectedItem() == new MailService().getGmail()) {
            properties.load(new FileInputStream("src/gmail.properties"));
        }
        if (new MailService().getSelectedItem() == new MailService().getOther()) {
            new Console().setText("Please choose adequate mail service");
        }

     // public  void send(){
            Session mailSession = Session.getDefaultInstance(properties);
            MimeMessage message = new MimeMessage(mailSession);
            message.setFrom(new InternetAddress( new From().getFrom()));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(new ToList().getToList()));
            message.setSubject(new LetterTitleArea().getLetterTitleArea());

            message.setText(new MyMessage().getMyMessage());

            for (int i = 0; i < 3; i++) {
                Transport transport = mailSession.getTransport();
                transport.connect(null, "***");
                transport.sendMessage(message, message.getAllRecipients());
                transport.close();
            }




    }
}





