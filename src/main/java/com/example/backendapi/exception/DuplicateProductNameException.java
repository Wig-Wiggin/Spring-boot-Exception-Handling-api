package com.example.backendapi.exception;

public class DuplicateProductNameException extends RuntimeException{

    public DuplicateProductNameException(){
        super("Given product name is already existed in database");
    }

}
