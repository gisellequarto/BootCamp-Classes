package org.academiadecodigo.chatlogin;

import java.util.HashSet;
import java.util.Set;

public class DataBase {

    private static DataBase INSTANCE = new DataBase();
    private Set<User> database;

    private DataBase() {
        database = new HashSet<>();
    }

    public static DataBase getInstance() {
        return INSTANCE;
    }

    public boolean addUser(User user) {
        return database.add(user);
    }

    public boolean correctUsername(String username) {
        for (User u : database) {
            if(u.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }

    public boolean correctPassword(String username, String password) {
        for (User u : database) {
            if((u.getUsername().equals(username)) && (u.getPassword().equals(password))){
                return true;
            }
        }
        return false;
    }

}
