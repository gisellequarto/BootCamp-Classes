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


    public KeyboardListener() {
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
                break;
            case KeyboardEvent.KEY_C:
                break;
            case KeyboardEvent.KEY_D:
                new GameObjects(Person.DANIEL);
                break;
            case KeyboardEvent.KEY_G:
                break;
            case KeyboardEvent.KEY_J:
                new GameObjects(Person.JOAO);
                break;
            case KeyboardEvent.KEY_L:
                break;
            case KeyboardEvent.KEY_M:
                new GameObjects(Person.MAY);
                break;
            case KeyboardEvent.KEY_N:
                break;
            case KeyboardEvent.KEY_R:
                break;
            case KeyboardEvent.KEY_V:
                new GameObjects(Person.VANIA);
                break;
        }
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        pressed(keyboardEvent.getKey());
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
