package com.example.demo.exception;


public class ExchangeNotFoundException extends RuntimeException {

    public ExchangeNotFoundException (final String message) {
        super(message);
    }

}
