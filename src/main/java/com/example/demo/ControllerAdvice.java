package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;


/**
 * Exception handler advice class for all SpringMVC controllers.
 * @author norrisshelton
 * @see org.springframework.web.bind.annotation.ControllerAdvice
 */
@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    /**
     * Handles ErrorExceptions for the SpringMVC controllers.
     * @param e SpringMVC controller exception.
     * @return http response entity
     * @see ExceptionHandler
     */
    @ExceptionHandler(ErrorException.class)
    public ResponseEntity<?> handleException(ErrorException e) {
        return ResponseEntity.status(e.getHttpStatus()).body(e.getMessage());
    }
}