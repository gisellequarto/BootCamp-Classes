package org.academiadecodigo.com;

public abstract class Enemy extends GameObject implements Destroyable{

    private int health;
    private boolean isDead;

    public Enemy (int health) {
        this.health = health;
    }


    @Override
    public String getMessage() {
        if(!isDead) {
        return this.getClass().getSimpleName() + "! I´ll kill you!";
        }
        return "I`m already dead!";
    }

    public boolean isDead() {
        return isDead;
    }

    public void kill(){
        isDead = true;
    }

    @Override
    public void hit (int damage){
        if(health <= damage){
            this.kill();
        }
        health -= damage;
    }

    @Override
    public boolean isDestroyed() {
        return isDead();
    }

}
