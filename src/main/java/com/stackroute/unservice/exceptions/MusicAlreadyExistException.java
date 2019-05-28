package com.stackroute.unservice.exceptions;

public class MusicAlreadyExistException extends Exception {

    private String message;
    public MusicAlreadyExistException(){

    }
    public MusicAlreadyExistException(String message){
        super(message);
        this.message=message;
    }
}
