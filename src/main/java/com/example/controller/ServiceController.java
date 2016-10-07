package com.example.controller;

import com.example.entity.UserEntity;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by matth on 7/10/2016.
 */
@RestController
public class ServiceController {
    private UserRepository userRepository;

    @Autowired
    public ServiceController( UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    @ResponseBody
    public void registerUser(@RequestBody UserEntity user ) {
        if(userRepository.findUserByEmail(user.getEmail()) == null) {
            userRepository.save(user);
        }
    }
}
