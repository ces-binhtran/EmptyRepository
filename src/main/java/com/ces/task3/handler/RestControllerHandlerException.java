package com.ces.task3.handler;

import com.ces.task3.model.exception.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;


@ControllerAdvice(basePackages = {"com.ces.task3.api"})
public class RestControllerHandlerException {

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<Object> handlerNotFoundException(){

        return null;
    }
}
