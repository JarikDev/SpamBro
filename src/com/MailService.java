package com;

import javax.swing.*;
import java.awt.datatransfer.StringSelection;

public class MailService extends JComboBox<String> {
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getYandex() {
        return yandex;
    }

    public void setYandex(String yandex) {
        this.yandex = yandex;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    String mail="@mail.ru " ;
    String yandex="@yandex.ru " ;
    String gmail="@gmail.ru " ;
    String other="some shitty unsupported service " ;


    public MailService() {
        addItem(mail);
        addItem(yandex);
        addItem(gmail);
        addItem(other);
    }
}
