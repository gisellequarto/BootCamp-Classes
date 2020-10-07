package org.academiadecodigo.com.paperrock;

public class Player {

    private String name;
    private int victory;

    public Player(String name) {
        this.name = name;
    }

    public HandType showHand() {
        int hand = (int) (Math.random()*HandType.values().length);

        System.out.println(name + " - " + HandType.values()[hand]);

        return HandType.values()[hand];
    }





    public void addVictory() {
        this.victory++;
        System.out.println(this.getName() + " has " + this.getVictory() + " victories\n\n");
    }

    public int getVictory(){
        return this.victory;
    }

    public String getName(){
        return this.name;
    }


}
