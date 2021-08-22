package com.assignment.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Locale;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(AssignmentGlobalException.class)
    protected ResponseEntity handleGlobalException(AssignmentGlobalException e, Locale locale) {
        return ResponseEntity
                .badRequest()
                .body(e.getCode().toString().concat(" ").concat(e.getMessage()));

    }


    @ExceptionHandler({Exception.class})
    protected ResponseEntity handleException(Exception e, Locale locale) {
        return ResponseEntity
                .badRequest()
                .body("Exception occured inside API " + e);
    }
}
