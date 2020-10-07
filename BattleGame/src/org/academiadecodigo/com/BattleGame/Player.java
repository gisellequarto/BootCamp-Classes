package org.academiadecodigo.com.BattleGame;

public class Player {

    private String name;
    private Fighter[] fighters;

    public Player (String name, Fighter[] fighters) {
        this.name = name;
        this.fighters = fighters;
    }

    public void attack (Player opponent) {
        int attackWay = BattleRandomizer.numberRandom(2);
        if (attackWay == 0) {
            this.chooseFighter().hit(opponent.chooseFighter());
            return;
        }
        this.chooseFighter().cast(opponent.chooseFighter());
    }


    public boolean lost(){
        for(Fighter fighter : fighters) {
            if (fighter.isDead() == false) {
                return false;
            }
        }
        return true;
    }

    public String getName() {
       return name;
    }

    private Fighter chooseFighter () {
        int chosen = BattleRandomizer.numberRandom(5);
        while (fighters[chosen].isDead() == true) {
                chosen = BattleRandomizer.numberRandom(5);
        }
        return fighters[chosen];
    }

}
