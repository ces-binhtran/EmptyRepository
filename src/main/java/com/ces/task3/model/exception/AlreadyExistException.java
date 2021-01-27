package com.ces.task3.model.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class AlreadyExistException extends Exception{
    public AlreadyExistException(String configField, String configValue) {
        super("Already exist a record with " + configField + ": "+ configValue);
    }
}
