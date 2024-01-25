package com.vinitpk.SpringBootBackend.exception;

/**
 * Custom exception class for handling scenarios where a student is not found.
 *
 * Extends the RuntimeException class for unchecked exception handling.
 *
 * @author Vinit Kelginmane
 * @project SpringBoot-React-CRUD
 * @Date 05-01-2024
 */
public class StudentNotFoundException extends RuntimeException {

    /**
     * Constructor for creating a new instance of the exception with a specific error message.
     *
     * @param message The error message describing the exception.
     */
    public StudentNotFoundException(String message) {
        super(message);
    }
}
