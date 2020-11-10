package org.academiadecodigo.chatlogin.server;

import org.academiadecodigo.chatlogin.server.ClientHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private int portNumber = 8080;
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private ExecutorService threadPool;
    private List<ClientHandler> clientList;

    public Server() {
        clientList = new LinkedList<>();
        threadPool = Executors.newFixedThreadPool(3);
        try {
            serverSocket = new ServerSocket(portNumber);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void makeConnection() {
        try {
            clientSocket = serverSocket.accept();
            ClientHandler client = new ClientHandler(this, clientSocket, "Code_Cadet_");
            clientList.add(client);
            threadPool.submit(client);

        } catch (IOException e) {
            System.out.println("Server connection bug" + e.getMessage());
        }
    }


    public void sendBroadcast(String message, ClientHandler clientHandler) {
        if (message == null) {
            return;
        }
        String broadcast = (clientHandler.getName() + ": " + message);
        for (ClientHandler c : clientList) {
            if(c == clientHandler) {
                continue;
            }
            c.send(broadcast);
        }
    }

    public void listClients(ClientHandler clientHandler) {
        for (ClientHandler c : clientList) {
            clientHandler.send(c.getName());
        }
    }

    public void whisper(String otherClient, String message) {
        for(ClientHandler c : clientList){
            if(c.getName().equals(otherClient)){
                c.send(message);
            }
        }
    }

    public void notificate(String message, ClientHandler clientHandler) {
        for (ClientHandler c : clientList) {
            if(c == clientHandler) {
                continue;
            }
            c.send(message);
        }
    }

    public int getClientNumber(ClientHandler clientHandler) {
        return clientList.indexOf(clientHandler);
    }

    public void deleteList(ClientHandler clientHandler){
        clientList.remove(clientHandler);
    }

}

