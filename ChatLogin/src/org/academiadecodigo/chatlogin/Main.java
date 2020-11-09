package org.academiadecodigo.chatlogin;

public class Main {

    public static void main(String[] args) {

        DataBase dataBase = DataBase.getInstance();

        User u1 = new User("giselle", "1234");
        User u2 = new User("elodie", "5678");
        User u3 = new User("tiago", "abcd");

        dataBase.addUser(u1);
        dataBase.addUser(u2);
        dataBase.addUser(u3);

        Credential credential = new Credential();
        credential.login(u1);

    }
}
