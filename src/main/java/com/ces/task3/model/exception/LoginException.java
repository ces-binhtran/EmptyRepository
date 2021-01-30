package com.ces.task3.model.exception;

public class LoginException extends Exception{
    public LoginException(String message) {
        super(message);
    }

    public LoginException() {
        super("Login Failed! Username or Password not correct.");
    }
}
