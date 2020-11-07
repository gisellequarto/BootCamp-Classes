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
    private GameObjects [] objects;

    public Grid() {
        border = new Rectangle(PADDING, PADDING, WIDTH, HEIGHT);
        border.draw();
        background = new Picture(PADDING + 1, PADDING + 1, backgroundPath);
        background.draw();
        objects = new GameObjects[]{new GameObjects(Person.BEBETO),
                                    new GameObjects(Person.CARLA),
                                    new GameObjects(Person.CATARINA),
                                    new GameObjects(Person.DANIEL),
                                    new GameObjects(Person.GISELLE),
                                    new GameObjects(Person.JOAO),
                                    new GameObjects(Person.LEONARDO),
                                    new GameObjects(Person.MAITE),
                                    new GameObjects(Person.MAY),
                                    new GameObjects(Person.MEL),
                                    new GameObjects(Person.RICARDO),
                                    new GameObjects(Person.RODRIGO),
                                    new GameObjects(Person.ROGERIO),
                                    new GameObjects(Person.VANIA)};
    }

    public void show(int index) {
        cleanObjects();
        objects[index].getLetter().draw();
        objects[index].getPictureBorder().fill();
        objects[index].getPhoto().draw();

    }

    public void cleanObjects() {
        for (GameObjects g : objects) {
            g.getLetter().delete();
            g.getPhoto().delete();
            g.getPictureBorder().delete();
        }

    }




}
