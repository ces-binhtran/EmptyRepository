package com.ces.task3.handler;

import com.ces.task3.model.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


@ControllerAdvice(basePackages = {"com.ces.task3.controller"})
public class ControllerHandlerException {

    public final static String DEFAULT_ERROR_PAGE = "common/error";

    @ResponseStatus(code = HttpStatus.CONFLICT)
    @ExceptionHandler(AlreadyExistException.class)
    private ModelAndView handlerAlreadyExistException(HttpServletRequest request, AlreadyExistException exception){
        return _handlerModelAndView(request, exception, DEFAULT_ERROR_PAGE);
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    private ModelAndView handlerBadRequestException(HttpServletRequest request, BadRequestException exception){
        return _handlerModelAndView(request, exception, DEFAULT_ERROR_PAGE);
    }

    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(LoginException.class)
    private ModelAndView handlerLoginException(HttpServletRequest request, LoginException exception){
        return _handlerModelAndView(request, exception, DEFAULT_ERROR_PAGE);
    }

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = {NotFoundException.class})
    private ModelAndView handlerNotFoundException(HttpServletRequest request, NotFoundException exception){
        return _handlerModelAndView(request, exception, DEFAULT_ERROR_PAGE);
    }

    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = {InternalException.class, Exception.class})
    private ModelAndView handlerInternalException(HttpServletRequest request, Exception exception){
        return _handlerModelAndView(request, exception, DEFAULT_ERROR_PAGE);
    }

    public ModelAndView _handlerModelAndView(HttpServletRequest request, Exception ex, String view){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", ex);
        modelAndView.addObject("url", request.getRequestURL());
        modelAndView.setViewName(view);
        return modelAndView;
    }
}
