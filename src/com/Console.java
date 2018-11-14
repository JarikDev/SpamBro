package com;

import javax.swing.*;

public class Console extends JTextArea {
    public String getConsoleMessage() {
        return consoleMessage;
    }

    public void setConsoleMessage(String consoleMessage) {
        this.consoleMessage = consoleMessage;
    }

    String consoleMessage = "Put title here ... ";

    public Console() {
        setColumns(30);
        setRows(10);
        setText(consoleMessage);
        setLineWrap(true);
    }
}