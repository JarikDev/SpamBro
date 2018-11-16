package com;

import com.sun.org.apache.bcel.internal.generic.ALOAD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;

public class MailSettingsDialog  {

    public MailSettingsDialog() {
        JFrame mailSettingsFrame = new JFrame() {
        };
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        mailSettingsFrame.setVisible(true);
        mailSettingsFrame.setTitle("Mail server settings");
        mailSettingsFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        mailSettingsFrame.setBounds(dimension.width / 2 - 250, dimension.height / 2 - 150,dimension.width / 2 - 400, dimension.height / 2 - 150);
        mailSettingsFrame.setResizable(false);
        JPanel mailSettingsPanelLeft=new JPanel();
        JPanel mailSettingsPanelRight=new JPanel();

        mailSettingsFrame.add(mailSettingsPanelLeft,BorderLayout.WEST);
        mailSettingsFrame.add(mailSettingsPanelRight,BorderLayout.EAST);

        Color color = new Color(67, 70, 75);
        Font font = new Font("Verdana", Font.BOLD, 14);
        Font font2 = new Font("Verdana", Font.PLAIN, 14);
        mailSettingsPanelLeft.setBackground(color);
        mailSettingsPanelLeft.setLayout(new BoxLayout(mailSettingsPanelLeft, BoxLayout.Y_AXIS ));
        mailSettingsPanelRight.setBackground(color);
        mailSettingsPanelRight.setLayout(new BoxLayout(mailSettingsPanelRight, BoxLayout.Y_AXIS ));

        JPanel panel1L=new JPanel();panel1L.setBackground(color);
        JPanel panel2L=new JPanel();panel2L.setBackground(color);
        JPanel panel3L=new JPanel();panel3L.setBackground(color);
        JPanel panel4L=new JPanel();panel4L.setBackground(color);
        JPanel panel5L=new JPanel();panel5L.setBackground(color);
        JPanel panel6L=new JPanel();panel6L.setBackground(color);
        JPanel panel7L=new JPanel();panel7L.setBackground(color);
        JPanel panel8L=new JPanel();panel8L.setBackground(color);

        JPanel panel1R=new JPanel();panel1R.setBackground(color);
        JPanel panel2R=new JPanel();panel2R.setBackground(color);
        JPanel panel3R=new JPanel();panel3R.setBackground(color);
        JPanel panel4R=new JPanel();panel4R.setBackground(color);
        JPanel panel5R=new JPanel();panel5R.setBackground(color);
        JPanel panel6R=new JPanel();panel6R.setBackground(color);
        JPanel panel7R=new JPanel();panel7R.setBackground(color);
        JPanel panel8R=new JPanel();panel8R.setBackground(color);

        mailSettingsPanelLeft.add(panel1L);
        mailSettingsPanelLeft.add(panel2L);
        mailSettingsPanelLeft.add(panel3L);
        mailSettingsPanelLeft.add(panel4L);
        mailSettingsPanelLeft.add(panel5L);
        mailSettingsPanelLeft.add(panel6L);
        mailSettingsPanelLeft.add(panel7L);


        mailSettingsPanelRight.add(panel1R);
        mailSettingsPanelRight.add(panel2R);
        mailSettingsPanelRight.add(panel3R);
        mailSettingsPanelRight.add(panel4R);
        mailSettingsPanelRight.add(panel5R);
        mailSettingsPanelRight.add(panel6R);
        mailSettingsPanelRight.add(panel7R);
      /*

        panel1L.setLayout(new FlowLayout( ));
        panel2L.setLayout(new FlowLayout( ));
        panel3L.setLayout(new FlowLayout( ));
        panel4L.setLayout(new FlowLayout( ));
        panel5L.setLayout(new FlowLayout( ));
        panel6L.setLayout(new FlowLayout( ));
        panel7L.setLayout(new FlowLayout( ));
        panel8L.setLayout(new FlowLayout( ));
*/
        JLabel label1=new JLabel("mail.transport.protocol=") ;
        label1.setForeground(Color.WHITE);
        label1.setFont(font);
        panel1L.add(label1,BorderLayout.WEST);
        JLabel label2=new JLabel("mail.smpt.auth=") ;
        label2.setForeground(Color.WHITE);
        label2.setFont(font);
        panel2L.add(label2,BorderLayout.WEST);
        JLabel label3=new JLabel("mail.smtps.host=") ;
        label3.setFont(font);
        label3.setForeground(Color.WHITE);
        panel3L.add(label3,BorderLayout.WEST);
        JLabel label4=new JLabel("mail.smtps.user=") ;
        label4.setFont(font);
        label4.setForeground(Color.WHITE);
        panel4L.add(label4,BorderLayout.WEST);
        JLabel label5=new JLabel("@Email address:") ;
        label5.setFont(font);
        label5.setForeground(Color.WHITE);
        panel5L.add(label5,BorderLayout.WEST);
        JLabel label6=new JLabel("@Email account password") ;
        label6.setForeground(Color.WHITE);
        label6.setFont(font);
        panel6L.add(label6,BorderLayout.WEST);
        JLabel label7=new JLabel("@Email service") ;
        label7.setForeground(Color.WHITE);
        label7.setFont(font);
        panel7L.add(label7,BorderLayout.WEST);

        JTextArea settingsTextArea1=new JTextArea(1,29);
        settingsTextArea1.setLineWrap(true);
        panel1R.add(new JScrollPane(settingsTextArea1, VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER));
        JTextArea settingsTextArea2=new JTextArea(1,29);
        settingsTextArea2.setLineWrap(true);
        panel2R.add(new JScrollPane(settingsTextArea2, VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER));
        JTextArea settingsTextArea3=new JTextArea(1,29);
        settingsTextArea3.setLineWrap(true);
        panel3R.add(new JScrollPane(settingsTextArea3, VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER));
        JTextArea settingsTextArea4=new JTextArea(1,29);
        settingsTextArea4.setLineWrap(true);
        panel4R.add(new JScrollPane(settingsTextArea4, VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER));
        JTextArea settingsTextArea5=new JTextArea(1,29);
        settingsTextArea5.setLineWrap(true);
        panel5R.add(new JScrollPane(settingsTextArea5, VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER));
        JTextArea settingsTextArea6=new JTextArea(1,29);
        settingsTextArea6.setLineWrap(true);
        panel6R.add(new JScrollPane(settingsTextArea6, VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER));
        panel7R.add(new MailService());

        JButton save=new JButton("Save");
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        panel8R.add(save,BorderLayout.EAST);
        JButton cancel=new JButton("Cancel");
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mailSettingsFrame.dispose();
            }
        });
        panel8R.add(cancel,BorderLayout.EAST);


        mailSettingsFrame.add(panel8R,BorderLayout.SOUTH);

    }
}
