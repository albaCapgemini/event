package com.capgeticketevents.errorcontrol;

public class BadRequestException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public BadRequestException() {
        super("Ya existe un usuario con el email: ");
    }
}
