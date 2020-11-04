package org.academiadecodigo.tailormoons.webserver;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WebServer {


    private ServerSocket serverSocket;

    public WebServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void startReceive() {
        ExecutorService fixedThreadManager = Executors.newFixedThreadPool(500);
        while (!serverSocket.isClosed()) {
            Socket client = null;

            try {
                System.out.println("Waiting for connection on port " + serverSocket.getLocalPort());
                client = serverSocket.accept();

                System.out.println("Connection received from " + client.getInetAddress() + ":" + client.getPort());


                fixedThreadManager.submit(new ClientHandler(client));


            } catch (IOException e) {
                System.err.println("Error handling client request: " + e.getMessage());

            }
        }
        fixedThreadManager.shutdown();
    }


}
