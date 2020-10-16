package org.academiadecodigo.com.Exceptions;

public class FileNotFoundException extends FileException {

    public FileNotFoundException() {
    }

    @Override
    public String getMessage() {
        return "Check file´s name";
    }
}