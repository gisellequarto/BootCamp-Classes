package org.academiadecodigo.com;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Client {

    private static DatagramSocket socket;
    private static InetAddress host;


    public static void openSocket() {
        try {
            socket = new DatagramSocket();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    public static void sendPack(String message) {
        byte[] sendBuffer = message.getBytes();

        try {
            host = InetAddress.getLocalHost();
            DatagramPacket sendPack = new DatagramPacket(sendBuffer, sendBuffer.length, host, 8080);
            socket.send(sendPack);
        } catch (UnknownHostException e) {
            System.err.println("Host we have a problem");
            ;
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void receivePack() {
        byte[] recBuffer = new byte[2048];
        try {
            DatagramPacket receivePack = new DatagramPacket(recBuffer, recBuffer.length);
            socket.receive(receivePack);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String message = new String(recBuffer);
        System.out.println(message);
    }

    public static void closeSocket() {
        socket.close();
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
            String message = scanner.nextLine();


        openSocket();

        while(message != " ") {
            sendPack(message);
            receivePack();
            message = scanner.nextLine();
        }

        closeSocket();

    }

}
