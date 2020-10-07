package org.academiadecodigo.com.BattleGame;

public class Troll extends Fighter{

    public Troll(String name) {
        super(name);
        setFighterValues(2, 2, 10);
    }


    @Override
    public void hit(Fighter opponent) {
        int trollWay = BattleRandomizer.numberRandom(2);
        if (trollWay == 0) {
            super.hit(opponent);
            return;
        }
        System.out.println("Troll is sleeping");
    }




}
