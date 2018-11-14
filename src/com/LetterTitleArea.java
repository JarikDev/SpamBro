package com;

import javax.swing.*;

public class LetterTitleArea extends JTextArea {
    public String getLetterTitleArea() {
        return letterTitleArea;
    }

    public void setLetterTitleArea(String letterTitleArea) {
        this.letterTitleArea = letterTitleArea;
    }

    String letterTitleArea = "Put title here ... ";

    public LetterTitleArea() {
        setColumns(30);
        setRows(3);
        setText(letterTitleArea);
        setLineWrap(true);
    }
}
