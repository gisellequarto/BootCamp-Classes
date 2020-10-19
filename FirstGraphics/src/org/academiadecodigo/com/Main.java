package org.academiadecodigo.com;


public class Main {

    public static void main(String[] args) throws InterruptedException {

        BoatAndMountainFactory factory = new BoatAndMountainFactory();
        int counter = 0;


        while (counter < 10) {
            factory.drawObstacles();
            counter++;
        }


    }
}
