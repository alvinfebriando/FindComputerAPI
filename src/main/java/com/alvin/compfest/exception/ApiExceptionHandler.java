package com.alvin.compfest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(value = {ResourceNotFoundException.class})
    public ResponseEntity<Object> handleResourceNotFound(ResourceNotFoundException ex) {
        ApiException apiException = new ApiException(ex.getMessage() + " not found", 404);
        return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {ResourceAlreadyExistsException.class})
    public ResponseEntity<Object> handleResourceAlreadyExisted(ResourceAlreadyExistsException ex) {
        ApiException apiException = new ApiException(ex.getMessage() + " already exists", 409);
        return new ResponseEntity<>(apiException, HttpStatus.CONFLICT);
    }
}
