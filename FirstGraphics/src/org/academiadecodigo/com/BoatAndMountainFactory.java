package org.academiadecodigo.com;

public class BoatAndMountainFactory {

    private Obstacle[] obstacles = {new Obstacle(), new Obstacle(), new Obstacle(), new Obstacle(), new Obstacle(),
                                     new Obstacle(), new Obstacle(), new Obstacle(), new Obstacle(), new Obstacle(),
                                    new Obstacle(), new Obstacle(), new Obstacle(), new Obstacle(), new Obstacle()};


    private static int[] initialPosition = {20, 350, 680, 900};


    public void drawObstacles() {
        int obstacleType = ((int) (Math.random() * 4));
        for (Obstacle o : obstacles) {
            if (!o.isShowing()) {
                o.setPic(getXRandom(), 0, obstacleType);
                o.getPic().draw();
                o.setShowing(true);
                o.move();
                return;
            }
        }
    }


    private int getObstacleRandom() {
        return ((int) (Math.random() * obstacles.length));
    }

    private int getXRandom() {
        return initialPosition[((int) (Math.random() * initialPosition.length))];
    }

/*    private static int getYRandom() {
        return ((int) (Math.random() * 801));
    }
*/


}
