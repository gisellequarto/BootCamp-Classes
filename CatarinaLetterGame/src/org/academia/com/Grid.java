package org.academia.com;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Grid {

    private static final int PADDING = 10;
    private static final int WIDTH = 801;
    private static final int HEIGHT = 601;
    private Rectangle border;
    private Picture background;
    private String backgroundPath = "assets/background.jpg";
    private static Rectangle pictureBorder = new Rectangle(400, 250, 140, 200);
    private Color colorPicBoarder = new Color(21, 63, 74);

    public Grid() {
        border = new Rectangle(PADDING, PADDING, WIDTH, HEIGHT);
        border.draw();
        background = new Picture(PADDING + 1, PADDING + 1, backgroundPath);
        background.draw();
        pictureBorder.setColor(colorPicBoarder);
        pictureBorder.fill();
    }

}
