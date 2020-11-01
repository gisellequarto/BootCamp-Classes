package org.academiadecodigo.com;

public class CodeCadet {

    public void buyBeer (int beer) {
        Fridge.getInstance().fillFridge(beer);
    }

}
