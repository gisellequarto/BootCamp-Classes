package org.academia.com;

import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Game {

    public static void main(String[] args) {
        Grid grid = new Grid();
        KeyboardListener keyboardListener = new KeyboardListener(grid);

    }


}
