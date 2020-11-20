package org.academiadecodigo.lambdas;

public class Oven {

    private int initialTemperature;

    public int getInitialTemperature() {
        return initialTemperature;
    }

    public void setInitialTemperature(int initialTemperature) {
        this.initialTemperature = initialTemperature;
    }


    public String toString(int counter) {
        return "Oven " + counter +
                " {initialTemperature=" + initialTemperature +
                '}';
    }

}
