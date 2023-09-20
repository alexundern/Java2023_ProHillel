package com.hillel.exception;

/**
 * Exception thrown if the key is not found in the cache.
 */
public class KeyNotFoundException extends RuntimeException {

    public KeyNotFoundException(String message) {
        super("Key not found: " + message);
    }
}