package com.example.demo.exceptions;

public class RedemptionNotFoundException extends RuntimeException{
    private static final long serialVerisionUID = 1;

    public RedemptionNotFoundException(String message) {
        super(message);
    }
}
