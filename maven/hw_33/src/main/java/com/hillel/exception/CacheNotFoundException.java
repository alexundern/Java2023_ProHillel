package com.hillel.exception;

/**
 * Exception thrown if no cache is found.
 */
public class CacheNotFoundException extends RuntimeException {

    public CacheNotFoundException(String message) {
        super("Cache not found: " + message);
    }
}
