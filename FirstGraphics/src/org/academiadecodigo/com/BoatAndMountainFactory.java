package org.academiadecodigo.com;

public class BoatAndMountainFactory {



    public static void createBoats() {
        new Things(getXRandom(), getYRandom());
    }




    private static int getXRandom () {
        return ((int) (Math.random() * 400));
    }

    private static int getYRandom() {
        return ((int) (Math.random() * 801));
    }




}
