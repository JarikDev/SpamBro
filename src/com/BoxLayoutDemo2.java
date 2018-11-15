package com;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BoxLayoutDemo2 implements ItemListener {
    protected static int NUM_COMPONENTS = 3;
    protected static float[] xAlignment = {
            Component.LEFT_ALIGNMENT,
            Component.CENTER_ALIGNMENT,
            Component.RIGHT_ALIGNMENT};
    protected static float[] hue = {0.0f, 0.33f, 0.67f};
    protected static boolean restrictSize = true;
    protected static boolean sizeIsRandom = false;
    protected static BLDComponent[] bldComponent =
            new BLDComponent[NUM_COMPONENTS];

    public void populateContentPane(Container contentPane) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        //Create the rectangles.
        int shortSideSize = 15;
        for (int i = 0; i < NUM_COMPONENTS; i++) {
            if (sizeIsRandom) {
                shortSideSize = (int)(30.0 * Math.random()) + 30;
            } else {
                shortSideSize += 10;
            }
            bldComponent[i] = new BLDComponent(xAlignment[i], hue[i],
                    shortSideSize,
                    restrictSize,
                    sizeIsRandom,
                    String.valueOf(i));
            panel.add(bldComponent[i]);
        }

        //Create the instructions.
        JLabel label = new JLabel("Click a rectangle to "
                + "change its X alignment.");
        JCheckBox cb = new JCheckBox("Restrict maximum rectangle size.");
        cb.setSelected(restrictSize);
        cb.addItemListener(this);

        panel.setBorder(BorderFactory.createLineBorder(Color.red));

        Box box = Box.createVerticalBox();
        box.add(label);
        box.add(cb);

        contentPane.add(panel, BorderLayout.CENTER);
        contentPane.add(box, BorderLayout.PAGE_END);
    }

    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            restrictSize = true;
        } else {
            restrictSize = false;
        }
        notifyBLDComponents();
    }

    static public void notifyBLDComponents() {
        for (int i = 0; i < NUM_COMPONENTS; i++) {
            bldComponent[i].setSizeRestriction(restrictSize);
        }
        bldComponent[0].revalidate();
    }

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("BoxLayoutDemo2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        BoxLayoutDemo2 demo = new BoxLayoutDemo2();
        demo.populateContentPane(frame.getContentPane());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}


/* A rectangle that has a fixed size. */
class BLDComponent extends JComponent {
    private Color normalHue;
    private final Dimension preferredSize;
    private String name;
    private boolean restrictMaximumSize;
    private boolean printSize;

    public BLDComponent(float alignmentX, float hue,
                        int shortSideSize,
                        boolean restrictSize,
                        boolean printSize,
                        String name) {
        this.name = name;
        this.restrictMaximumSize = restrictSize;
        this.printSize = printSize;
        setAlignmentX(alignmentX);
        normalHue = Color.getHSBColor(hue, 0.4f, 0.85f);
        preferredSize = new Dimension(shortSideSize*2, shortSideSize);

        MouseListener l = new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                Dimension size = getSize();
                float alignment = (float)(e.getX())
                        / (float)size.width;

                // Round to the nearest 1/10th.
                int tmp = Math.round(alignment * 10.0f);
                alignment = (float)tmp / 10.0f;

                setAlignmentX(alignment);
                repaint();
                revalidate(); // this GUI needs relayout
            }
        };
        addMouseListener(l);
    }


    public boolean isOpaque() {
        return true;
    }

    public void paint(Graphics g) {
        Dimension size = getSize();
        float alignmentX = getAlignmentX();

        g.setColor(normalHue);
        g.fill3DRect(0, 0, size.width, size.height, true);

        /* Draw a vertical white line at the alignment point.*/
        // XXX: This code is probably not the best.
        g.setColor(Color.white);
        int x = (int)(alignmentX * (float)size.width) - 1;
        g.drawLine(x, 0, x, size.height - 1);

        /* Say what the alignment point is. */
        g.setColor(Color.black);
        g.drawString(Float.toString(alignmentX), 3, size.height - 3);

        if (printSize) {
            System.out.println("BLDComponent " + name + ": size is "
                    + size.width + "x" + size.height
                    + "; preferred size is "
                    + getPreferredSize().width + "x"
                    + getPreferredSize().height);
        }
    }

    public Dimension getPreferredSize() {
        return preferredSize;
    }

    public Dimension getMinimumSize() {
        return preferredSize;
    }

    public Dimension getMaximumSize() {
        if (restrictMaximumSize) {
            return preferredSize;
        } else {
            return super.getMaximumSize();
        }
    }

    public void setSizeRestriction(boolean restrictSize) {
        restrictMaximumSize = restrictSize;
    }

}