package com.example.demo.exceptions;

public class PartnerNotFoundException extends RuntimeException{
    private static final long serialVerisionUID = 1;

    public PartnerNotFoundException(String message) {
        super(message);
    }
}
