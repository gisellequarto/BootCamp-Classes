package org.academiadecodigo.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {


    private Socket client;
    private Server server;

    private InputStreamReader inputStream;
    private BufferedReader in;
    private String name;

    public ClientHandler(Server server, Socket client, String name) {
        this.server = server;
        this.client = client;
        this.name = name;
    }


    @Override
    public void run() {
        try {
            inputStream = new InputStreamReader(client.getInputStream());
            in = new BufferedReader(inputStream);
            String received = "";
            while (!client.isClosed()) {

                while ((received = in.readLine()) == null) {
                    wait();
                }
                if (analyzeCommand(received)) {
                    server.sendBroadcast(received, this);

                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void send(String message) {
        PrintWriter out = null;
        try {
            out = new PrintWriter(client.getOutputStream(), true);
            out.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String other){
        name = other;
    }

    public boolean analyzeCommand(String input) {
        if (input.contains("/name")) {
            String[] command = input.split(" ");
            setName(command[1]);
            return false;
        } else if (input.contains("/list")) {
            server.listClients(this);
            return false;
        } else if (input.contains("/whisper")) {
            //fazer as alterações
            return false;
        }
        return true;
    }

}