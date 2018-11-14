package com;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import static com.Main.jPanel;

public class BrowseListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.showOpenDialog(jPanel);
        jFileChooser.setCurrentDirectory(new File("D:\\"));
        jFileChooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                if (f.getName().endsWith(".txt")) {
                    return true;
                }
                return false;
            }
            @Override
            public String getDescription() {
                return "txt files only";
            }
        });
    }
}
