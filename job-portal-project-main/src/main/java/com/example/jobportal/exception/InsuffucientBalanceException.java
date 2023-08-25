package com.example.jobportal.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InsuffucientBalanceException extends RuntimeException {
    public InsuffucientBalanceException(String msg) {
        super(msg);
    }
}
