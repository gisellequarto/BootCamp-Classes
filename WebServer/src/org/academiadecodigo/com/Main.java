package org.academiadecodigo.com;

public class Main {

    public static void main(String[] args) {
        Server server = new Server();

        server.makeConnection();
        server.receiveHeader();
        server.analyzeVerb();
        server.getArchive();
        server.serverResponse();


    }
}
