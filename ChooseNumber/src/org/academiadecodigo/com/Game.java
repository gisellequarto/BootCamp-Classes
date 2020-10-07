package org.academiadecodigo.com;

public class Game {

    public void start (Player[] players){
        int mysteriousNumber = NumberRandom.chooseANumber(10);
        boolean check = false;

        while (!check) {
            for (Player p : players){
               int guess = p.chooseANumber(10);

               while (guess == 111) {
                   guess = p.chooseANumber(10);
               }

                if (guess == mysteriousNumber) {
                    System.out.println(p.getName() + " is the winner! He said " + guess + "\nAnd the number was " +  mysteriousNumber);
                    check = true;
                    break;
                } else {
                    System.out.println(p.getName() + " said " + guess + ". WRONG!!");
                }
            }
        }
    }



}
