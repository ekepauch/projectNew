package com.sample.project.exceptions;

public class BadRequestException extends AbstractException {

    public BadRequestException(String code, String message) {
        super(code, message);
    }
}