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
        setColumns(23);
        setRows(27);
        setText(myMessage);
        setLineWrap(true);
    }
}