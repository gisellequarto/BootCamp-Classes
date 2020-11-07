package org.academiadecodigo.tailormoons.server;

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
    private final String quitMessage = " quit the chat.";
    private final String arriveMessage = " entered the chat.";

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
            String realName = name + server.getClientNumber(this);
            setName(realName);
            String received = "";
            server.notificate(name + arriveMessage, this);
            while (!client.isClosed()) {

                while ((received = in.readLine()) == null) {
                    wait();
                }
                if (received.contains("/quit")) {
                    analyzeCommand(received);
                    break;
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

    public void setName(String other) {
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
            String[] result = whisperCommand(input);
            server.whisper(result[0], result[1]);
            return false;
        } else if (input.contains("/quit")) {
            server.notificate(name + quitMessage, this);
            server.deleteList(this);
            System.exit(0);
            return false;
        }
        return true;
    }

    private String[] whisperCommand(String input) {
        String[] temp = input.split(" ");
        String message = "";
        for (int i = 2; i < temp.length; i++) {
            message += temp[i] + " ";
        }
        String[] result = {temp[1], message};
        return result;
    }

}