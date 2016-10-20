package com.example.controller;

import com.example.entity.OwnerEntity;
import com.example.entity.RestaurantEntity;
import com.example.repository.BusinessRepository;
import com.example.repository.OwnerRepository;
import com.example.repository.UserRepository;
import com.example.security.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by michael on 14/10/2016.
 */

@RestController
public class BusinessServiceController {

    private OwnerRepository ownerRepository;
    private BusinessRepository businessRepository;

    @Autowired
    public BusinessServiceController(OwnerRepository ownerRepository, BusinessRepository businessRepository) {
        this.ownerRepository = ownerRepository;
        this.businessRepository = businessRepository;
    }

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @RequestMapping(value = "/addbusiness",method = RequestMethod.POST)
    public ResponseEntity<RestaurantEntity> addBusiness(@RequestBody RestaurantEntity business){

        System.out.println("The owner email is" + business.getOwnerEmail());
        String ownerEmail = business.getOwnerEmail();
        OwnerEntity owner = ownerRepository.findUserByEmail(ownerEmail);
        business.setOwnerId(owner.getId());
        business.setCategoryRestaurantId(1);
        List<RestaurantEntity> rList;
        rList = owner.getBusinesses();
        rList.add(business);
        owner.setBusinesses(rList);

        try {
            businessRepository.save(business);
            businessRepository.flush();
            return new ResponseEntity(business,HttpStatus.CREATED);

        } catch (RestClientException e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
    /*
    * Get's the businesses for a particular owner*/
    @RequestMapping(value = "/getbusinesses",method = RequestMethod.GET)
    public ResponseEntity getBusinesses(@RequestHeader(value = "Authorization") String token){

        List<RestaurantEntity> businessesList = null;
        try {
            OwnerEntity owner = ownerRepository.findUserByEmail(jwtTokenUtil.getUsernameFromToken(token));
            businessesList = owner.getBusinesses();
            return new ResponseEntity(businessesList,HttpStatus.ACCEPTED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(null,HttpStatus.BAD_REQUEST);
        }
    }
}
