package org.academiadecodigo.com.BattleGame;

public class Fighter {

    private String name;
    private int attackDamage;
    private int spellDamage;
    private int health;

    public Fighter (String name) {
        this.name = name;
        setFighterValues(2, 4, 10);
    }

    public void hit(Fighter opponent){
        System.out.println(this.getName() + " HIT and causes " + this.attackDamage + " damages in " + opponent.getName());
        opponent.suffer(this.attackDamage);
    }

    public void cast (Fighter opponent){
        System.out.println(this.getName() + " CAST and causes " + this.spellDamage + " damages in " + opponent.getName());
        opponent.suffer(this.spellDamage);
    }

    public void suffer(int attack) {
        health -= attack;
    }

    public boolean isDead() {
        return health <= 0;
    }

    public String getName() {
        return (name + "(" + this.health + ")");
    }

    public void setFighterValues (int attackDamage, int spellDamage, int health) {
        this.attackDamage = attackDamage;
        this.spellDamage = spellDamage;
        this.health = health;
    }


}
