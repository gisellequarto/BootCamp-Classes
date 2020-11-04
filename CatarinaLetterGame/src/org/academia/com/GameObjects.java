package org.academia.com;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GameObjects {

    private Text letter;
    private Picture photo;
    Color letterColor = new Color(133, 78, 67);

    public GameObjects (Person person) {
        letter = new Text(110, 110, person.getLetter());
        photo = new Picture(600, 80, person.getPicturePath());
    }


    public void showRandom() {
        letter.grow(80, 130);
        letter.setColor(letterColor);
        letter.draw();
        photo.draw();
    }

}
