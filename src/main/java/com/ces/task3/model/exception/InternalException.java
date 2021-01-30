package com.ces.task3.model.exception;

public class InternalException extends Exception{

    public InternalException(String message) {
        super(message);
    }

    public InternalException() {
        super("Server have some things error!");
    }
}
