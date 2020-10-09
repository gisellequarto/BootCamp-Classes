package org.academiadecodigo.com;

public enum BarrelType {

    PLASTIC(20),
    WOOD(30),
    METAL(40);

    BarrelType(int maxDamage){
        this.maxDamage = maxDamage;
    }

    private final int maxDamage;

    public int getMaxDamage() {
        return maxDamage;
    }

}
