package com.DevEx.DevExBE.global.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleApiRequestException(Exception ex) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
        return new ResponseEntity<>(exceptionResponse, exceptionResponse.getHttpStatus());
    }

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ExceptionResponse> handleCustomException(BaseException e) {
        ErrorCode errorCode = e.getErrorCode();
        ExceptionResponse exceptionResponse = new ExceptionResponse(errorCode);
        return new ResponseEntity<>(exceptionResponse, errorCode.getStatus());
    }
}
