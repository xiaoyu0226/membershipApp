package com.example.demo.exceptions;

public class ClientNotFoundException extends RuntimeException{
    private static final long serialVerisionUID = 1;

    public ClientNotFoundException(String message) {
        super(message);
    }
}
