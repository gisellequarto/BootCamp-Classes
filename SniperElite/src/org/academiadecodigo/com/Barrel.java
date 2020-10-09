package org.academiadecodigo.com;

public class Barrel extends GameObject implements Destroyable{

    private BarrelType type;
    private int currentDamage;
    private boolean destroyed;

    public Barrel() {
        randomType();
    }

    @Override
    public void hit(int damage) {
        if (currentDamage + damage >= type.getMaxDamage()){
            destroy();
            return;
        }
        currentDamage += damage;

    }

    public void destroy() {
        destroyed = true;
    }

    @Override
    public boolean isDestroyed() {
        return destroyed;
    }

    private BarrelType randomType() {
        type = BarrelType.values()[((int) (Math.random() * BarrelType.values().length))];
        return type;
    }


    @Override
    public String getMessage() {
        return type.toString() + " BARREL";
    }
}
