package com.example.backendapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class NoSuchProductFoundException extends RuntimeException{

    public NoSuchProductFoundException(){
        super("Product not fount with given Id  ");
    }
}
