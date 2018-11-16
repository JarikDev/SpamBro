package com;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class About {
   final Image img = ImageIO.read(new File("pr.jpg"));

    public About() throws IOException {
        JFrame aboutFrame = new JFrame() {
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
        aboutFrame.setVisible(true);
        aboutFrame.setTitle("About this program");
        aboutFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        aboutFrame.setBounds(dimension.width / 2 - 250, dimension.height / 2 - 150,404, dimension.height / 2 - 150);
        aboutFrame.setResizable(false);
        JPanel aboutPanel=new JPanel();
        aboutFrame.add(aboutPanel,BorderLayout.CENTER);
        Color color = new Color(67, 70, 75);
        Font font = new Font("Verdana", Font.BOLD, 14);
        Font font2 = new Font("Verdana", Font.PLAIN, 14);
        aboutPanel.setBackground(color);

        JTextArea aboutTextArea=new JTextArea("about");
        JLabel aboutLabel1=new JLabel("This is one of my first applications.");
        aboutLabel1.setForeground(Color.WHITE);
        aboutLabel1.setFont(font);
        JLabel aboutLabel2=new JLabel("It can perform spam attacks onto enemy @Email addresses.");
        aboutLabel2.setForeground(Color.WHITE);
        aboutLabel2.setFont(font);
        JLabel aboutLabel3=new JLabel("Hopes you enjoy it <^,,,,^>");
        aboutLabel3.setForeground(Color.WHITE);
        aboutLabel3.setFont(font);

        aboutPanel.setLayout(new BoxLayout(aboutPanel,BoxLayout.Y_AXIS));
        aboutPanel.add(aboutLabel1);
        aboutPanel.add(aboutLabel2);
        aboutPanel.add(aboutLabel3);




        aboutPanel.add(new JComponent() {
                public void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(img, 0, 0, null);
                }
            });

        }
    }

