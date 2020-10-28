package org.academiadecodigo.com;

import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;

public class MapEditor {

    private Grid grid;
    private Cursor cursor;
    private MenuGrid menu;

    public MapEditor(int l, int c) {
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
