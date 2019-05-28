package com.stackroute.unservice.exceptions;

public class MusicNotFoundException extends Throwable {

    private String message;
    public MusicNotFoundException(){

    }

    public MusicNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
