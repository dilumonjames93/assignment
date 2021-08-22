package com.assignment.exception;

public class AssignmentException extends Exception {

    public AssignmentException() {
        super("Internal server Error");
    }

    public AssignmentException(String message) {
        super(message);
    }
}