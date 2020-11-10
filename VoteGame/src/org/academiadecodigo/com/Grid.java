package org.academiadecodigo.com;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Grid {

    Rectangle grid = new Rectangle(0, 0, 800, 600);
    Picture background = new Picture(0, 0, "assets/background.png");

    public Grid() {
        grid.setColor(Color.DARK_GRAY);
        grid.fill();
        background.draw();
    }


}
