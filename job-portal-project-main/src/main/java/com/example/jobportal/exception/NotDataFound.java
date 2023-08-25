package com.example.jobportal.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NotDataFound extends RuntimeException {
    public NotDataFound(String msg) {
        super(msg);
    }
}
