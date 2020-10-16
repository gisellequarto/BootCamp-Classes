package org.academiadecodigo.com.Exceptions;

public class NotEnoughSpaceException extends FileException {

    public NotEnoughSpaceException(String fileName) {
        super("There is no space to the file: " + fileName);
    }


}
