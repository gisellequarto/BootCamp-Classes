package org.academiadecodigo.com.Files;

import org.academiadecodigo.com.Excecoes.FileNotFoundException;
import org.academiadecodigo.com.Excecoes.NotEnoughPermissionsException;
import org.academiadecodigo.com.Excecoes.NotEnoughSpaceException;

public class FileManager {

    private boolean logged;
    private File[] files;

    public FileManager(int numsOfFiles) {
        files = new File[numsOfFiles];
    }

    public void login() {
        logged = true;
    }

    public void logout() {
        logged = false;
    }

    public File getFile(String fileName) throws FileNotFoundException, NotEnoughPermissionsException {
        if (!logged) {
            throw new NotEnoughPermissionsException();
        }

        for (File f : files) {
            if (f.getName().equals(fileName)) {
                System.out.println("Here´s you file: " + f.getName());
                return f;
            }
        }
        throw new FileNotFoundException();
    }

    public void createFile(String fileName) throws NotEnoughSpaceException, NotEnoughPermissionsException {
        if (!logged) {
            throw new NotEnoughPermissionsException();
        }

        for (int i = 0; i < files.length; i++) {
            if (files[i] == null) {
                files[i] = new File(fileName);
                return;
            }
        }
        throw new NotEnoughSpaceException(fileName);

    }


}
