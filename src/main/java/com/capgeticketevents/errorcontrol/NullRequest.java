package com.capgeticketevents.errorcontrol;

public class NullRequest extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public NullRequest() {
        super("No se ha encontrado los datos de Event ");
    }

}
