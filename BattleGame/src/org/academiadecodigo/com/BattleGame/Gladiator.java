package org.academiadecodigo.com.BattleGame;

public class Gladiator extends Fighter{

    public Gladiator(String name) {
        super(name);
        setFighterValues(4, 1, 10);
    }

    @Override
    public void hit(Fighter opponent) {
        int gladiatorWay = BattleRandomizer.numberRandom(4);
        if (gladiatorWay == 0) {
            super.hit(opponent);
            super.hit(opponent);
            return;
        }
        super.hit(opponent);
    }




}
