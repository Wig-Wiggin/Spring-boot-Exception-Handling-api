package com.example.backendapi.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(NoSuchProductFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> productNotFound(NoSuchProductFoundException exception){
        HttpStatus status = HttpStatus.NOT_FOUND;
     ErrorResponse response = new ErrorResponse(status.value(), exception.getMessage()) ;
     return ResponseEntity.status(status).body(response);
    }


    @ExceptionHandler(NoSuchCategoryFoundException.class)
    public ResponseEntity<ErrorResponse> categoryNotFound(NoSuchCategoryFoundException exception){
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorResponse response = new ErrorResponse(status.value(),exception.getMessage());
        return ResponseEntity.status(status).body(response);
    }


    @ExceptionHandler(DuplicateProductNameException.class)
    public ResponseEntity<ErrorResponse> duplicateProductName(DuplicateProductNameException exception){
        HttpStatus status = HttpStatus.ALREADY_REPORTED;
        ErrorResponse response = new ErrorResponse(status.value(),exception.getMessage());
        return ResponseEntity.status(status).body(response);
    }

    @ExceptionHandler(DuplicateCategoryNameException.class)
    public ResponseEntity<ErrorResponse> duplicateCategoryName(DuplicateCategoryNameException exception){
        HttpStatus status = HttpStatus.ALREADY_REPORTED;
        ErrorResponse response = new ErrorResponse(status.value(),exception.getMessage());
        return ResponseEntity.status(status).body(response);
    }

}
