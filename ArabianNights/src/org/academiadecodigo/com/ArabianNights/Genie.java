package org.academiadecodigo.com.ArabianNights;

public class Genie {

    private int wishes;

    public Genie(int wishes) {
        this.wishes = wishes;
    }

    public void grantWish() {
        if (wishes <= 0) {
            System.out.println("No more wishes, my friend!");
            return;
        }
        System.out.println("Your wish is a order! TCHARAM!");
        wishes--;
    }



}
