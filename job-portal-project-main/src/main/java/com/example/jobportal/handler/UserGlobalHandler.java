package com.example.jobportal.handler;


import com.example.jobportal.dto.ErrorDetails;
import com.example.jobportal.exception.InsuffucientBalanceException;
import com.example.jobportal.exception.NotDataFound;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@Slf4j
@RestControllerAdvice
public class UserGlobalHandler {

    @ExceptionHandler(NotDataFound.class)
    public ResponseEntity<ErrorDetails> userNotFound(NotDataFound ex, WebRequest webRequest) {
        ErrorDetails errorDetails = ErrorDetails.builder().timestamp(new Date()).status(HttpStatus.NOT_FOUND.value()).error(HttpStatus.NOT_FOUND.getReasonPhrase()).message(ex.getMessage()).errorDetail(ex.getMessage()).path(webRequest.getDescription(false)).build();
        return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InsuffucientBalanceException.class)
    public ResponseEntity<ErrorDetails> balanceNotEnough(InsuffucientBalanceException ex, WebRequest webRequest) {
        ErrorDetails errorDetails = ErrorDetails.builder().timestamp(new Date()).status(HttpStatus.BAD_REQUEST.value()).error(HttpStatus.BAD_REQUEST.getReasonPhrase()).message(ex.getMessage()).errorDetail(ex.getMessage()).path(webRequest.getDescription(false)).build();
        return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<?> userValidationErrorHandling(ConstraintViolationException ex, WebRequest webRequest) {
        ErrorDetails errorDetails = ErrorDetails.builder().timestamp(new Date()).status(HttpStatus.BAD_REQUEST.value()).error(HttpStatus.BAD_REQUEST.getReasonPhrase()).message("Validation Error").errorDetail(ex.getMessage()).path(webRequest.getDescription(false)).build();
        return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDetails> userNull(MethodArgumentNotValidException ex, WebRequest webRequest) {
        System.out.println("RuntimeException");
        ErrorDetails errorDetails = ErrorDetails.builder()
                .timestamp(new Date())
                .status(HttpStatus.BAD_REQUEST.value())
                .error(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .message(ex.getBindingResult().getFieldError().getField() + " is required ")
                .errorDetail(ex.getMessage())
                .path(webRequest.getDescription(false))
                .build();
        return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorDetails> userNull(RuntimeException ex, WebRequest webRequest) {
        System.out.println("RuntimeException");
        ErrorDetails errorDetails = ErrorDetails.builder().timestamp(new Date()).status(HttpStatus.BAD_REQUEST.value()).error(HttpStatus.BAD_REQUEST.getReasonPhrase()).message(ex.getMessage()).errorDetail(ex.getMessage()).path(webRequest.getDescription(false)).build();
        return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> userException(Exception ex, WebRequest webRequest) {
        System.out.println("Exception");
        ErrorDetails errorDetails = ErrorDetails.builder().timestamp(new Date()).status(HttpStatus.BAD_REQUEST.value()).error(HttpStatus.BAD_REQUEST.getReasonPhrase()).message(ex.getMessage()).errorDetail(ex.getMessage()).path(webRequest.getDescription(false)).build();
        return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
    }
}
