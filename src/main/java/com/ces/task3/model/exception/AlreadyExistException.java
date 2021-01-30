package com.ces.task3.model.exception;

public class AlreadyExistException extends Exception{
    public AlreadyExistException(String configField, String configValue) {
        super("Already exist a record with " + configField + ": "+ configValue);
    }

    public AlreadyExistException() {
        super();
    }

    public AlreadyExistException(String message) {
        super(message);
    }
}
