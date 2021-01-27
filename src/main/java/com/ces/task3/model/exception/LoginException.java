package com.ces.task3.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class LoginException extends Exception{
    public LoginException() {
        super("Login Failed! Username or Password not correct.");
    }
}
