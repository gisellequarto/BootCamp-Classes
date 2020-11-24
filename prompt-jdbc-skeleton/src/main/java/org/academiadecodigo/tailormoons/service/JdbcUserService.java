package org.academiadecodigo.tailormoons.service;

import org.academiadecodigo.tailormoons.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class JdbcUserService implements UserService {

    private ConnectionManager manager;
    private Connection connection;

    public JdbcUserService() {
        manager = new ConnectionManager();
        connection = manager.getConnection();
    }

    @Override
    public boolean authenticate(String username, String password) {
        String query = "SELECT * FROM user WHERE username = '" + username + "' AND password = '" + password + "';";
        System.out.println(query);
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.first()) {
                return true;
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void add(User user) {
        String query = "INSERT INTO user(username, password, email, firstname, lastname, phone) " +
                "VALUES ('" + user.getUsername() + "', '" + user.getPassword() + "', '" + user.getEmail() +
                "', '" + user.getFirstName() + "', '" + user.getLastName() + "', '" + user.getPhone() + "');";
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User findByName(String username) {
        String query = "SELECT * FROM user WHERE username = '" + username + "';";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()){
                String usernameValue = resultSet.getString("username");
                String passwordValue = resultSet.getString("password");
                String emailValue = resultSet.getString("email");
                String firstnameValue = resultSet.getString("firstname");
                String lastnameValue = resultSet.getString("lastname");
                String phoneValue = resultSet.getString("phone");

                return new User(usernameValue, emailValue, passwordValue, firstnameValue, lastnameValue, phoneValue);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        String query = "SELECT * FROM user;";
        List<User> list = new LinkedList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                String usernameValue = resultSet.getString("username");
                String passwordValue = resultSet.getString("password");
                String emailValue = resultSet.getString("email");
                String firstnameValue = resultSet.getString("firstname");
                String lastnameValue = resultSet.getString("lastname");
                String phoneValue = resultSet.getString("phone");

                list.add(new User(usernameValue, emailValue, passwordValue, firstnameValue, lastnameValue, phoneValue));
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int count() {
        int num = 0;
        String query = "SELECT COUNT(*) FROM user";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                num = resultSet.getInt(1);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num;
    }
}
