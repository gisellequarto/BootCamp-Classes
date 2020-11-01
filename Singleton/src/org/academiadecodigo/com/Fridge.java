package org.academiadecodigo.com;

public class Fridge {

    private static final Fridge fridge = new Fridge();
    private int beerQuantity;

    private Fridge() {
    }

    public static Fridge getInstance() {
        return fridge;
    }

    public void fillFridge(int beer) {
        beerQuantity += beer;
    }

    public int getBeerQuantity() {
        return beerQuantity;
    }
}

