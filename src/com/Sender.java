package com;

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
    String titleS;
    String messageS;
    String toS;
    String fromS;
    String passwordS;
    int counterS;
    String mailServiceS;
    String myConsoleS;
    public String getTitleS() {
        return titleS;
    }

    public void setTitleS(String titleS) {
        this.titleS = titleS;
    }

    public String getMessageS() {
        return messageS;
    }

    public void setMessageS(String messageS) {
        this.messageS = messageS;
    }

    public String getToS() {
        return toS;
    }

    public void setToS(String toS) {
        this.toS = toS;
    }

    public String getFromS() {
        return fromS;
    }

    public void setFromS(String fromS) {
        this.fromS = fromS;
    }

    public String getPasswordS() {
        return passwordS;
    }

    public void setPasswordS(String passwordS) {
        this.passwordS = passwordS;
    }

    public int getCounterS() {
        return counterS;
    }

    public void setCounterS(int counterS) {
        this.counterS = counterS;
    }

    public String getMailServiceS() {
        return mailServiceS;
    }

    public void setMailServiceS(String mailServiceS) {
        this.mailServiceS = mailServiceS;
    }

    public String getMyConsoleS() {
        return myConsoleS;
    }

    public void setMyConsoleS(String myConsoleS) {
        this.myConsoleS = myConsoleS;
    }



    public   void send( ) throws IOException, MessagingException {
        final Properties properties = new Properties();

        if (mailServiceS == new MailService().getMail()) {
            properties.load(new FileInputStream("src/mailru.properties"));
        }
        if (mailServiceS == new MailService().getYandex()) {
            properties.load(new FileInputStream("src/yandexru.properties"));
        }
        if (mailServiceS == new MailService().getGmail()) {
            properties.load(new FileInputStream("src/gmail.properties"));
        }
        if (mailServiceS == new MailService().getOther()) {
            new MyConsole().setText("Please choose adequate mail service");
        }


            Session mailSession = Session.getDefaultInstance(properties);
            MimeMessage message = new MimeMessage(mailSession);
            message.setFrom(new InternetAddress( fromS));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toS));
            message.setSubject(titleS);
            message.setText(messageS);

            for (int i = 0; i < counterS; i++) {
                Transport transport = mailSession.getTransport();
                transport.connect(null, passwordS);
                transport.sendMessage(message, message.getAllRecipients());
                transport.close();
            }
    }
}





