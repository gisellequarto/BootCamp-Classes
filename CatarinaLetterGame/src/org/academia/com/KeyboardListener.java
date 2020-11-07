package org.academia.com;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyboardListener implements KeyboardHandler {

    private static int[] KEY_CODES = {
            KeyboardEvent.KEY_B,
            KeyboardEvent.KEY_C,
            KeyboardEvent.KEY_D,
            KeyboardEvent.KEY_G,
            KeyboardEvent.KEY_J,
            KeyboardEvent.KEY_L,
            KeyboardEvent.KEY_M,
            KeyboardEvent.KEY_N,
            KeyboardEvent.KEY_R,
            KeyboardEvent.KEY_V,
    };

    private Grid grid;

    public KeyboardListener(Grid grid) {
        this.grid = grid;
        init();
    }

    public void init() {
        Keyboard keyboard = new Keyboard(this);
        for (int code : KEY_CODES) {
            subscribe(keyboard, code);
        }
    }

    private void subscribe(Keyboard keyboard, int code) {
        KeyboardEvent event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        event.setKey(code);
        keyboard.addEventListener(event);
    }



    public void pressed(int key) {
        switch (key) {
            case KeyboardEvent.KEY_B:
                grid.show(0);
                break;
            case KeyboardEvent.KEY_C:
                int c = getRandomTWO() + 1;
                grid.show(c);
                break;
            case KeyboardEvent.KEY_D:
                grid.show(3);
                break;
            case KeyboardEvent.KEY_G:
                grid.show(4);
                break;
            case KeyboardEvent.KEY_J:
                grid.show(5);
                break;
            case KeyboardEvent.KEY_L:
                grid.show(6);
                break;
            case KeyboardEvent.KEY_M:
                int m = getRandomTHREE() + 7;
                grid.show(m);
                break;
            case KeyboardEvent.KEY_N:
                break;
            case KeyboardEvent.KEY_R:
                int r = getRandomTHREE()  + 10;
                grid.show(r);
                break;
            case KeyboardEvent.KEY_V:
                grid.show(13);
                break;
        }
    }


    public int getRandomTHREE() {
        int rand = ((int) (Math.random() * 3));
        return rand;
    }

    public int getRandomTWO() {
        int rand = ((int) (Math.random() * 2));
        return rand;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        pressed(keyboardEvent.getKey());
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
