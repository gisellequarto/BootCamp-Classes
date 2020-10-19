package org.academiadecodigo.com;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Obstacle {

    private String[] obstaclesPathPics = {"assets/boat.png", "assets/mountain.png", "assets/tower.png", "assets/plane.png"};
    private final int OBSTACLE_SPEED = 10;
    private boolean showing;

    private Picture pic;

    public Obstacle() {

    }

    public void setPic(int x, int y, int i) {
        pic = new Picture(x, y, obstaclesPathPics[i]);
    }


   /* private String getProbability() {
        int randomObstacle = ((int) (Math.random() * 4));
        if (randomObstacle < 2) {
            return boat;
        } else if (randomObstacle == 2) {
            return mountain;
        }
        return tower;
    }*/

    public Picture getPic() {
        return pic;
    }


    public void move() {
        try {
            moving();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void moving() throws InterruptedException {
        while (pic.getY() < 700) {
            Thread.sleep(200);
            pic.translate(0, OBSTACLE_SPEED);
        }
        pic.delete();
        pic.translate(0, -700);
        this.setShowing(false);
    }

    public boolean isShowing() {
        return showing;
    }

    public void setShowing(boolean showing) {
        this.showing = showing;
    }
}
