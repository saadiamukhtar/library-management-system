package com.library.management.system;

public class BookAlreadyReturnedException extends RuntimeException{
    public BookAlreadyReturnedException(String message){
        super(message);
    }
}
