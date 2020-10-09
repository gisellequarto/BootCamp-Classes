package org.academiadecodigo.com;

public class Barrel extends GameObject implements Destroyable{

    private BarrelType type;
    private int currentDamage;
    private boolean destroyed;

    public Barrel(){
        type = randomType();
    }

    @Override
    public void hit(int damage) {
        if (currentDamage + damage >= type.getMaxDamage()){
            destroy();
            return;
        }
        currentDamage += damage;
        System.out.println(this.getMessage() + (type.getMaxDamage() - currentDamage));

    }

    public void destroy() {
        destroyed = true;
    }

    @Override
    public boolean isDestroyed() {
        return destroyed;
    }

    private BarrelType randomType() {
        int randomType = ((int) (Math.random() * BarrelType.values().length));
            switch (randomType) {
                case 0:
                    return BarrelType.PLASTIC;
                case 1:
                    return BarrelType.WOOD;
                case 2:
                    return BarrelType.METAL;
            }
        return null;
    }


    @Override
    public String getMessage() {
        return type.toString() + " BARREL";
    }
}
