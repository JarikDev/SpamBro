package com;

import javax.swing.*;

public class MyMessage extends JTextArea {
    public String getMyMessage() {
        return myMessage;
    }

    public void setMyMessage(String message) {
        this.myMessage = message;
    }

    String myMessage = "Message...";

    public MyMessage() {
        setColumns(30);
        setRows(20);
        setText(myMessage);
        setLineWrap(true);
    }
}