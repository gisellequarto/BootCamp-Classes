package org.academiadecodigo.carcrash.field;

public class Position {

    private int column;
    private int row;

    public Position (int column, int row) {
        this.column = column;
        this.row = row;
    }

    public int getCol() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void move(int moveChoice, int carSpeed) {
        switch(moveChoice) {
            case (0):
                this.setColumn(getCol() + carSpeed);
                break;
            case (1):
                this.setColumn(getCol() - carSpeed);
                break;
            case (2):
                this.setRow(getRow() + carSpeed);
                break;
            case (3):
                this.setRow(getRow() - carSpeed);
                break;
        }
    }

    public boolean compare(Position other) {
        boolean sameCol = this.getCol() == other.getCol();
        boolean sameRow = this.getRow() == other.getRow();
        return sameCol && sameRow;
    }



}
