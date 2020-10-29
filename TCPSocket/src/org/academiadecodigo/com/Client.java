package org.academiadecodigo.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

    private static InetAddress host;
    private static int portNumber = 8080;
    private static Socket clientSocket;
    private static InputStreamReader inputStream;
    private static BufferedReader in;

    public static void openConnection() {
        try {
            host = InetAddress.getLocalHost();
            clientSocket = new Socket(host, portNumber);
        } catch (UnknownHostException e) {
            System.out.println("Host we have a problem" + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void sendMessage(String message) {
        try {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.println(message);
        } catch (IOException e) {
            System.out.println("Send Message Bug" + e.getMessage());
        }
    }


    public static void receiveInput() {
        try {
            inputStream = new InputStreamReader(clientSocket.getInputStream());
            in = new BufferedReader(inputStream);
            String received = in.readLine();
            System.out.println(received);
        } catch (IOException e) {
            System.out.println("Receive bug" + e.getMessage());
        }
    }


    public static void closeClient() {
        try {
            clientSocket.close();
            inputStream.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();

        openConnection();

        while (!clientSocket.isClosed()) {
            sendMessage(message);
            receiveInput();
            message = scanner.nextLine();
        }

        closeClient();

    }


}
