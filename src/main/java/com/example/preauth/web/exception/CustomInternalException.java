package com.example.preauth.web.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class CustomInternalException extends CustomSystemException {

    public CustomInternalException(String message) {
        super(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
