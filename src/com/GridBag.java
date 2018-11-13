package com;

import java.awt.*;

public class GridBag extends GridBagConstraints {


    public GridBag(int weightx, int weighty, int gridx, int gridy, int gridheight, int gridwidth) {

        this.weightx = weightx;
        this.weighty = weighty;
        this.gridx = gridx;
        this.gridy = gridy;
        this.gridheight = gridheight;
        this.gridwidth = gridwidth;
        super.insets = new Insets(1, 5, 1, 5);

    }

}
