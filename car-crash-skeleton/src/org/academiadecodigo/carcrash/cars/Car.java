package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.carcrash.field.Position;

abstract  public class Car {

    /**
     * The position of the car on the grid
     */
    private Position pos;
    private CarType carType;
    private boolean crashed;

    public Car (CarType carType) {
        this.carType = carType;
    }

    public Position getPos() {
         return pos;
    }


    public String toString() {
        return isCrashed() ? "C" : carType.toString();
    }

    public void setCrashed() {
       crashed = true;
    }
    public boolean isCrashed() {
        return crashed;
    }


    public int getSpeed() {
        return this.carType.getSpeed();
    }

    public Position setInitial() {
        pos = new Position(((int) (Math.random() * 100)), ((int) (Math.random() * 25)));
        return pos;
    }

    public Position move () {
        boolean canGoRight = pos.getCol() <= (99 - getSpeed());
        boolean canGoLeft = pos.getCol() >= (0 + getSpeed());
        boolean canGoDown = pos.getRow() <= (24 - getSpeed());
        boolean canGoUp = pos.getRow() >= (0 + getSpeed());

        if (this.isCrashed()) {
            return pos;
        }

        int moveChoice = ((int) (Math.random() * 4));

            if (!canGoRight && moveChoice == 0) {
                moveChoice = ((int) (Math.random() * 4));
            } else if (!canGoLeft && moveChoice == 1) {
                moveChoice = ((int) (Math.random() * 4));
            } else if (!canGoDown && moveChoice == 2) {
                moveChoice = ((int) (Math.random() * 4));
            } else if (!canGoUp && moveChoice == 3) {
                moveChoice = ((int) (Math.random() * 4));
            }

        pos.move(moveChoice, getSpeed());
        return pos;
    }

    public boolean comparePos(Car other){
        return pos.compare(other.getPos());
    }

}