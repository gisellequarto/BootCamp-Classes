package org.academiadecodigo.com;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private int portNumber = 9999;
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private InputStreamReader inputHeader;
    private BufferedReader in;
    private String[] headerFirstLine;
    private int fileByteSize;
    private BufferedOutputStream out;
    private FileInputStream inputSize;
    private FileInputStream inputFile;
    private static String[] archivesPaths = {"/notFound", "/photo", "/music"};


    private String headerText = ("HTTP/1.0 200 Document Follows\r\n" +
            "Content-Type: text/html; charset=UTF-8\r\n" +
            "Content-Length: <file_byte_size> \r\n" +
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
            inputHeader = new InputStreamReader(clientSocket.getInputStream());
            in = new BufferedReader(inputHeader);
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

    public String getFilePath() {
        if (analyzeVerb()) {
            if (headerFirstLine[1].equals("/")) {
                return "";
            }

            for (int i = 0; i < archivesPaths.length; i++) {
                if (headerFirstLine[1].equals(archivesPaths[i])) {
                    return archivesPaths[i];
                }
            }
            return archivesPaths[0];
        }
        return "";
    }


    public void getArchive() {
        String path = getFilePath();
        if (path == "") {
            return;
        }
        try {
            path = path.substring(1);
            inputSize = new FileInputStream(path);
            inputFile = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            System.out.println("Finding File Bug" + e.getMessage());
        }
    }


    public void getArchiveByteSize() {
        fileByteSize = 0;
        int b = 0;
        try {
            while ((b = inputSize.read()) != -1) {
                fileByteSize++;
            }
        } catch (IOException e) {
            System.out.println("Read file bytes bug" + e);
        }
    }


    public void sendResponseHeader() {
        if (headerFirstLine.length < 0) {
            closeServer();
            return;
        }
        getArchiveByteSize();
        String size = "" + fileByteSize;
        headerText = headerText.replace("<file_byte_size>", size);
        System.out.println(headerText);
        byte[] headerBytes = headerText.getBytes();

        try {
            out = new BufferedOutputStream(clientSocket.getOutputStream());
            out.write(headerBytes, 0, headerBytes.length);
            out.flush();
            System.out.println("header gone");
        } catch (IOException e) {
            System.out.println("Send Response Header bug" + e.getMessage());
        }
    }

    public void serverResponse() {
        sendResponseHeader();
        byte[] fileBuffer = new byte[2048];
        int n = 0;
        try {
            BufferedOutputStream outFile = new BufferedOutputStream(clientSocket.getOutputStream());
            while ((n = inputFile.read(fileBuffer)) != -1) {
                System.out.println("file gone");
                inputFile.read(fileBuffer);
                outFile.write(fileBuffer, 0, fileBuffer.length);
                outFile.flush();
            }
        } catch (IOException e) {
            System.out.println("Server Response bug" + e.getMessage());
        }
    }


    public void closeServer() {
        try {
            serverSocket.close();
            clientSocket.close();
            inputHeader.close();
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
