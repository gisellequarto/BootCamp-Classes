package org.academiadecodigo.carcrash.cars;

public enum CarType {

    SPORT("S", 5),
    OLD_CAR("O", 2);

    private String name;
    private int speed;

    CarType (String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public String toString() {
        return name;
    }

    public int getSpeed(){
        return speed;
    }

}
