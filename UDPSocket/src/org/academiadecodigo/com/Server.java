package org.academiadecodigo.com;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {


    public static void receivePack(String message) {
        byte[] recBuffer = message.getBytes();
        DatagramPacket receivePack = new DatagramPacket(recBuffer, recBuffer.length);
        try {
            DatagramSocket socket = new DatagramSocket(8080);
            socket.receive(receivePack);
            System.out.println(socket.getReceiveBufferSize());
            socket.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {

        String test = "hello";

        receivePack(test);


    }
}
