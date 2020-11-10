package org.academiadecodigo.chatlogin.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TerminalHandler implements Runnable {

    private Socket clientSocket;
    Scanner scanner;

    public TerminalHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }


    @Override
    public void run() {
        while (!clientSocket.isClosed()) {
            String received = getTerminalInput();
            sendServer(received);
        }
    }


    public String getTerminalInput() {
        scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }

    public void sendServer(String message) {
        try {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.println(message);
        } catch (IOException e) {
            System.out.println("Send Message Bug " + e.getMessage());
        }
    }

    public void close(){
        try {
            scanner.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
