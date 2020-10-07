package org.academiadecodigo.com;

public class Player {

    private String name;
    private int[] allAttempts = new int [10];
    private int counter = 0;

    public Player (String name) {
        this.name = name;
    }

    public boolean isValidAttempt (int guess ) {
        boolean check = false;
        for (int a : allAttempts) {
            if (a == guess) {
                check = false;
                break;
            } else {
                check = true;
                continue;
            }
        }
        return check;
    }


    public void addToAttempts(int num){
        allAttempts[counter] = num;
        ++counter;
    }

    public int chooseANumber(int max) {
        int guess = NumberRandom.chooseANumber(max);

        if (!(isValidAttempt(guess))) {
            return 111;
        }

        addToAttempts(guess);
        return guess;
    }


    public String getName(){
        return name;
    }

}
