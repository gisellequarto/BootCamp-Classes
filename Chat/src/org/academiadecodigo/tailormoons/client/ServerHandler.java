package org.academiadecodigo.tailormoons.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerHandler implements Runnable {

    private Socket clientSocket;

    public ServerHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        while (!clientSocket.isClosed()) {
            String received = getServerInput();
            if (received.startsWith("/quit")) {
                System.exit(0);
            }
            System.out.println(received);
        }
    }


    public String getServerInput() {
        String received = "";
        try {
            InputStreamReader inputStream = new InputStreamReader(clientSocket.getInputStream());
            BufferedReader in = new BufferedReader(inputStream);
            received = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return received;
    }

    public void close() {
        try {
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}