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
    private Person[] types;

    public GameObjects (Person[] types) {
        this.types = types;
        letter = new Text(125, 360, types[0].getLetter());
        int random = ((int) Math.random() * types.length);
        photo = new Picture(440, 100, types[random].getPicturePath());
        showRandom();
    }


    public void showRandom() {
        letter.grow(80, 130);
        letter.setColor(letterColor);
        letter.draw();
        pictureBorder.setColor(colorPicBoarder);
        pictureBorder.fill();
        photo.draw();
    }


}
