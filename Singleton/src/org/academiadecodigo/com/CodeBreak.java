package org.academiadecodigo.com;

public class CodeBreak {

    public static void main(String[] args) {

        CodeCadet erick = new CodeCadet();
        CodeCadet eloise = new CodeCadet();

        erick.buyBeer(10);
        eloise.buyBeer(15);

        //Even if you try
        Fridge smallFridge = Fridge.getInstance();
        Fridge otherFridge = Fridge.getInstance();

        System.out.println(Fridge.getInstance().getBeerQuantity()); // 25

    }
}
