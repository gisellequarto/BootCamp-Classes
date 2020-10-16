package org.academiadecodigo.com;

import org.academiadecodigo.com.Exceptions.FileNotFoundException;
import org.academiadecodigo.com.Exceptions.NotEnoughPermissionsException;
import org.academiadecodigo.com.Exceptions.NotEnoughSpaceException;
import org.academiadecodigo.com.Files.FileManager;

public class Main {

    public static void main(String[] args) {

        FileManager fileManager = new FileManager(3);

        try {
            fileManager.createFile("File0");
        } catch (NotEnoughPermissionsException e) {
            System.out.println(e.getMessage());
        } catch (NotEnoughSpaceException e) {
            System.out.println(e.getMessage());
        }

        fileManager.login();

        try {
            fileManager.createFile("File0");
            fileManager.createFile("File1");
            fileManager.createFile("File2");
            fileManager.createFile("File3");
        } catch (NotEnoughPermissionsException e) {
            System.out.println(e.getMessage());
        } catch (NotEnoughSpaceException e) {
            System.out.println(e.getMessage());
        }

        try {
            fileManager.getFile("Arquivo1");
            fileManager.getFile("Arquivo3");
        } catch (NotEnoughPermissionsException e) {
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        fileManager.logout();


    }

}