package org.academiadecodigo.chatlogin;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.string.PasswordInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
import org.academiadecodigo.chatlogin.DataBase;
import org.academiadecodigo.chatlogin.User;

public class Credential {

        private String username = "";
        private String password = "";
        Prompt prompt = new Prompt(System.in, System.out);

    public void login(User user) {
        verifyUsername();
        verifyPassword();
    }

    public void verifyUsername() {
        System.out.println("Welcome to the chat!\nInsert your credentials below:\n");
        StringInputScanner usernameInput = new StringInputScanner();



        while (!DataBase.getInstance().correctUsername(username)) {
            usernameInput.setMessage("Username: ");
            username = prompt.getUserInput(usernameInput);

            if (!DataBase.getInstance().correctUsername(username)) {
                System.out.println("Wrong username, please try again.");
                continue;
            }
        }
    }

    public void verifyPassword() {
        PasswordInputScanner passwordInput = new PasswordInputScanner();
        int counter = 3;

        while ((!DataBase.getInstance().correctPassword(username, password) && counter >= 0)) {
            passwordInput.setMessage("Password: ");
            password = prompt.getUserInput(passwordInput);

            if (!DataBase.getInstance().correctPassword(username, password)) {

                if (counter == 1) {
                    System.out.println("Wrong password. you have only " + counter + " try");
                    counter--;
                    continue;
                }
                System.out.println("Wrong password. you have " + counter + " tries");
                counter--;
            }
        }

        if (DataBase.getInstance().correctPassword(username, password)) {
            System.out.println("Login Successful!\nWelcome! Let's chat!");
        } else {
            System.out.println("Sorry, you can't login.");
        }
    }


}
