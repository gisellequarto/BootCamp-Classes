package org.academiadecodigo.com;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FilesManager {

    private static FileInputStream inputStream;
    private static String[] archivesPaths = {"/notFound", "/photo", "/music"};


    public static void getArchive(int index) {
        if(index == -1) {
            return;
        }
        try {
            String path  = archivesPaths[index].substring(1);
            inputStream = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            System.out.println("Finding File Bug" + e.getMessage());
        }
    }

    public static int getArchiveByteSize() {
        int counter = 0;
        int b = 0;
        try {
            while ((b = inputStream.read()) != -1) {
                counter++;
            }
        } catch (IOException e) {
            System.out.println("Read file bytes bug" + e);
        }
        System.out.println(counter);
        return counter;
    }

    public static InputStream getInput() {
        return inputStream;
    }

    public static String[] getArchivesPaths() {
        return archivesPaths;
    }
}
