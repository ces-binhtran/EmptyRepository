package com.ces.task3.model.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class NotFoundException extends Exception{
    public NotFoundException(String fieldName, String fieldValue) {
        super("Not found any record with " +fieldName + ": "+ fieldValue);
    }
}
