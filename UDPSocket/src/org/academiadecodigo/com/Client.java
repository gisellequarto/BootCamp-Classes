package org.academiadecodigo.com;

import java.io.IOException;
import java.net.*;

public class Client {


    public static void sendPack(String message) throws UnknownHostException {
        byte[] sendBuffer = message.getBytes();
        try {
            DatagramSocket socket = new DatagramSocket(9999);
            DatagramPacket sendPack = new DatagramPacket(sendBuffer, sendBuffer.length, InetAddress.getByName("ubuntugi") , 8080);
            socket.send(sendPack);
            socket.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) throws UnknownHostException {

        String message = "hello";

        sendPack(message);


    }

}
