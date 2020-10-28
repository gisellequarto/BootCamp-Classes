package org.academiadecodigo.com;

import java.io.IOException;
import java.net.*;

public class Client {


    public static void main(String[] args) throws IOException {

    String hostName = "ubuntugi";
    int portNumber = 9999;

    byte[] sendBuffer = "hello word".getBytes();

        DatagramSocket socket = new DatagramSocket(9999);
        DatagramPacket sendPack = new DatagramPacket(sendBuffer, sendBuffer.length, InetAddress.getByName(hostName), portNumber);
        socket.send(sendPack);



    }

}
