package com.example.security.model;

import com.example.entity.UserEntity;

/**
 * Created by michael on 6/10/2016.
 */
public class AuthenticatedUserFactory {

    public static AuthenticatedUser create(UserEntity user){

        return new AuthenticatedUser(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                user.getEmail()
        );
    }
}
