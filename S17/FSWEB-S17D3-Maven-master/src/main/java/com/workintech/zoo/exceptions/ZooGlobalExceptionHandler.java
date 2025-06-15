package com.workintech.zoo.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Slf4j
public class ZooGlobalExceptionHandler {

    @ExceptionHandler(ZooException.class)
    public ResponseEntity<ZooErrorResponse> handleException(ZooException zooException){
        log.error("ZooException: {}", zooException.getMessage(), zooException);

        ZooErrorResponse zooErrorResponse = new ZooErrorResponse(

                zooException.getHttpStatus().value(),
                zooException.getMessage(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(zooErrorResponse, zooException.getHttpStatus());

    }

    @ExceptionHandler
    public ResponseEntity<ZooErrorResponse> handleException(Exception exception) {

        log.error("Unhandled exception: {}", exception.getMessage(), exception);

        ZooErrorResponse zooErrorResponse = new ZooErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                exception.getMessage(),

                System.currentTimeMillis()
        );
        return new ResponseEntity<>(zooErrorResponse, HttpStatus.BAD_REQUEST);
    }
}
