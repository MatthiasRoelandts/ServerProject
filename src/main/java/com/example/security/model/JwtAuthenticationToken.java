package com.example.security.model;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

/**
 * Created by michael on 5/10/2016.
 * * Holder for JWT token from the request.
 *
 * Other fields aren't used but necessary to comply to the contracts of AbstractUserDetailsAuthenticationProvider
 */
public class JwtAuthenticationToken extends UsernamePasswordAuthenticationToken {
    private String token;

    public JwtAuthenticationToken(String token){
        //(principal,credentials)
        super(null,null);
        this.token = token;
    }

    public String getToken(){
        return token;
    }

    @Override
    public Object getCredentials(){
        return null;
    }

    @Override
    public Object getPrincipal(){
        return null;
    }

}
