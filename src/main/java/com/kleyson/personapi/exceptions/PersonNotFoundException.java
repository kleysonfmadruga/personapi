package com.kleyson.personapi.exceptions;

public class PersonNotFoundException extends Exception{
    public PersonNotFoundException(String message){
        super(message);
    }
}
