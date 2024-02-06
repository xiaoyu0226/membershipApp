package com.example.demo.exceptions;

public class TreatmentNotFoundException extends RuntimeException{
    private static final long serialVerisionUID = 1;

    public TreatmentNotFoundException(String message) {
        super(message);
    }
}
