package com;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    public JFrame getFrame() throws HeadlessException {
        JFrame jFrame = new JFrame() {};
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame.setBounds(dimension.width / 2 - 700, dimension.height / 2 - 300, 700, 700);
        jFrame.setTitle("SpamBro");
        jFrame.setBackground(Color.BLACK);
       jFrame.setResizable(false);
        return  jFrame;
    }
}
