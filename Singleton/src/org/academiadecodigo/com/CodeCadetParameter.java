package org.academiadecodigo.com;

public class CodeCadetParameter {

    //With Singleton you don't need to pass Fridge as parameter here
    public void buyBeer (Fridge fridge, int beer) {
        fridge.fillFridge(beer);
    }

}
