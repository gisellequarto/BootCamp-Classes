package org.academiadecodigo.com;


import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.util.LinkedList;
import java.util.List;

public class MenuGrid {


    public static final int PADDING = Grid.WIDTH + 20;
    public static final int CELL_SIZE = 20;
    public static final Color[] colors = {Color.RED, Color.GREEN, Color.CYAN, Color.BLUE, Color.PINK, Color.MAGENTA, Color.YELLOW, Color.ORANGE, Color.LIGHT_GRAY, Color.GRAY, Color.DARK_GRAY, Color.BLACK};
    List<Rectangle> coloredRectangles;
    private Rectangle actualColorBorder;
    private Rectangle actualColor;


    public MenuGrid() {
        createActualColor();
        coloredRectangles = new LinkedList<>();
        createColoredRectangles();
    }

    private void createColoredRectangles() {
        int y = 40;
        for (Color c : colors) {
            Rectangle rec = new Rectangle(PADDING + 3, y, CELL_SIZE, CELL_SIZE);
            rec.setColor(c);
            rec.fill();
            coloredRectangles.add(rec);
            y += (CELL_SIZE + 3);
        }
    }

    public void getRectangleColor(double x, double y) {
        for (Rectangle r : coloredRectangles) {
            if ((x >= r.getX() && x <= (r.getWidth() + r.getX())) && (y - 28 >= r.getY() && y - 28 <= (r.getHeight() + r.getY()))) {
                actualColor.setColor(r.getColor());
                actualColor.fill();
            }
        }
    }

    private void createActualColor() {
        actualColorBorder = new Rectangle(PADDING - 1, 10, CELL_SIZE + 5, CELL_SIZE + 5);
        actualColorBorder.draw();
        actualColor = new Rectangle(PADDING + 2, 13, CELL_SIZE, CELL_SIZE);
        actualColor.setColor(Color.BLUE);
        actualColor.fill();
    }

    public Color getActualColor() {
        return actualColor.getColor();
    }


    /* I tryed to show and COLLAPSE this Menu Grid (not yet!! soon)
    private void showMenuGrid() {
        for (Rectangle r : coloredRectangles) {
            r.fill();
        }
        isShowing = true;
    }

    private void hideMenuGrid() {
        for (Rectangle r : coloredRectangles) {
            r.delete();
        }
        isShowing = false;
    }

    public void MenuShowOrHide() {
        if (isShowing) {
            hideMenuGrid();
            return;
        }
        showMenuGrid();
    }
*/


}
