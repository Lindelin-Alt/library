package com.example.springboot.exception;

public class ServiceException extends RuntimeException {

    private String code;

    public String getCode() {
        return code;
    }


    public ServiceException(String message) {
        super(message);

    }
    public ServiceException(String code,String message) {
        super(message);

    }
}
