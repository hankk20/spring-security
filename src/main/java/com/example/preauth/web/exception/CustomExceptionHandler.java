package com.example.preauth.web.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice(annotations = RestController.class)
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomSystemException.class)
    public ResponseEntity<ResponseExceptionEntity> customError(CustomSystemException e){
        return ResponseExceptionEntity.builder()
                .statusCode(e.getHttpStatus().value())
                .message(e.getMessage())
                .timestemp(LocalDateTime.now())
                .build();
    }

}
