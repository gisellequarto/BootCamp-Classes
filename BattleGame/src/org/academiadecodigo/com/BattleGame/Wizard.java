package org.academiadecodigo.com.BattleGame;

public class Wizard extends Fighter{

    private boolean shield;

    public Wizard(String name) {
        super(name);
        setFighterValues(2, 4,10);
    }

    @Override
    public void cast(Fighter opponent) {
       int wizardWay = BattleRandomizer.numberRandom(4);
       if (wizardWay == 0) {
           shield = true;
           System.out.println("The wizard " + this.getName() + " is protected!");
           return;
       }
       super.cast(opponent);
    }

    @Override
    public void suffer(int attack) {
        if (shield) {
            shield = false;
            return;
        }
        super.suffer(attack);
    }


}

