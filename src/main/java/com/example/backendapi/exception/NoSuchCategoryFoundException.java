package com.example.backendapi.exception;

import lombok.Getter;

@Getter
public class NoSuchCategoryFoundException extends RuntimeException{

    private static String message = "Category with given name is not found in database";
    public NoSuchCategoryFoundException(){
        super(message);
    }
}
