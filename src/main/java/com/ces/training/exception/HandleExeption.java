package com.ces.training.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandleExeption {

    @ExceptionHandler(AppException.class)
    public String handleAppException() {
        return "error";
    }
}
