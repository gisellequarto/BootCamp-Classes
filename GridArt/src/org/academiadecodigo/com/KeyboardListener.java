package org.academiadecodigo.com;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyboardListener implements KeyboardHandler {

    private Cursor cursor;
    private Grid grid;
    private int[]  keyCodes = {KeyboardEvent.KEY_UP, KeyboardEvent.KEY_DOWN, KeyboardEvent.KEY_LEFT, KeyboardEvent.KEY_RIGHT, KeyboardEvent.KEY_SPACE, KeyboardEvent.KEY_S, KeyboardEvent.KEY_L, KeyboardEvent.KEY_C};

    public KeyboardListener(Cursor cursor, Grid grid){
        Keyboard keyboard = new Keyboard(this);
        this.cursor = cursor;
        this.grid = grid;

        for(int keyCode : keyCodes) {
            subscribe(keyboard, keyCode);
        }
    }

    private void subscribe(Keyboard keyboard, int code) {
        KeyboardEvent event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        event.setKey(code);
        keyboard.addEventListener(event);
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
