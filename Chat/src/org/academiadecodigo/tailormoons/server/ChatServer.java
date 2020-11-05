package org.academiadecodigo.tailormoons.server;

public class ChatServer {

    public static void main(String[] args) {


            Server server = new Server();

            while (true) {
                server.makeConnection();
            }


        }

}
