package com.garanti.FirstSpringWeb;

public class BusinessException extends RuntimeException
{
    public BusinessException(String message) {
        super(message);
    }
}
