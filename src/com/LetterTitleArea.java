package com;

import javax.swing.*;

public class LetterTitleArea extends JTextArea {
    public String getLetterTitleArea() {
        return letterTitleArea;
    }

    public void setLetterTitleArea(String letterTitleArea) {
        this.letterTitleArea = letterTitleArea;
    }

    String letterTitleArea = "Title...";

    public LetterTitleArea() {
        setColumns(30);
        setRows(1);
        setText(letterTitleArea);
        setLineWrap(true);
    }
}
