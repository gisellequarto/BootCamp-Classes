package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.carcrash.field.Position;

public class CarFactory {


    public static Car getNewCar() {
        int randomCar = ((int) (Math.random() * 2));

        if (randomCar == 0) {
            Car car = new SportCar();
            car.setInitial();
            return car;
        }
        Car car = new OldCar();
        car.setInitial();
        return car;
    }


}