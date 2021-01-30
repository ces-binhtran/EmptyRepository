package com.ces.task3.handler;

import com.ces.task3.contrain.ResponseMessage;
import com.ces.task3.model.exception.BadRequestException;
import com.ces.task3.model.exception.InternalException;
import com.ces.task3.model.exception.NotFoundException;
import com.ces.task3.model.response.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;


@ControllerAdvice(basePackages = {"com.ces.task3.api"})
public class RestControllerHandlerException {

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<Object> handlerNotFoundException(NotFoundException exception, HttpServletRequest request){
        return _buildResponseEntity(
                ResponseMessage.NOT_FOUND_RECORD,
                HttpStatus.NOT_FOUND,
                exception,
                request
        );
    }

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<Object> handlerBadRequestException(BadRequestException exception, HttpServletRequest request){
        return _buildResponseEntity(
                ResponseMessage.MISSING_REQUIRE_FIELD,
                HttpStatus.BAD_REQUEST,
                exception,
                request
        );
    }


    @ExceptionHandler({InternalException.class, Exception.class})
    public ResponseEntity<Object> handlerInternalExceptionException(Exception exception, HttpServletRequest request){
        return _buildResponseEntity(
                ResponseMessage.INTERNAL_SERVER_ERROR,
                HttpStatus.INTERNAL_SERVER_ERROR,
                exception,
                request
        );
    }

    protected ResponseEntity _buildResponseEntity(String error, HttpStatus status, Exception ex, HttpServletRequest request) {
        ErrorResponse response = ErrorResponse.builder()
                .error(error)
                .message(ex.getMessage())
                .status(status.value())
                .path(request.getRequestURL().toString())
                .build();
        return new ResponseEntity<>(response, new HttpHeaders(), status);
    }


}
