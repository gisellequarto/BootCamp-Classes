package org.academiadecodigo.com;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;

public class Game {

    private Grid grid;
    private Cursor cursor;

    public Game(int l, int c) {
        grid = new Grid(l, c);
       cursor = new Cursor(grid) ;
    }


    public void init(){

        Keyboard keyboard = new Keyboard(new KeyboardListener(cursor, grid));
        KeyboardEvent right = new KeyboardEvent();
        KeyboardEvent left = new KeyboardEvent();
        KeyboardEvent up = new KeyboardEvent();
        KeyboardEvent down = new KeyboardEvent();
        KeyboardEvent paint = new KeyboardEvent();
        KeyboardEvent save = new KeyboardEvent();
        KeyboardEvent load = new KeyboardEvent();
        KeyboardEvent clear = new KeyboardEvent();

        right.setKey(KeyboardEvent.KEY_RIGHT);
        left.setKey(KeyboardEvent.KEY_LEFT);
        up.setKey(KeyboardEvent.KEY_UP);
        down.setKey(KeyboardEvent.KEY_DOWN);
        paint.setKey(KeyboardEvent.KEY_SPACE);
        save.setKey(KeyboardEvent.KEY_S);
        load.setKey(KeyboardEvent.KEY_L);
        clear.setKey(KeyboardEvent.KEY_C);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        paint.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        save.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        load.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        clear.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(right);
        keyboard.addEventListener(left);
        keyboard.addEventListener(up);
        keyboard.addEventListener(down);
        keyboard.addEventListener(paint);
        keyboard.addEventListener(save);
        keyboard.addEventListener(load);
        keyboard.addEventListener(clear);




    }




}
