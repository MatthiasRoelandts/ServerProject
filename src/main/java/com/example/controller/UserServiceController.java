package com.example.controller;

import com.example.entity.*;
import com.example.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by matth on 7/10/2016.
 */
@RestController
public class UserServiceController {


    private OwnerRepository ownerRepository;
    private UserRepository userRepository;
    private PersonnelRepository personnelRepository;
    private BusinessRepository businessRepository;


    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public UserServiceController(OwnerRepository ownerRepository, UserRepository userRepository, PersonnelRepository personnelRepository, BusinessRepository businessRepository) {
        this.ownerRepository = ownerRepository;
        this.userRepository = userRepository;
        this.personnelRepository = personnelRepository;
        this.businessRepository = businessRepository;

    }

    @RequestMapping(value = "/auth/user/register/owner", method = RequestMethod.POST)
    public ResponseEntity registerOwner(@RequestBody OwnerEntity owner) {


        System.out.println("The incoming user has name " + owner.getName() + "EArner = " + owner.getTotal_earned());
        owner.setPassword(passwordEncoder.encode(owner.getPassword()));
        System.out.println("The encrypted password is " + owner.getPassword());
        try {
            ownerRepository.save(owner);
            return new ResponseEntity(HttpStatus.ACCEPTED);
        } catch (DataIntegrityViolationException e) {
            // return 409 response for duplicate email address
            return new ResponseEntity(HttpStatus.CONFLICT);
        } catch (ResourceAccessException e) {
            //For any other problem
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/user/register/personnel", method = RequestMethod.POST)
    public ResponseEntity registerWaiter(@RequestBody WaiterEntity personnel) {

        RestaurantEntity business = businessRepository.findOne(personnel.getRestaurant_id());
        List<WaiterEntity> pList;
        pList = business.getPersonnel();
        pList.add(personnel);
        business.setPersonnel(pList);

        try {
            personnelRepository.save(personnel);
            return new ResponseEntity(HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }



    @RequestMapping(value = "/auth/register/customer", method = RequestMethod.POST)
    public ResponseEntity registerCustomer(@RequestBody CustomerEntity owner) {


        return ResponseEntity.ok("");
    }


}
