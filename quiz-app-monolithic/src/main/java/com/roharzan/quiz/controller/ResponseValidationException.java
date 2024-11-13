package com.roharzan.quiz.controller;

public class ResponseValidationException extends RuntimeException {

    public ResponseValidationException(String message) {
        super(message);
    }
}
