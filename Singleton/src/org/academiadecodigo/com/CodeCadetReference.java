package org.academiadecodigo.com;

public class CodeCadetReference {

    //You can try with Reference
    private final Fridge fridge;

    public CodeCadetReference(Fridge fridge) {
        this.fridge = fridge;
    }

    public void buyBeer(int beer) {
        fridge.fillFridge(beer);
    }
}



