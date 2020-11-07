package org.academiadecodigo.com;

public class Main {
    public static void main(String[] args) {

        Grid grid = new Grid();
        ServerBox serverBox = new ServerBox();
        serverBox.setServerBox("Who would destroy the bootcamp with Ucal?");
        UserBox user = new UserBox();
        KeyboardListener listener = new KeyboardListener(user);
        listener.init();


    }
}
