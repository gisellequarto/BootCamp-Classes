package org.academiadecodigo.com;

public class ArmouredEnemy extends Enemy{

    private int armourResistance;

    public ArmouredEnemy() {
        super(50);
        armourResistance = 30;
    }

    @Override
    public void hit(int damage) {
        if(armourResistance >= damage) {
            armourResistance -= damage;
            return;
        } else if(armourResistance < damage && armourResistance > 0) {
            int otherBullets = damage - armourResistance;
            super.hit(otherBullets);
            return;
        }
        super.hit(damage);
    }


}
