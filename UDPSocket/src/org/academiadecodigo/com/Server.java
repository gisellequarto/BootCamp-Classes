package org.academiadecodigo.com;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {


    public static void receivePack() {
        byte[] recBuffer = new byte[2048];
        try {
            DatagramSocket socket = new DatagramSocket(8080);
            DatagramPacket receivePack = new DatagramPacket(recBuffer, recBuffer.length);
            socket.receive(receivePack);
            socket.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String message = new String(recBuffer);
        System.out.println(message);
    }



    public static void main(String[] args) {

        receivePack();

    }
}
