package org.academiadecodigo.com.Excecoes;

import org.academiadecodigo.com.Excecoes.FileException;

public class FileNotFoundException extends FileException {

    public FileNotFoundException() {
    }

    @Override
    public String getMessage() {
        return "Check file´s name";
    }
}