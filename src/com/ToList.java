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
        setColumns(30);
        setRows(5);
        setText(toList);
        setLineWrap(true);
    }
}