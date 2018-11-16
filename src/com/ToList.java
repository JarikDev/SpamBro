package com;

import javax.swing.*;

public class ToList extends JTextArea {
    public String getToList() {
        return toList;
    }

    public void setToList(String toList) {
        this.toList = toList;
    }

    String toList = "Recipients...";

    public ToList() {
        setColumns(20);
        setRows(3);
        setText(toList);
        setLineWrap(true);
    }
}