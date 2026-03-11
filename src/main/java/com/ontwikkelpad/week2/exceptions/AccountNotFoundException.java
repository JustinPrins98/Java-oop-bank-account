package com.ontwikkelpad.week2.exceptions;

public class AccountNotFoundException extends RuntimeException {
    // Constructor
    public AccountNotFoundException(String message){
        super(message);
    }

}
