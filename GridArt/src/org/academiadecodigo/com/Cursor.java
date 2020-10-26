package org.academiadecodigo.com;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cursor {

    private Rectangle cursor;
    private Grid grid;

    public Cursor(Grid grid) {
        this.grid = grid;
        cursor = new Rectangle(grid.PADDING, grid.PADDING, grid.CELL_SIZE, grid.CELL_SIZE);
        cursor.setColor(Color.YELLOW);
        cursor.fill();
    }

    public void translate(int x, int y) {
        int posX = cursor.getX() + x;
        int posY = cursor.getY() + y;

        if (posX >= grid.WIDTH) {
            if (x < 0) {
                cursor.translate(x, y);
            }
            return;
        }
        if(posY >= grid.HEIGHT) {
            if (y < 0) {
                cursor.translate(x, y);
            }
            return;
        }
        if (posX < grid.PADDING) {
            if (x > 0) {
                cursor.translate(x, y);
            }
            return;
        }
        if (posY < grid.PADDING){
            if (y > 0) {
                cursor.translate(x, y);
            }
            return;
        }
        cursor.translate(x, y);
    }


    public int getX() {
        return cursor.getX();
    }

    public int getY() {
        return cursor.getY();
    }

   public void paint() {
        grid.changeRectangle(getX(), getY());
   }


}
