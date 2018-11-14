package com;

import javax.swing.*;

public class Password extends JTextArea {
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    String password = "Password...";

    public Password() {
        setColumns(30);
        setRows(1);
        setText(password);
        setLineWrap(true);
    }
}