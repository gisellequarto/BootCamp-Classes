package org.academiadecodigo.tailormoons.client;


import javax.swing.*;

public class Chat {

    public static void main(String[] args) {

        int answer = 3;
        String name = null;


        while (name == null || name.isBlank()) {
            name = JOptionPane.showInputDialog("Insert your name:");
        }

        while (answer != 0) {
            answer = JOptionPane.showConfirmDialog(null, "Are you ready?", "[System]",
                    JOptionPane.YES_NO_OPTION);
        }
        Client client = new Client();

    }
}
