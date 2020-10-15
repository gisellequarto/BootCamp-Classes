package org.academiadecodigo.com.Excecoes;

import org.academiadecodigo.com.Excecoes.FileException;

public class NotEnoughSpaceException extends FileException {

    public NotEnoughSpaceException(String fileName) {
        super("There is no space to the file: " + fileName);
    }


}
