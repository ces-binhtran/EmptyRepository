package com.ces.task3.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class InternalException extends Exception{

    public InternalException() {
        super("Server have some things error!");
    }
}
