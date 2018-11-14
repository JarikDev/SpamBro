package test1;

import java.awt.*;

public class Grid  extends GridLayout {

    public Grid() {
    }

    public Grid(int rows, int cols) {

        super(rows, cols);
    }

    public Grid(int rows, int cols, int hgap, int vgap) {
        super(rows, cols, hgap, vgap);
    }
}
