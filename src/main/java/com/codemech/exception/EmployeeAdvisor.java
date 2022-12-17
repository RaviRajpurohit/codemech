package com.codemech.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class EmployeeAdvisor {

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException ex, WebRequest webRequest) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<Object> handleEmployeeNotFoundException(EmployeeNotFoundException ex, WebRequest webRequest) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(DepartmentNotFoundException.class)
	public ResponseEntity<Object> handleDepartmentNotFoundException(DepartmentNotFoundException ex,
			WebRequest webRequest) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}

}
