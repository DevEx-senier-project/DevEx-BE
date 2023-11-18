package com.DevEx.DevExBE.global.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
public class ExceptionResponse {
    private final String errorMessage;
    private final HttpStatus httpStatus;
    private final String code;
    private final LocalDateTime timeStamp;

    public ExceptionResponse(ErrorCode code){
        this.errorMessage = code.getMessage();
        this.httpStatus = code.getStatus();
        this.code = code.getCode();
        this.timeStamp = LocalDateTime.now();
    }
}