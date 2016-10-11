package com.example.security.exception;


import org.springframework.security.core.AuthenticationException;

/**
 * Created by michael on 6/10/2016.
 */
public class JwtTokenMissingException extends AuthenticationException {


    public JwtTokenMissingException(String msg) {
        super(msg);
    }
}
