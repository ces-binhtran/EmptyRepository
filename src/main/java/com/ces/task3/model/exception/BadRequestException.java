package com.ces.task3.model.exception;

import java.util.stream.Stream;

public class BadRequestException extends Exception{

    public BadRequestException() {
        super();
    }

    public BadRequestException(String message) {
        super(message);
    }

    // exp: Missing require filed ( name, email ).
    public static BadRequestException builder(String ...missedFieldNames){
        StringBuilder builder = new StringBuilder("Missing require field ( ");
        Stream.of(missedFieldNames)
                .forEach(fieldName -> builder.append(fieldName).append(" ,"));
        builder.append(" ).");
        return new BadRequestException(builder.toString());
    }
}
