package com.amber.random.datapoliceuk.exception;

public class ResponseException extends Exception {
    private static final String SUCCEED = "200";//status code
    private static final String TOO_MANY_REQUESTS = "429";
}
