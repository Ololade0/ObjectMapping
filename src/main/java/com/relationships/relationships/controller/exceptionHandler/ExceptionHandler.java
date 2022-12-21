package com.relationships.relationships.controller.exceptionHandler;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.relationships.relationships.controller.ApiError;
import com.relationships.relationships.exception.UserCannotBeFoundExcepttion;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(UserCannotBeFoundExcepttion.class)
    public ResponseEntity<?> handleCustomerAlreadyExistException(UserCannotBeFoundExcepttion userCannotBeFoundExcepttion){
        ApiError apiError = ApiError.builder()
                .message(userCannotBeFoundExcepttion.getMessage())
                .successful(false)
                .statusCode(userCannotBeFoundExcepttion.getStatusCode())
                .build();
        return new ResponseEntity<>(apiError, HttpStatus.valueOf(apiError.getStatusCode()));
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(UnirestException.class)
    public ResponseEntity<?> handleUnirestException( UnirestException unirestException){
        ApiError apiError = ApiError.builder()
                .message(unirestException.getMessage())
                .successful(false)
                .statusCode(400)
                .build();
        return new ResponseEntity<>(apiError, HttpStatus.valueOf(apiError.getStatusCode()));
    }
}
