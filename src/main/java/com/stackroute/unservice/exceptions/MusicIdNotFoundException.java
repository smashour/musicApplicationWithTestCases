package com.stackroute.unservice.exceptions;

public class MusicIdNotFoundException extends Exception {

    private String message;
    public MusicIdNotFoundException(){

    }

    public MusicIdNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
