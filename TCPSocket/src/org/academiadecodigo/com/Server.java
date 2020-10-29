package org.academiadecodigo.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static int portNumber = 8080;
    private static ServerSocket serverSocket;
    private static Socket clientSocket;
    private static InputStreamReader inputStream;
    private static BufferedReader in;
    private static String received;


    public static void makeConnection() {
        try {
            serverSocket = new ServerSocket(portNumber);
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.out.println("Server connection bug" + e.getMessage());
        }
    }

    public static void receiveInput() {
        try {
            inputStream = new InputStreamReader(clientSocket.getInputStream());
            in = new BufferedReader(inputStream);
            received = in.readLine();
        } catch (IOException e) {
            System.out.println("Receive bug" + e.getMessage());
        }
    }


    public static void sendCrazyEcho() {
        if (received == null) {
            closeServer();
            return;
        }
        String echo = (received.toUpperCase() + " ... " + received.toLowerCase() + " ... " + received.toLowerCase());
        try {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.write(echo);
            out.println();
        } catch (IOException e) {
            System.out.println("Crazy Echo Bug" + e.getMessage());
        }

    }


    public static int getPortNumber() {
        return portNumber;
    }

    public static void closeServer() {
        try {
            serverSocket.close();
            clientSocket.close();
            inputStream.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {


        makeConnection();

        while (!clientSocket.isClosed()) {
            receiveInput();
            sendCrazyEcho();
        }

        closeServer();


    }
}
