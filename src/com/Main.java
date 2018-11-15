package com;

import javax.mail.MessagingException;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;


public class Main {

    static JFrame jFrame = new Frame().getFrame();
    static JPanel panelOne = new JPanel();
    static JPanel panelTwo = new JPanel();
    static JPanel panelThree = new JPanel();
    static JPanel panelFour = new JPanel();
    static JPanel frameBack = new JPanel();


    public static void main(String[] args) throws IOException, ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException, InterruptedException {

        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        jFrame.add(frameBack, BorderLayout.CENTER);
        jFrame.add(panelOne, BorderLayout.WEST);
        jFrame.add(panelTwo, BorderLayout.EAST);
        Color color = new Color(67, 70, 75);
        frameBack.setBackground(color);
        panelOne.setLayout(new BoxLayout(panelOne, BoxLayout.Y_AXIS));
        panelTwo.setLayout(new BoxLayout(panelTwo, BoxLayout.Y_AXIS));
        panelOne.setBackground(color);
        panelTwo.setBackground(color);

        //Font
        Font font = new Font("Verdana", Font.BOLD, 14);
        Font font2 = new Font("Verdana", Font.PLAIN, 14);

        //Letter title

        JLabel letterTitleLabel = new JLabel("Letter title:");
        letterTitleLabel.setFont(font);
        letterTitleLabel.setForeground(Color.WHITE);
        letterTitleLabel.setHorizontalTextPosition(JLabel.LEFT);
        panelOne.add(letterTitleLabel);
        //Letter title area
        LetterTitleArea lta = new LetterTitleArea();
        lta.setFont(font2);
        panelOne.add(new JScrollPane(lta, VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER));
        //Message title
        JLabel messageTitleLabel = new JLabel("Message:");
        messageTitleLabel.setFont(font);
        messageTitleLabel.setForeground(Color.WHITE);
        panelOne.add(messageTitleLabel);
        //Message area
        MyMessage myMessage = new MyMessage();
        myMessage.setFont(font2);
        panelOne.add(new JScrollPane(myMessage, VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER));
        //bottom right panel
        panelOne.add(panelThree);
        panelThree.setBackground(color);
        panelThree.setLayout(new FlowLayout());

        //Clear
        JButton clearMessage = new JButton("Clear");
        clearMessage.addActionListener(e -> myMessage.setText("Message..."));
        panelThree.add(clearMessage);
        //Paste
        panelThree.add(new JButton("Paste"));

        //Save
        JButton save = new JButton("Save");
        panelThree.add(save);

        //Browse file
        JButton browseFileMes = new JButton("Open...");
        browseFileMes.addActionListener(new BrowseListener());
        panelThree.add(browseFileMes);

        //Right side
        //To list
        JLabel toListLabel = new JLabel("To list:");
        toListLabel.setFont(font);
        toListLabel.setForeground(Color.WHITE);
        panelTwo.add(toListLabel);
        //To list area
        ToList toList = new ToList();
        toList.setFont(font2);
        panelTwo.add(new JScrollPane(toList, VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER));
        //Browse file with to list
        JButton browseToList = new JButton("Open...");
        browseToList.addActionListener(new BrowseListener());
        panelTwo.add(browseToList);
        //From
        JLabel fromLabel = new JLabel("From:");
        fromLabel.setFont(font);
        fromLabel.setForeground(Color.WHITE);
        panelTwo.add(fromLabel);
        //From field
        From from = new From();
        from.setFont(font2);
        panelTwo.add(new JScrollPane(from, VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER));
        //Mail account password
        JLabel passwordLabel = new JLabel("Mail account password:");
        passwordLabel.setFont(font);
        passwordLabel.setForeground(Color.WHITE);
        panelTwo.add(passwordLabel);
        //Password field
        Password password = new Password();
        password.setFont(font2);
        panelTwo.add(new JScrollPane(password, VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER));
        //Mail service label
        JLabel mailServiceLabel = new JLabel("Mail service:");
        mailServiceLabel.setFont(font);
        mailServiceLabel.setForeground(Color.WHITE);
        panelTwo.add(mailServiceLabel);
        //Mail service
        JComboBox<String> mailService = new MailService();
        mailService.setFont(font2);
        panelTwo.add(mailService);
        //Counter
        JLabel counterLabel = new JLabel("Counter:");
        counterLabel.setFont(font);
        counterLabel.setForeground(Color.WHITE);
        panelTwo.add(counterLabel);
        //Counter field
        Counter counter = new Counter();
        counter.setFont(font2);
        panelTwo.add(new JScrollPane(counter, VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER));
        //Console title
        JLabel consoleLabel = new JLabel("Console message:");
        consoleLabel.setFont(font);
        consoleLabel.setForeground(Color.WHITE);
        panelTwo.add(consoleLabel, Component.CENTER_ALIGNMENT);
        //Console field
        MyConsole myConsole = new MyConsole();
        myConsole.setFont(font2);
        panelTwo.add(new JScrollPane(myConsole, VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER));
        //Bottom left panel
        panelTwo.add(panelFour);
        panelFour.setBackground(color);
        // panelFour.setLayout(new BoxLayout(panelFour, FlowLayout.LEFT));
        panelFour.setLayout(new FlowLayout());
        //Clear all
        JButton clearAll = new JButton("Clear all");
        clearAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myMessage.setText("Message...");
                lta.setText("Title...");
                myConsole.setText("Console...");
                toList.setText("Recipients...");
                from.setText("From...");
                password.setText("Password...");
                counter.setText("1");
            }
        });
        panelFour.add(clearAll);
        //Test
        JButton test = new JButton("Test");
        test.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myConsole.setText("########## From ##########" + "\n" + from.getText()
                        + "\n" + "########## ToList ##########" + "\n" + toList.getText()
                        + "\n" + "########## Mail service ##########" + "\n" + mailService.getSelectedItem()
                        + "\n" + "########## Password ##########" + "\n" + password.getText()
                        + "\n" + "########## Counter ##########" + "\n" + counter.getText()
                        + "\n" + "########## LetterTitleArea ##########" + "\n" + lta.getText()
                        + "\n" + "########## Message ##########" + "\n" + myMessage.getText());
            }
        });
        panelFour.add(test);
        //Send
        JButton send = new JButton("SEND");
        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sender sender = new Sender();
                try {
                    sender.setFromS(from.getText().trim());
                    sender.setToS(toList.getText().trim());
                    sender.setMailServiceS(((String) mailService.getSelectedItem()).trim());
                    sender.setPasswordS(password.getText().trim());
                    sender.setCounterS(Integer.parseInt(counter.getText().trim()));
                    sender.setTitleS(lta.getText().trim());
                    sender.setMessageS(myMessage.getText().trim());
                    sender.send();
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (MessagingException e1) {
                    e1.printStackTrace();
                }
            }
        });
        panelFour.add(send);
        //Exit
        JButton exit = new JButton("EXIT");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        panelFour.add(exit);

        //Save logic
        BrowseSaveListener browseSaveListener = new BrowseSaveListener();


        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                browseSaveListener.setFromS(from.getText().trim());
                browseSaveListener.setToS(toList.getText().trim());
                browseSaveListener.setMailServiceS(((String) mailService.getSelectedItem()).trim());
                browseSaveListener.setPasswordS(password.getText().trim());
                browseSaveListener.setCounterS(Integer.parseInt(counter.getText().trim()));
                browseSaveListener.setTitleS(lta.getText().trim());
                browseSaveListener.setMessageS(myMessage.getText().trim());
                JFileChooser jFileChooser = new JFileChooser();
                jFileChooser.showSaveDialog(panelOne);
                jFileChooser.setCurrentDirectory(new File("D:\\"));
                jFileChooser.setDialogTitle("Save current session");
                browseSaveListener.savedFileTitle = jFileChooser.getSelectedFile().getName();
                browseSaveListener.savingPath = jFileChooser.getSelectedFile().getName();
                FileFilter fileFilter=new FileNameExtensionFilter("txt files only","txt");
                jFileChooser.setFileFilter(fileFilter);

                if( jFileChooser.showSaveDialog(jFrame)== jFileChooser.APPROVE_OPTION ){
                try {
                    browseSaveListener.saveToFile();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }

            }
        });


        //Revalidate
        panelOne.revalidate();
        panelTwo.revalidate();
        panelThree.revalidate();
        panelFour.revalidate();
        frameBack.revalidate();
    }
}





























