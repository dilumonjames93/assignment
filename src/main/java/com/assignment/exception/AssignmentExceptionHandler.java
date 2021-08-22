package com.assignment.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Locale;

@ControllerAdvice
public class AssignmentExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(AssignmentExceptionHandler.class);

    @ExceptionHandler(AssignmentException.class)
    protected ResponseEntity handleAssignmentException(AssignmentException e, Locale locale) {
        log.error(e.getMessage(), e);
        return ResponseEntity
                .badRequest()
                .body(e.getMessage());

    }


    @ExceptionHandler({Exception.class})
    protected ResponseEntity handleException(Exception e, Locale locale) {
        log.error(e.getMessage(), e);
        return ResponseEntity
                .badRequest()
                .body("Internal server Error " + e);
    }
}
