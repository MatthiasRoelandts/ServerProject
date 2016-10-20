package com.example.security.service;

import com.example.entity.UserEntity;
import com.example.repository.UserRepository;
import com.example.security.model.AuthenticatedUserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by michael on 6/10/2016.
 */

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    //We use email as the unique indentifier for the user
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        UserEntity user = this.userRepository.findUserByEmail(email);

        //When the user is found in the database -> create a new authenticated user
        if(user == null){
            throw new UsernameNotFoundException(String.format("No user is found with email '%s'.",email));
        }else{
            return AuthenticatedUserFactory.create(user);
        }

    }
}
