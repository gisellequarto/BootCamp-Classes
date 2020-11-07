package org.academiadecodigo.tailormoons.client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    private InetAddress host;
    private int portNumber = 8080;
    private Socket clientSocket;

    public Client() {
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
