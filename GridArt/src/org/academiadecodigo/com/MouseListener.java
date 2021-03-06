package org.academiadecodigo.com;

import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

public class MouseListener implements MouseHandler {

    MenuGrid menu;


    public MouseListener(MenuGrid menu, Cursor cursor) {
        this.menu = menu;
    }


    @Override
    public void mouseClicked(MouseEvent event) {
        menu.updateActualColor(event.getX(), event.getY());
    }

    @Override
    public void mouseMoved(MouseEvent event) {

    }
}
