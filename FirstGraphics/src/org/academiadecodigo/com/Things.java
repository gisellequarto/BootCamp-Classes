package org.academiadecodigo.com;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Things {

    private String boat = "assets/boat.png";
    private String mountain = "assets/mountain.png";
    private String tower = "assets/tower.png";


    Picture pic;

    public Things(int x, int y) {
        pic = new Picture(x, y, getProbability());
        pic.draw();
    }

    private String getProbability() {
        int randomObstacle = ((int) (Math.random() * 4));
        if (randomObstacle < 2) {
            return boat;
        } else if (randomObstacle == 2) {
            return mountain;
        }
        return tower;
    }


}
