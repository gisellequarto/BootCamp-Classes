package org.academia.com;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GameObjects {

    private Text letter;
    private Picture photo;
    Color letterColor = new Color(7, 115, 162);
    private static Rectangle pictureBorder = new Rectangle(420, 80, 370, 370);
    private Color colorPicBoarder = new Color(172, 0, 87);


    public GameObjects(Person person) {
        letter = new Text(125, 360, person.getLetter());
        photo = new Picture(440, 100, person.getPicturePath());
        letter.setColor(letterColor);
        letter.grow(80, 130);
        pictureBorder.setColor(colorPicBoarder);
    }

    public Text getLetter() {
        return letter;
    }

    public Picture getPhoto() {
        return photo;
    }

    public Rectangle getPictureBorder() {
        return pictureBorder;
    }
}
