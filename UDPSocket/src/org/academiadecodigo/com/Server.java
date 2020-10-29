package org.academiadecodigo.com;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Server {

    private static DatagramSocket socket;
    private static DatagramPacket pack;
    private static String message;

    public static void openSocket() {
        try {
            socket = new DatagramSocket(8080);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    public static void receivePack() {
        byte[] recBuffer = new byte[2048];
        pack = new DatagramPacket(recBuffer, recBuffer.length);

        try {
            socket.receive(pack);
            message = (new String(recBuffer));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void sendUpperCasePack() {
        message = message.toUpperCase();
        byte[] sendBuffer = message.getBytes();
        DatagramPacket sendPack = new DatagramPacket(sendBuffer, sendBuffer.length, pack.getAddress(), pack.getPort());

        try {
            socket.send(sendPack);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void closeSocket() {
        socket.close();
    }


    public static void main(String[] args) {

        openSocket();


        while (!socket.isClosed()) {
            receivePack();
            sendUpperCasePack();
        }

        closeSocket();

    }
}
