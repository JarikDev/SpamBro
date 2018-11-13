package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;


public class Main {
    static JFrame jFrame = getFrame();
    static JPanel jPanel = new JPanel();

    public static void main(String[] args) {
        jFrame.add(jPanel);
        GridBagLayout gridBagLayout = new GridBagLayout();
        jPanel.setLayout(gridBagLayout);
        //Letter title
        jPanel.add(new JLabel("Letter title: ",SwingConstants.LEFT), new GridBag (0,0,0,0,1,2)) ;
        //Letter title area
        JTextArea title=new JTextArea("Put title here ... ",3, 30);
        title.setLineWrap(true);
        jPanel.add(new JScrollPane(title,VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER), new GridBag (0,0,0,1,3,4)) ;
        //Message title
        jPanel.add(new JLabel("Message: ",SwingConstants.LEFT), new GridBag (0,0,0,4,1,2)) ;
        //Message area
        JTextArea message=new JTextArea("Put message here ... ",20, 30);
        message.setLineWrap(true);
        jPanel.add(new JScrollPane(message,VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER), new GridBag (0,0,0,5,7,4)) ;
        //Clear
        JButton clearMessage=new JButton("Clear ");
        clearMessage.addActionListener(e -> message.setText("Put message here ... "));
        jPanel.add(clearMessage, new GridBag (0,0,0,12,1,1)) ;
        //Copy
        jPanel.add(new JButton("Copy " ), new GridBag (0,0,1,12,1,1)) ;
        //Paste
        jPanel.add(new JButton("Paste " ), new GridBag (0,0,2,12,1,1)) ;
        //Browse file
        jPanel.add(new JButton("Browse file " ), new GridBag (0,0,3,12,1,1)) ;
        //Error message
        jPanel.add(new JLabel("Error message: ",SwingConstants.LEFT), new GridBag (0,0,0,13,1,2)) ;
        //Error field
        JTextArea errorField=new JTextArea("Error message here ... ",10, 30);
        errorField.setLineWrap(true);
        jPanel.add(new JScrollPane(errorField,VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER), new GridBag (0,0,0,14,5,4)) ;
        //Right side
        //To list
        jPanel.add(new JLabel("To list:",SwingConstants.LEFT), new GridBag (0,0,7,0,1,2)) ;
        //To list area
        JTextArea toList=new JTextArea("Recipients ... ",3, 30);
        toList.setLineWrap(true);
        jPanel.add(new JScrollPane(toList,VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER), new GridBag (0,0,7,1,3,4)) ;
        //Browse file with toi list
        jPanel.add(new JButton("Browse file " ), new GridBag (0,0,7,4,1,2));
        //From
        jPanel.add(new JLabel("From: ",SwingConstants.LEFT), new GridBag (0,0,7,5,1,2)) ;
        //From field
        JTextArea fromField=new JTextArea("From ... ",3, 30);
        fromField.setLineWrap(true);
        jPanel.add(new JScrollPane(fromField,VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER), new GridBag (0,0,7,6,2,4)) ;
        //Mail account password
        jPanel.add(new JLabel("Mail account password: ",SwingConstants.LEFT), new GridBag (0,0,7,8,1,2)) ;
        //Password field
        JTextArea passField=new JTextArea("Put password here ... ",3, 30);
        passField.setLineWrap(true);
        jPanel.add(new JScrollPane(passField,VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER), new GridBag (0,0,7,9,1,4)) ;
        //Counter
        jPanel.add(new JLabel("Counter: ",SwingConstants.LEFT), new GridBag (0,0,7,10,1,2)) ;
        //Counter field
        JTextArea counterField=new JTextArea("999",1, 10);
        counterField.setLineWrap(true);
        jPanel.add(new JScrollPane(counterField,VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER), new GridBag (0,0,9,10,1,3)) ;

        //Clear all
        JButton clearAll=new JButton("Clear all ");
        clearAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                message.setText("Put message here ... ");
                title.setText("Put title here ... ");
                errorField.setText("Error message here ... ");
                toList.setText("Recipients ... ");
                fromField.setText("From ... ");
                passField.setText("Put password here ... ");
                counterField.setText("999");
            }
        });
        jPanel.add(clearAll, new GridBag (0,0,7,11,2,1)) ;
        //Send
        jPanel.add(new JButton("SEND " ), new GridBag (0,0,8,11,2,1))  ;
        //Exit
        JButton exit=new JButton("EXIT ");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        jPanel.add(exit, new GridBag (0,0,10,11,2,1)) ;

        jPanel.revalidate();
    }
    static JFrame getFrame() {
        JFrame jFrame = new JFrame() {};
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame.setBounds(dimension.width / 2 - 700, dimension.height / 2 - 300, 800, 700);
        jFrame.setTitle("SpamBro");
        jFrame.setResizable(false);
        return jFrame;

    }
}





























