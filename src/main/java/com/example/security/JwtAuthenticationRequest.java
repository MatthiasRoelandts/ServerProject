package com.example.security;

import java.io.Serializable;

/**
 *
 * Holds the username and password when logging in
 * Created by michael on 6/10/2016.
 */
public class JwtAuthenticationRequest implements Serializable {
    private static final long serialVersionUID = -8445943548965154778L;

    private String email;
    private String password;

    //Necessary for @requestbody to work ?
    public JwtAuthenticationRequest() {
        super();
    }

    public JwtAuthenticationRequest(String username, String password) {
        this.setEmail(username);
        this.setPassword(password);
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String username) {
        this.email = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
