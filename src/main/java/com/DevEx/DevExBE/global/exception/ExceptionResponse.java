package com.DevEx.DevExBE.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class ExceptionResponse {
    private final String errorMessage;
    private final HttpStatus httpStatus;
    private String code;
    private LocalDateTime timeStamp;

    public ExceptionResponse(HttpStatus status, String message) {
        this.errorMessage = message;
        this.httpStatus = status;
    }
    public ExceptionResponse(ErrorCode code){
        this.errorMessage = code.getMessage();
        this.httpStatus = code.getStatus();
        this.code = code.getCode();
        this.timeStamp = LocalDateTime.now();
    }
}