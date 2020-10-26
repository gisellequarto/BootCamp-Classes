package org.academiadecodigo.com;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyboardListener implements KeyboardHandler {

    private Cursor cursor;
    private Grid grid;

    public KeyboardListener(Cursor cursor, Grid grid) {
        this.cursor = cursor;
        this.grid = grid;
    }


    @Override
    public void keyPressed(KeyboardEvent event) {
        switch (event.getKey()) {
            case KeyboardEvent.KEY_UP:
                cursor.translate(0, -20);
                break;
            case KeyboardEvent.KEY_DOWN:
                cursor.translate(0, 20);
                break;
            case KeyboardEvent.KEY_LEFT:
                cursor.translate(-20, 0);
                break;
            case KeyboardEvent.KEY_RIGHT:
                cursor.translate(20, 0);
                break;
            case KeyboardEvent.KEY_SPACE:
                cursor.paint();
                break;
            case KeyboardEvent.KEY_S:
                grid.saveRectanglesStatus();
                break;
            case KeyboardEvent.KEY_L:
                grid.loadSavedGrid();
                break;
            case KeyboardEvent.KEY_C:
                grid.clear();
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent event) {

    }
}
