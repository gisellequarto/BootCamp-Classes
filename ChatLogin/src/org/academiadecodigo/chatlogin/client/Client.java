package org.academiadecodigo.chatlogin.client;

import org.academiadecodigo.chatlogin.DataBase;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    private InetAddress host;
    private int portNumber = 8080;
    private Socket clientSocket;
    private String username;
    private String password;

    public Client(String username, String password) {
        this.username = username;
        this.password = password;
       // DataBase.getInstance().addUser();
    }


    public void start() {
        openConnection();
        Thread serverThread = new Thread(new ServerHandler(clientSocket));
        Thread terminalThread = new Thread(new TerminalHandler(clientSocket));
        serverThread.start();
        terminalThread.start();
    }


    public void openConnection() {
        try {
            host = InetAddress.getLocalHost();
            clientSocket = new Socket(host, portNumber);
        } catch (UnknownHostException e) {
            System.out.println("Host we have a problem" + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
