package org.academiadecodigo.com;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;

import java.util.LinkedList;
import java.util.List;

public class Game {

    private Grid grid;
    private Cursor cursor;
    private MenuGrid menu;

    public Game(int l, int c) {
        grid = new Grid(l, c);
        menu = new MenuGrid();
        cursor = new Cursor(grid, menu);
    }


    public void init() {

        MouseListener mouseListener = new MouseListener(menu, cursor);
        Mouse mouse = new Mouse(mouseListener);
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);

        KeyboardListener listener = new KeyboardListener(cursor, grid);

    }





}
