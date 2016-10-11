package com.example.security.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 *
 *  Holds the info for an authenticated user
 * Created by michael on 5/10/2016.
 */
public class AuthenticatedUser implements UserDetails {
    private final int id;
    private final String username;
    private final String password;
    private final String email;
    //private final Collection<? extends GrantedAuthority> authorities;

    // in constructor ->// Collection<? extends GrantedAuthority> authorities

    public AuthenticatedUser(int id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        //this.authorities = authorities;
    }


    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }


    @JsonIgnore
    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

}
