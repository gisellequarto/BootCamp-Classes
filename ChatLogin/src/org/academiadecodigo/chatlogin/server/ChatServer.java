package org.academiadecodigo.chatlogin.server;

public class ChatServer {

    public static void main(String[] args) {


            Server server = new Server();

            while (true) {
                server.makeConnection();
            }


        }

}
