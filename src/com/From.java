package com;

import javax.swing.*;

public class From extends JTextArea {
    public static String getFrom() {
        return from;
    }

    public static void setFrom(String from) {
         from = from;
    }

   static String from="From ... ";

    public From() {
        setColumns(30);
        setRows(3);
        setText(from);
        setLineWrap(true);
    }
}