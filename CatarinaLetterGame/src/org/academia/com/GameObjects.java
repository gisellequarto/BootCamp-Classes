package org.academia.com;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.Map;

public class GameObjects {

    private Text letter;
    private Picture photo;
    Color letterColor = new Color(7, 115, 162);
    private static Rectangle pictureBorder = new Rectangle(420, 80, 370, 370);
    private Color colorPicBoarder = new Color(172, 0, 87);
    private GameObjects[] objects = {new GameObjects(Person.CARLA), new GameObjects(Person.DANIEL), new GameObjects(Person.JOAO), new GameObjects(Person.MAY), new GameObjects(Person.VANIA)};

    public GameObjects(Person person) {
        letter = new Text(125, 360, person.getLetter());
        photo = new Picture(440, 100, person.getPicturePath());
        letter.setColor(letterColor);
        letter.grow(80, 130);
        pictureBorder.setColor(colorPicBoarder);
    }


    public void show() {
        cleanObjects();
        letter.draw();
        pictureBorder.fill();
        photo.draw();

    }

    public void cleanElements() {
        photo.delete();
        letter.delete();
    }

    public void cleanObjects() {
        for (GameObjects g : objects) {
            g.cleanElements();
        }

    }


    public void command (int index){
        objects[index].show();
    }

}
