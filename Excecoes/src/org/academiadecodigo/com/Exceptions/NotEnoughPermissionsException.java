package org.academiadecodigo.com.Exceptions;

public class NotEnoughPermissionsException extends FileException {

    public NotEnoughPermissionsException() {

    }

    @Override
    public String getMessage() {
        return "Not Enough Permissions - Check your login";
    }
}
