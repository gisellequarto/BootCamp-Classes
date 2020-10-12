package org.academiadecodigo.com.Excecoes;

import org.academiadecodigo.com.Excecoes.FileException;

public class NotEnoughSpaceException extends FileException {

    public NotEnoughSpaceException() {

    }

    @Override
    public String getMessage() {
        return "There is no space to this file";
    }
}
