package com;

import javax.swing.*;
import java.awt.*;
import java.awt.SplashScreen;

import static javax.swing.SwingUtilities.paintComponent;

public class MySplashScreen {
    public void getMySplashScreen() throws InterruptedException {
        SplashScreen splash = SplashScreen.getSplashScreen();
        Rectangle rec = splash.getBounds();
        Graphics2D g2 = splash.createGraphics();
       // Color color = new Color(67, 70, 75);
        Color color = new Color(98, 178, 227);

        g2.setColor(color);

        for (int i =  0; i <  100; i++) {
            g2.fillRect(0, 0, rec.width * i / 100, 321);
            splash.update();
            try {
                Thread.sleep(10 );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

       /* SplashScreen splashScreen = SplashScreen.getSplashScreen();
        final Image img = new ImageIcon(splashScreen.getImageURL()).getImage();
        final JFrame splashFrame = new JFrame();
        final JPanel splashPanel = new JPanel();
        splashPanel.add(new JComponent() {
            public void paintComponent(Graphics g) {
                g.drawImage(img, 0, 0, null);
            }
        });

        final JProgressBar progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        Color color = new Color(67, 70, 75);
        progressBar.setBackground(color);
        Color color2 = new Color(179, 78, 233);
        progressBar.setForeground(color2);
        Font font = new Font("Verdana", Font.BOLD, 14);
        progressBar.setFont(font);

        splashPanel.setLayout(new BorderLayout());
        splashPanel.add(progressBar, BorderLayout.NORTH);
        splashFrame.add(splashPanel);
        splashFrame.setBounds(splashScreen.getBounds());
        splashFrame.setVisible(true);

        try {
            for (int i = 0; i <= 100; i++) {
                progressBar.setString("Loading module..." + i);
                progressBar.setValue(i);
                splashPanel.repaint();
                Thread.sleep(20);

            }
        } catch (InterruptedException ex) {
        }
        splashFrame.setVisible(false);*/


    }
}
