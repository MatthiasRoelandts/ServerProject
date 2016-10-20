package com.example.controller;

import com.example.entity.CustomerEntity;
import com.example.entity.OwnerEntity;
import com.example.entity.UserEntity;
import com.example.entity.WaiterEntity;
import com.example.repository.OwnerRepository;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * Created by matth on 7/10/2016.
 */
@RestController
public class ServiceController {





    private OwnerRepository ownerRepository;
    private UserRepository userRepository;
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public ServiceController(OwnerRepository ownerRepository,UserRepository userRepository) {
        this.ownerRepository = ownerRepository;
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/auth/register/owner", method = RequestMethod.POST)
    public ResponseEntity registerOwner(@RequestBody OwnerEntity owner){



        System.out.println("The incoming user has name " + owner.getName() + "EArner = " + owner.getTotal_earned());
        owner.setPassword(passwordEncoder.encode(owner.getPassword()));
        System.out.println("The encrypted password is " + owner.getPassword());
        try {
            ownerRepository.save(owner);
            return new ResponseEntity(HttpStatus.ACCEPTED);
        } catch(DataIntegrityViolationException e){
            // return 409 response for duplicate email address
            return new ResponseEntity(HttpStatus.CONFLICT);
        } catch (ResourceAccessException e){
            //For any other problem
            return  new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/auth/register/waiter", method = RequestMethod.POST)
    public ResponseEntity registerWaiter(@RequestBody WaiterEntity waiter){


        return ResponseEntity.ok("");
    }

    @RequestMapping(value = "/auth/register/customer", method = RequestMethod.POST)
    public ResponseEntity registerCustomer(@RequestBody CustomerEntity owner){
        return ResponseEntity.ok("");
    }
}
