package org.academiadecodigo.tailormoons.webserver;

import org.academiadecodigo.tailormoons.webserver.request.Request;
import org.academiadecodigo.tailormoons.webserver.request.InvalidRequestException;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {


    private ServerSocket serverSocket;

    public WebServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void startReceive() {
        while (!serverSocket.isClosed()) {
            Socket client = null;

            try {
                System.out.println("Waiting for connection on port " + serverSocket.getLocalPort());
                client = serverSocket.accept();

                System.out.println("Connection received from " + client.getInetAddress() + ":" + client.getPort());


                Thread threadSend = new Thread(new ClientHandler(client));
                threadSend.start();

            } catch (IOException e) {
                System.err.println("Error handling client request: " + e.getMessage());

            }
        }
    }


}
