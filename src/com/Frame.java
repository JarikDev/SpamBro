package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Frame extends JFrame {
    public JFrame getFrame()   {

        try {
            new MySplashScreen().getMySplashScreen();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        JFrame jFrame = new JFrame() {};
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame.setBounds(dimension.width / 2 - 700, dimension.height / 2 - 300, 650, 700);
        jFrame.setTitle("SpamBro");
        jFrame.setBackground(Color.BLACK);
        jFrame.setResizable(false);



/*

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
        JMenuItem exit = file.add(new JMenuItem("Exit", 'x'));

        JMenuItem mailServerSettings = file.add(new JMenuItem("Mail server settings", 'm'));
        JMenuItem setFrom = file.add(new JMenuItem("Set from", 'f'));
        JMenuItem setPW = file.add(new JMenuItem("Set password", 'w'));
        JMenuItem test = file.add(new JMenuItem("Test", 't'));
        JMenuItem openConsole = file.add(new JMenuItem("Open console", 'c'));
        JMenuItem clearAll = file.add(new JMenuItem("Clear all"));


        JMenuItem simpleMode = file.add(new JMenuItem("Simple mode", 'i'));
        JMenuItem proMode = file.add(new JMenuItem("Pro mode", 'p'));

        JMenuItem faq = file.add(new JMenuItem("F.A.Q", 'q'));
        JMenuItem about = file.add(new JMenuItem("Exit", 'a'));

        JComboBox<String> mailService = new JComboBox<String>();

        file.add(newSession);
        file.addSeparator();
        file.add(openSession);
        file.add(saveSession);
        file.addSeparator();
        file.add(openToList);
        file.add(saveToList);
        file.addSeparator();
        file.add(exit);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        exit.setAccelerator(KeyStroke.getKeyStroke("ctrl E"));
        newSession.setAccelerator(KeyStroke.getKeyStroke("ctrl E"));

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
        help.add(about);

        mailService.addItem("@mail.ru");
        mailService.addItem("@yandex.ru");
        mailService.addItem("@gmail.com");
        mailService.addItem("Unsupported shit");

        edit.add(mailService);

        JMenuBar menuBar=new JMenuBar();
        menuBar.add(file );
        menuBar.add( edit );
        menuBar.add( view );
        menuBar.add( help);


        jFrame.setJMenuBar(menuBar);

        //End of menu bar


*/


        JMenuBar menuBar=new MyMenuBar().getMyMenuBar();

        jFrame.setJMenuBar(menuBar);

        return jFrame;
    }
}
