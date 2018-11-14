package com;

import javax.mail.MessagingException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;


public class Main {

    static JFrame jFrame = new Frame().getFrame();
    static JPanel panelOne = new JPanel();
    static JPanel panelTwo = new JPanel();
    static JPanel panelThree = new JPanel();
    static JPanel panelFour = new JPanel();
    static JPanel frameBack = new JPanel();


    public static void main(String[] args) throws IOException {
        jFrame.add(frameBack, BorderLayout.CENTER);
        jFrame.add(panelOne, BorderLayout.WEST);
        jFrame.add(panelTwo, BorderLayout.EAST);
        frameBack.setBackground(Color.ORANGE);
        panelOne.setLayout(new BoxLayout(panelOne, BoxLayout.Y_AXIS));
        panelTwo.setLayout(new BoxLayout(panelTwo, BoxLayout.Y_AXIS));

        panelOne.setBackground(Color.ORANGE);
        panelTwo.setBackground(Color.ORANGE);

        //Letter title
        panelOne.add(new JLabel("Letter title: ", SwingConstants.LEFT));
        //Letter title area
        LetterTitleArea lta = new LetterTitleArea();
        panelOne.add(new JScrollPane(lta, VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER));
        //Message title
        panelOne.add(new JLabel("Message: ", SwingConstants.LEFT));
        //Message area
        MyMessage myMessage = new MyMessage();
        panelOne.add(new JScrollPane(myMessage, VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER));
        //bottom roght panel
        panelOne.add(panelThree);
        panelThree.setBackground(Color.GREEN);
        panelThree.setLayout(new BoxLayout(panelThree, FlowLayout.LEFT));

        //Clear
        JButton clearMessage = new JButton("Clear ");
        clearMessage.addActionListener(e -> myMessage.setText("Put message here ... "));
        panelThree.add(clearMessage);
        //Copy
        panelThree.add(new JButton("Copy "));
        //Paste
        panelThree.add(new JButton("Paste "));
        //Browse file
        JButton browseFileMes = new JButton("Browse file ... ");
        browseFileMes.addActionListener(new BrowseListener());
        panelThree.add(browseFileMes);


        //Right side
        //To list
        panelTwo.add(new JLabel("To list:", SwingConstants.LEFT));
        //To list area
        ToList toList = new ToList();
        panelTwo.add(new JScrollPane(toList, VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER));
        //Browse file with to list
        JButton browseToList = new JButton("Browse to list file ... ");
        browseToList.addActionListener(new BrowseListener());
        panelTwo.add(browseToList);
        //From
        panelTwo.add(new JLabel("From: ", SwingConstants.LEFT));
        //From field
        From from = new From();
        panelTwo.add(new JScrollPane(from, VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER));
        //Mail account password
        panelTwo.add(new JLabel("Mail account password: ", SwingConstants.LEFT));
        //Password field
        Password password = new Password();
        panelTwo.add(new JScrollPane(password, VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER));
        //Mail service label
        panelTwo.add(new JLabel("Mail service: ", SwingConstants.LEFT));
        //Mail service
        JComboBox<String> mailService = new MailService();
        panelTwo.add(mailService);
        //Counter
        panelTwo.add(new JLabel("Counter: ", SwingConstants.LEFT));
        //Counter field
        Counter counter = new Counter();
        panelTwo.add(new JScrollPane(counter, VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER));

        //Console message
        JLabel label1 = new JLabel("Console message: ");
        panelTwo.add(label1, Component.CENTER_ALIGNMENT);

        //Console field
        MyConsole myConsole = new MyConsole();
        panelTwo.add(new JScrollPane(myConsole, VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER));

        //Bottom left panel
        panelTwo.add(panelFour);
        panelFour.setBackground(Color.ORANGE);
        panelFour.setLayout(new BoxLayout(panelFour, FlowLayout.LEFT));
        //Clear all
        JButton clearAll = new JButton("Clear all ");
        clearAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myMessage.setText("Put message here ... ");
                lta.setText("Put title here ... ");
                myConsole.setText("Console message here ... ");
                toList.setText("Recipients ... ");
                from.setText("From ... ");
                password.setText("Put password here ... ");
                counter.setText("1");
            }
        });
        panelFour.add(clearAll);
        //Test
        JButton test = new JButton("Test ");
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
        JButton send = new JButton("SEND ");
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
        JButton exit = new JButton("EXIT ");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        panelFour.add(exit);

        panelOne.revalidate();
        panelTwo.revalidate();
        panelThree.revalidate();
        panelFour.revalidate();
        frameBack.revalidate();
    }
}





























