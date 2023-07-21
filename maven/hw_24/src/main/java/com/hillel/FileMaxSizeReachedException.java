package com.hillel;

public class FileMaxSizeReachedException extends RuntimeException{

    public FileMaxSizeReachedException(String message) {
        super(message);
    }
}
