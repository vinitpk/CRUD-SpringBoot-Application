package com.vinitpk.SpringBootBackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * Global exception handler for handling specific exceptions and providing custom responses.
 *
 * It uses annotations such as @RestControllerAdvice, @ExceptionHandler, and @ResponseStatus.
 * Handles MethodArgumentNotValidException, StudentNotFoundException, and StudentAlreadyExistsException.
 *
 * @author Vinit Kelginmane
 * @project SpringBoot-React-CRUD
 * @Date 06-01-2024
 */
@RestControllerAdvice
public class CustomExceptionHandler {

    // Handle validation errors from the RequestBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        // Extract field errors and populate the errors map
        ex.getBindingResult()
                .getFieldErrors()
                .forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
        return errors;
    }

    // Handle exceptions when a student is not found
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(StudentNotFoundException.class)
    public Map<String, String> handleStudentNotFoundException(StudentNotFoundException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());
        return error;
    }

    // Handle exceptions when a student already exists
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(StudentAlreadyExistsException.class)
    public Map<String, String> handleStudentAlreadyExistsException(StudentAlreadyExistsException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());
        return error;
    }
}
