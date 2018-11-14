package com;

import javax.swing.*;

public class Counter  extends JTextArea {
    public String getCounter() {
        return counter;
    }

    public void setCounter(String counter) {
        this.counter = counter;
    }

    String counter = "1";

    public Counter() {
        setColumns(10);
        setRows(1);
        setText(counter);
        setLineWrap(true);
    }
}