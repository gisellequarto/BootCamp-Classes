package org.academia.com;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;

public class Grid {

    private static final int PADDING = 10;
    private static final int WIDTH = 801;
    private static final int HEIGHT = 501;
    private Rectangle border;
    private Picture background;
    private String backgroundPath = "assets/background.jpg";

    public Grid() {
        border = new Rectangle(PADDING, PADDING, WIDTH, HEIGHT);
        border.draw();
        background = new Picture(PADDING + 1, PADDING + 1, backgroundPath);
        background.draw();
    }


}
