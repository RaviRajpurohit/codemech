package com.codemech.exception;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String msg) {
        super(msg);
    }
}
