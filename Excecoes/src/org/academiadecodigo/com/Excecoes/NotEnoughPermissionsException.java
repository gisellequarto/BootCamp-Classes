package org.academiadecodigo.com.Excecoes;

import org.academiadecodigo.com.Excecoes.FileException;

public class NotEnoughPermissionsException extends FileException {

    public NotEnoughPermissionsException() {

    }

    @Override
    public String getMessage() {
        return "Not Enough Permissions - Check your login";
    }
}
