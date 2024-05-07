package com.example.backendapi.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter@Getter
public class ErrorResponse {


    private int statusCode;

    private String message;


}
