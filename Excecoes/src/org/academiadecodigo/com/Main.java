package org.academiadecodigo.com;

import org.academiadecodigo.com.Excecoes.FileNotFoundException;
import org.academiadecodigo.com.Excecoes.NotEnoughPermissionsException;
import org.academiadecodigo.com.Excecoes.NotEnoughSpaceException;
import org.academiadecodigo.com.Files.FileManager;

public class Main {

    public static void main(String[] args) {

        FileManager fileManager = new FileManager(3);

        try {
            fileManager.createFile("Arquivo0");
        } catch (NotEnoughPermissionsException e) {
            System.out.println(e.getMessage());
        } catch (NotEnoughSpaceException e) {
            System.out.println(e.getMessage());
        }

        fileManager.login();

        try {
            fileManager.createFile("Arquivo0");
            fileManager.createFile("Arquivo1");
            fileManager.createFile("Arquivo2");
            fileManager.createFile("Arquivo3");
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