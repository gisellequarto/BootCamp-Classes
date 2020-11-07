package org.academiadecodigo.com;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {


        String name = JOptionPane.showInputDialog("Insert your name:");
        String ready = JOptionPane.showInputDialog("Are you ready? [y/n]");

        Grid grid = new Grid();
        ServerBox serverBox = new ServerBox();
        serverBox.setServerBox("Who would destroy the bootcamp with Ucal?");
        UserBox user = new UserBox();
        KeyboardListener listener = new KeyboardListener(user);
        listener.init();

    }
}
