package com.example.preauth.web.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;



public class CustomException extends RuntimeException{
    private String message;

    @Getter
    private HttpStatus httpStatus;

    public CustomException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
