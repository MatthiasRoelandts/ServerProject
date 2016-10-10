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
    public ServiceController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    @ResponseBody
    public void registerUser(@RequestBody UserEntity user ) {
        //check if user already exists
        System.out.println("hey sexy\n");
        System.out.println("jij bent:" + user.getName());
        System.out.println("jij bent:" + user.getLastname());
        System.out.println("jij bent:" + user.getEmail());
        System.out.println("jij bent:" + user.getPassword());
        userRepository.save(user);
    }
}
