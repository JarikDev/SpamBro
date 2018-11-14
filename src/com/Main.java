package com;

import javax.mail.MessagingException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;


public class Main {

    static JFrame jFrame = new Frame ().getFrame();
    static JPanel panelOne = new JPanel();
    static JPanel panelTwo = new JPanel();


    public static void main(String[] args) throws IOException {

        jFrame.add(panelOne,BorderLayout.WEST);
        jFrame.add(panelTwo,BorderLayout.EAST);

        GridBagLayout gridBagLayout = new GridBagLayout();
        panelOne.setLayout(gridBagLayout);
        panelTwo.setLayout(gridBagLayout);
        panelOne.setBackground(Color.ORANGE);
        panelTwo.setBackground( Color.GREEN);

        //Console message
        panelOne.add(new JLabel("Console message: ",SwingConstants.LEFT), new GridBag (0,0,0,0,1,2)) ;

        //Console field
        MyConsole myConsole=new MyConsole();
        panelOne.add(new JScrollPane(myConsole,VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER), new GridBag (0,0,0,1,5,4)) ;

        //Letter title
        panelOne.add(new JLabel("Letter title: ",SwingConstants.LEFT), new GridBag (0,0,0,6,1,2)) ;
        //Letter title area
        LetterTitleArea lta=new LetterTitleArea();
        panelOne.add(new JScrollPane(lta,VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER), new GridBag (0,0,0,7,3,4)) ;
        //Message title
        panelOne.add(new JLabel("Message: ",SwingConstants.LEFT), new GridBag (0,0,0,10,1,2)) ;
        //Message area
        MyMessage myMessage=new MyMessage();
        panelOne.add(new JScrollPane(myMessage,VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER), new GridBag (0,0,0,11,7,4)) ;
        //Clear
        JButton clearMessage=new JButton("Clear ");
        clearMessage.addActionListener(e -> myMessage.setText("Put message here ... "));
        panelOne.add(clearMessage, new GridBag (0,0,0,18,1,1)) ;
        //Copy
        panelOne.add(new JButton("Copy " ), new GridBag (0,0,1,18,1,1)) ;
        //Paste
        panelOne.add(new JButton("Paste " ), new GridBag (0,0,2,18,1,1)) ;
        //Browse file
        JButton browseFileMes=new JButton("Browse file ... ");
        browseFileMes.addActionListener(new BrowseListener());
        panelOne.add(browseFileMes, new GridBag (0,0,3,18,1,1)) ;


        //Right side
        //To list
        panelTwo.add(new JLabel("To list:",SwingConstants.LEFT), new GridBag (0,0,0,0,1,2)) ;
        //To list area
        ToList toList=new ToList();
        panelTwo.add(new JScrollPane(toList,VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER), new GridBag (0,0,0,1,3,4)) ;
        //Browse file with to list
        JButton browseToList=new JButton("Browse to list file ... ");
        browseToList.addActionListener(new BrowseListener());
        panelTwo.add(browseToList, new GridBag (0,0,0,4,1,2));
        //From
        panelTwo.add(new JLabel("From: ",SwingConstants.LEFT), new GridBag (0,0,0,5,1,2)) ;
        //From field
         From from=new From();
        panelTwo.add(new JScrollPane(from,VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER), new GridBag (0,0,0,6,1,4)) ;
        //Mail account password
        panelTwo.add(new JLabel("Mail account password: ",SwingConstants.LEFT), new GridBag (0,0,0,7,1,2)) ;
        //Password field
        Password password=new Password();
        panelTwo.add(new JScrollPane(password,VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER), new GridBag (0,0,0,8,1,4)) ;
        //Mail service label
        panelTwo.add(new JLabel("Mail service: ",SwingConstants.LEFT), new GridBag (0,0,0,9,1,1)) ;
        //Mail service
        JComboBox<String> mailService=new MailService();
        panelTwo.add(mailService, new GridBag (0,0,1,9,1,2));
         //Counter
        panelTwo.add(new JLabel("Counter: ",SwingConstants.LEFT), new GridBag (0,0,0,10,1,1)) ;
        //Counter field
        Counter counter=new Counter();
        panelTwo.add(new JScrollPane(counter,VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER), new GridBag (0,0,1,10,1,1)) ;
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
        panelTwo.add(clearAll, new GridBag (0,0,0,11,1,1)) ;
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
        panelTwo.add(test, new GridBag (0,0,0,12,1,1)) ;
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
        panelTwo.add(send, new GridBag (0,0,0,13,1,1))  ;
        //Exit
        JButton exit=new JButton("EXIT ");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        panelTwo.add(exit, new GridBag (0,0,0,14,1,1)) ;

        panelOne.revalidate();
        panelTwo.revalidate();
    }
}





























