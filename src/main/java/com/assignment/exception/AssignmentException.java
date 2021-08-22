package com.assignment.exception;

public class AssignmentException extends AssignmentGlobalException {

    public AssignmentException(){
        super("Entity Not Found", GlobalErrorCode.ERROR_ENTITY_NOT_FOUND);
    }

    public AssignmentException(String message, Long code) {
        super(message, code);
    }
}