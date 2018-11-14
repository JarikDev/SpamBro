package com;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import javax.swing.filechooser.FileFilter;

import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;


public class Main {
    static JFrame jFrame = new Frame ().getFrame();
    static JPanel jPanel = new JPanel();
   // public static From from=new From();
    public static void main(String[] args) {

        jFrame.add(jPanel);
        GridBagLayout gridBagLayout = new GridBagLayout();
        jPanel.setLayout(gridBagLayout);
        //Letter title
        jPanel.add(new JLabel("Letter title: ",SwingConstants.LEFT), new GridBag (0,0,0,0,1,2)) ;
        //Letter title area
        LetterTitleArea lta=new LetterTitleArea();
        jPanel.add(new JScrollPane(lta,VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER), new GridBag (0,0,0,1,3,4)) ;
        //Message title
        jPanel.add(new JLabel("Message: ",SwingConstants.LEFT), new GridBag (0,0,0,4,1,2)) ;
        //Message area
        MyMessage myMessage=new MyMessage();
        jPanel.add(new JScrollPane(myMessage,VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER), new GridBag (0,0,0,5,7,4)) ;
        //Clear
        JButton clearMessage=new JButton("Clear ");
        clearMessage.addActionListener(e -> myMessage.setText("Put message here ... "));
        jPanel.add(clearMessage, new GridBag (0,0,0,12,1,1)) ;
        //Copy
        jPanel.add(new JButton("Copy " ), new GridBag (0,0,1,12,1,1)) ;
        //Paste
        jPanel.add(new JButton("Paste " ), new GridBag (0,0,2,12,1,1)) ;
        //Browse file
        JButton browseFileMes=new JButton("Browse file ... ");
        browseFileMes.addActionListener(new BrowseListener());
        jPanel.add(browseFileMes, new GridBag (0,0,3,12,1,1)) ;
        //Console message
        jPanel.add(new JLabel("Console message: ",SwingConstants.LEFT), new GridBag (0,0,0,13,1,2)) ;
        //Console field
        MyConsole myConsole=new MyConsole();
        jPanel.add(new JScrollPane(myConsole,VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER), new GridBag (0,0,0,14,5,4)) ;
        //Right side
        //To list
        jPanel.add(new JLabel("To list:",SwingConstants.LEFT), new GridBag (0,0,7,0,1,2)) ;
        //To list area
        ToList toList=new ToList();
        jPanel.add(new JScrollPane(toList,VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER), new GridBag (0,0,7,1,3,4)) ;
        //Browse file with to list
        JButton browseToList=new JButton("Browse to list file ... ");
        browseToList.addActionListener(new BrowseListener());
        jPanel.add(browseToList, new GridBag (0,0,7,4,1,2));
        //From
        jPanel.add(new JLabel("From: ",SwingConstants.LEFT), new GridBag (0,0,7,5,1,2)) ;

        //From field
         From from=new From();
        jPanel.add(new JScrollPane(from,VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER), new GridBag (0,0,7,6,2,4)) ;

        //Mail account password
        jPanel.add(new JLabel("Mail account password: ",SwingConstants.LEFT), new GridBag (0,0,7,8,1,2)) ;

        //Password field
        Password password=new Password();
        jPanel.add(new JScrollPane(password,VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER), new GridBag (0,0,7,9,1,4)) ;

        //Mail service label
        jPanel.add(new JLabel("Mail service: ",SwingConstants.LEFT), new GridBag (0,0,7,10,1,1)) ;
        //Mail service
        JComboBox<String> mailService=new MailService();
        jPanel.add(mailService, new GridBag (0,0,8,10,1,3));
         //Counter
        jPanel.add(new JLabel("Counter: ",SwingConstants.LEFT), new GridBag (0,0,7,11,1,2)) ;


        //Counter field
        Counter counter=new Counter();
        jPanel.add(new JScrollPane(counter,VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER), new GridBag (0,0,9,11,1,3)) ;


        //Clear all
        JButton clearAll=new JButton("Clear all ");
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
        jPanel.add(clearAll, new GridBag (0,0,7,12,1,1)) ;

        //Test
        JButton test=new JButton("Test ");
        test.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myConsole.setText(      "########## From ##########"+"\n"+from.getText()
                        +"\n"+"########## ToList ##########"+"\n"+toList.getText()
                        +"\n"+"########## Mail service ##########"+"\n"+mailService.getSelectedItem()
                        +"\n"+"########## Password ##########"+"\n"+password.getText()
                        +"\n"+"########## Counter ##########"+"\n"+counter.getText()
                        +"\n"+"########## LetterTitleArea ##########"+"\n"+lta.getText()
                        +"\n"+"########## Message ##########"+"\n"+myMessage.getText() );
            }
        });
        jPanel.add(test, new GridBag (0,0,7,13,1,1)) ;


        //Send
        JButton send=new JButton("SEND ");
        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              Sender sender=new   Sender();
                try {
                    sender.setFromS(from.getText().trim());
                    sender.setToS(toList.getText().trim());
                    sender.setMailServiceS(((String)mailService.getSelectedItem()).trim());
                    sender.setPasswordS(password.getText().trim());
                    sender.setCounterS(Integer.parseInt( counter.getText().trim()));
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
        jPanel.add(send, new GridBag (0,0,7,14,1,1))  ;
        //Exit
        JButton exit=new JButton("EXIT ");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        jPanel.add(exit, new GridBag (0,0,7,15,1,1)) ;



        jPanel.revalidate();
    }

}





























