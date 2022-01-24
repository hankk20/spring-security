package com.example.preauth.web.exception;

import org.springframework.http.HttpStatus;

public interface CustomHttpStatusException {

    HttpStatus getHttpStatus();
}
