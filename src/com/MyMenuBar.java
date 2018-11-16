package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class MyMenuBar extends JMenuBar {
    public JMenuBar getMyMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        //Menu bar
        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        JMenu view = new JMenu("View");
        JMenu help = new JMenu("Help");

        JMenuItem newSession = file.add(new JMenuItem("New", 'n'));
        JMenuItem openSession = file.add(new JMenuItem("Open session", 'o'));
        JMenuItem saveSession = file.add(new JMenuItem("Save session", 'S'));
        JMenuItem openToList = file.add(new JMenuItem("Open To list"));
        JMenuItem saveToList = file.add(new JMenuItem("Save To list", 'l'));
        JMenuItem settings = file.add(new JMenuItem("Settings", 'g'));
        JMenuItem exit = file.add(new JMenuItem("Exit", 'x'));

        JMenuItem mailServerSettings = edit.add(new JMenuItem("Mail server settings", 'm'));
        JMenuItem setFrom = edit.add(new JMenuItem("Set from", 'f'));
        JMenuItem setPW = edit.add(new JMenuItem("Set password", 'w'));
        JMenuItem test = edit.add(new JMenuItem("Test", 't'));
        JMenuItem openConsole = edit.add(new JMenuItem("Open console", 'c'));
        JMenuItem clearAll = edit.add(new JMenuItem("Clear all"));


        JMenuItem simpleMode = view.add(new JMenuItem("Simple mode", 'i'));
        JMenuItem proMode = view.add(new JMenuItem("Pro mode", 'p'));

        JMenuItem faq = help.add(new JMenuItem("F.A.Q", 'q'));
        JMenuItem about = help.add(new JMenuItem("About", 'a'));
        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new About();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        JComboBox<String> mailService = new JComboBox<String>();

        file.add(newSession);
        file.addSeparator();
        file.add(openSession);
        file.add(saveSession);
        file.addSeparator();
        file.add(openToList);
        file.add(saveToList);
        file.addSeparator();
        file.add(settings);
        settings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

              new  MailSettingsDialog();





                    /*try {
                        JOptionPane jop=new JOptionPane();

                        String firstNumber = JOptionPane.showInputDialog("Enter first number");
                        String secondNumber = JOptionPane.showInputDialog("Enter second number");
                        int answer = Integer.parseInt(firstNumber) + Integer.parseInt(secondNumber);
                        jop.add(  );
                        JOptionPane.showMessageDialog(null, firstNumber + " + " + secondNumber + " = " + answer);
                        int confirm = JOptionPane.showOptionDialog(null, "You want to start again?", "Again?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                    *//*
                     0 = yes
                     1 = no
                     *//*
                        if (confirm != 1) {
                            //addButton.doClick();
                        } else {
                            //no
                        }
                    } catch (Exception ex) {

                    }*/
                }
            } );




        file.addSeparator();
        file.add(exit);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        exit.setAccelerator(KeyStroke.getKeyStroke("ctrl E"));
        newSession.setAccelerator(KeyStroke.getKeyStroke("ctrl N"));

        edit.add(mailServerSettings);
        edit.add(setFrom);
        edit.add(setPW);
        edit.addSeparator();
        edit.add(openConsole);
        edit.addSeparator();
        edit.add(test);
        edit.addSeparator();
        edit.add(clearAll);

        view.add(simpleMode);
        view.add(proMode);

        view.add(faq);
        view.addSeparator();
        view.add(about);

        help.add(faq);
        help.addSeparator();
        help.add(about);

        mailService.addItem("@mail.ru");
        mailService.addItem("@yandex.ru");
        mailService.addItem("@gmail.com");
        mailService.addItem("Unsupported shit");

        edit.add(mailService);

        menuBar.add(file);
        menuBar.add(edit);
        menuBar.add(view);
        menuBar.add(help);

        return menuBar;
    }
}
/*
     public static void main(String[] args) {
        JFrame frame = getFrame();
        JMenuBar jMenuBar = new MyMenuBar().getMyMenuBar();

        frame.setJMenuBar(jMenuBar);
    }


    static JFrame getFrame() {
        JFrame jFrame = new JFrame() {};
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame.setBounds(dimension.width / 2 - 250, dimension.height / 2 - 150, 500, 500);
        return jFrame;
    }
}

  *//*
    public  MyMenuBar(
            JMenu file,
    JMenu edit,
    JMenu view,
    JMenu help,

    JMenuItem newSession,
    JMenuItem openSession,
    JMenuItem saveSession,
    JMenuItem openToList,
    JMenuItem saveToList,
    JMenuItem exit,

    JMenuItem mailServerSettings,
    JMenuItem setFrom,
    JMenuItem setPW,
    JMenuItem test,
    JMenuItem openConsole,
    JMenuItem clearAll ,

    JMenuItem simpleMode,
    JMenuItem proMode,

    JMenuItem faq,
    JMenuItem about,

    JComboBox<String> mailService
    ) {

        this.file=file;
        this.edit=file;
        this.view=view;
                this.help=help;

                this.newSession=newSession;
                this.openSession=openSession;
                this.saveSession=saveSession;
                this.openToList=openToList;
                this.saveToList=saveToList;
                this.exit=exit;

                this.mailServerSettings=mailServerSettings;
                this.setFrom=setFrom;
                this.setPW=setPW;
                this.test=test;
                this.openConsole=openConsole;
                this.clearAll =clearAll;

                this.simpleMode=simpleMode;
                this.proMode=proMode;

                this.faq=faq;
                this.about=about;

                this.mailService=mailService;*/
