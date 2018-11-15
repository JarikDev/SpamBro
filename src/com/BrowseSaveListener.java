package com;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static com.Main.panelOne;

public class BrowseSaveListener {

    String titleS;
    String messageS;
    String toS;
    String fromS;
    String passwordS;
    int counterS;
    String mailServiceS;
    String myConsoleS;
    String fileNamS;
    String savedFileTitle;
    String savingPath;

    public String getSavingPath() {
        return savingPath;
    }

    public void setSavingPath(String savingPath) {
        this.savingPath = savingPath;
    }

    public String getTitleS() {
        return titleS;
    }

    public void setTitleS(String titleS) {
        this.titleS = titleS;
    }

    public String getMessageS() {
        return messageS;
    }

    public void setMessageS(String messageS) {
        this.messageS = messageS;
    }

    public String getToS() {
        return toS;
    }

    public void setToS(String toS) {
        this.toS = toS;
    }

    public String getFromS() {
        return fromS;
    }

    public void setFromS(String fromS) {
        this.fromS = fromS;
    }

    public String getPasswordS() {
        return passwordS;
    }

    public void setPasswordS(String passwordS) {
        this.passwordS = passwordS;
    }

    public int getCounterS() {
        return counterS;
    }

    public void setCounterS(int counterS) {
        this.counterS = counterS;
    }

    public String getMailServiceS() {
        return mailServiceS;
    }

    public void setMailServiceS(String mailServiceS) {
        this.mailServiceS = mailServiceS;
    }

    public String getMyConsoleS() {
        return myConsoleS;
    }

    public void setMyConsoleS(String myConsoleS) {
        this.myConsoleS = myConsoleS;
    }

    public String getFileNamS() {
        return fileNamS;
    }

    public void setFileNamS(String fileNamS) {
        this.fileNamS = fileNamS;
    }

    public String getSavedFileTitle() {
        return savedFileTitle;
    }

    public void setSavedFileTitle(String fileNamS) {
        this.savedFileTitle = savedFileTitle;
    }

    public BrowseSaveListener() throws IOException {
    }

    public BrowseSaveListener(String titleS, String messageS, String toS, String fromS, String passwordS, int counterS, String mailServiceS, String myConsoleS, String fileNamS, String savedFileTitle) throws IOException {
        this.titleS = titleS;
        this.messageS = messageS;
        this.toS = toS;
        this.fromS = fromS;
        this.passwordS = passwordS;
        this.counterS = counterS;
        this.mailServiceS = mailServiceS;
        this.myConsoleS = myConsoleS;
        this.fileNamS = fileNamS;
        this.savedFileTitle = savedFileTitle;
    }

    public void saveToFile() throws IOException {
        BufferedWriter writer = null;
        writer = new BufferedWriter(new FileWriter(savedFileTitle + ".txt"));
        writer.write("########## From ##########" + "\n" + fromS);
        writer.newLine();
        writer.write("########## ToList ##########" + "\n" + toS);
        writer.newLine();
        writer.write("########## Mail service ##########" + "\n" + mailServiceS);
        writer.newLine();
        writer.write("########## Password ##########" + "\n" + passwordS);
        writer.newLine();
        writer.write("########## Counter ##########" + "\n" + counterS);
        writer.newLine();
        writer.write("########## LetterTitleArea ##########" + "\n" + titleS);
        writer.newLine();
        writer.write("########## Message ##########" + "\n" + messageS);
        writer.newLine();
        writer.write("########## Console ##########" + "\n" + myConsoleS);
        writer.newLine();
        writer.flush();
        writer.close();
    }
}

