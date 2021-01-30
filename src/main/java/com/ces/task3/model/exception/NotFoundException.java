package com.ces.task3.model.exception;

public class NotFoundException extends Exception{
    public NotFoundException(String fieldName, String fieldValue) {
        super("Not found any record with " +fieldName + ": "+ fieldValue);
    }

    public NotFoundException() {
        super();
    }

    public NotFoundException(String message) {
        super(message);
    }
}
