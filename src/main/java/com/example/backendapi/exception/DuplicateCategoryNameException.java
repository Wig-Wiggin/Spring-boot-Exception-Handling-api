package com.example.backendapi.exception;

public class DuplicateCategoryNameException extends RuntimeException{

    public DuplicateCategoryNameException(){
        super("Category name is duplicated compare with database");
    }
}
