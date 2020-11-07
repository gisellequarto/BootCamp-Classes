package org.academiadecodigo.com;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyboardListener implements KeyboardHandler {

    private static int[] KEY_CODES = {
            KeyboardEvent.KEY_SPACE,
            KeyboardEvent.KEY_DOWN,
            //backspace missing
            KeyboardEvent.KEY_A,
            KeyboardEvent.KEY_B,
            KeyboardEvent.KEY_C,
            KeyboardEvent.KEY_D,
            KeyboardEvent.KEY_E,
            KeyboardEvent.KEY_F,
            KeyboardEvent.KEY_G,
            KeyboardEvent.KEY_H,
            KeyboardEvent.KEY_I,
            KeyboardEvent.KEY_J,
            KeyboardEvent.KEY_K,
            KeyboardEvent.KEY_L,
            KeyboardEvent.KEY_M,
            KeyboardEvent.KEY_N,
            KeyboardEvent.KEY_O,
            KeyboardEvent.KEY_P,
            KeyboardEvent.KEY_Q,
            KeyboardEvent.KEY_R,
            KeyboardEvent.KEY_S,
            KeyboardEvent.KEY_T,
            KeyboardEvent.KEY_U,
            KeyboardEvent.KEY_V,
            KeyboardEvent.KEY_W,
            KeyboardEvent.KEY_X,
            KeyboardEvent.KEY_Y,
            KeyboardEvent.KEY_Z};

    private UserBox userBox;

    public KeyboardListener(UserBox userBox) {
        this.userBox = userBox;
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

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        userBox.pressed(keyboardEvent.getKey());
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

}
