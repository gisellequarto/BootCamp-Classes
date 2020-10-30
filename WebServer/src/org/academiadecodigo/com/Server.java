package org.academiadecodigo.com;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private int portNumber = 9999;
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private InputStreamReader inputStream;
    private BufferedReader in;
    private String[] headerFirstLine;
    private int fileByteSize;

    private String headerText = ("HTTP/1.0 200 Document Follows\r\n" +
            "Content-Type: text/html; charset=UTF-8\r\n" +
            "Content-Length: " + "1444" + " \r\n" +
            "\r\n");

    public void makeConnection() {
        try {
            serverSocket = new ServerSocket(portNumber);
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.out.println("Server connection bug" + e.getMessage());
        }
    }

    public void receiveHeader() {
        try {
            inputStream = new InputStreamReader(clientSocket.getInputStream());
            in = new BufferedReader(inputStream);
            String received = in.readLine();
            headerFirstLine = received.split(" ");
        } catch (IOException e) {
            System.out.println("Receive bug" + e.getMessage());
        }
    }

    public boolean analyzeVerb() {
        if (headerFirstLine[0].equals("GET")) {
            return true;
        }
        return false;
    }

    public int getArchiveIndex() {
        String[] archivesPaths = FilesManager.getArchivesPaths();
        if (analyzeVerb()) {
            if (headerFirstLine[1].equals("/")) {
                return -1;
            }

            for (int i = 0; i < archivesPaths.length; i++) {
                if (headerFirstLine[1].equals(archivesPaths[i])) {
                    return i;
                }
            }
            return 0;
        }
        return -1;
    }


    public void setFileSize() {
        FilesManager.getArchive(getArchiveIndex());
        fileByteSize = FilesManager.getArchiveByteSize();
        System.out.println(fileByteSize);
    }


    public void sendResponseHeader() {
        if (headerFirstLine.length < 0) {
            closeServer();
            return;
        }
        setFileSize();
        System.out.println(fileByteSize);
        System.out.println(headerText);
        byte[] headerBytes = headerText.getBytes();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        out.write(headerBytes, 0, headerBytes.length);
    }

    public void serverResponse() {
        sendResponseHeader();
        InputStream in = FilesManager.getInput();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] fileBuffer = new byte[2048];
        int n = 0;
        try {
            while ((n = in.read(fileBuffer)) != -1) {
                out.write(fileBuffer, 0, fileBuffer.length);
                out.flush();
            }

        } catch (IOException e) {
            System.out.println("Server Response bug" + e.getMessage());
        }
    }


    public void closeServer() {
        try {
            serverSocket.close();
            clientSocket.close();
            inputStream.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
