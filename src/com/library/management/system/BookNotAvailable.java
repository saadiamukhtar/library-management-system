package com.library.management.system;

public class BookNotAvailable extends RuntimeException {
    public BookNotAvailable(String message){
        super(message);
    }
}
