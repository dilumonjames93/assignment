package com.assignment.exception;


public class AssignmentGlobalException extends RuntimeException {

    private Long code;

    public Long getCode() {
        return code;
    }

    public AssignmentGlobalException (String message, Long code) {
        super(message);
        this.code = code;
    }
}
