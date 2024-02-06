package com.example.demo.exceptions;

import com.example.demo.model.Family;

public class FamilyNotFoundException extends RuntimeException{
    private static final long serialVerisionUID = 1;

    public FamilyNotFoundException(String message) {
        super(message);
    }
}
