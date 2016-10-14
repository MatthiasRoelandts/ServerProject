package com.example.controller;

import com.example.entity.OwnerEntity;
import com.example.entity.RestaurantEntity;
import com.example.repository.BusinessRepository;
import com.example.repository.OwnerRepository;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = "/addbusiness",method = RequestMethod.POST)
    public ResponseEntity addBusiness(@RequestBody RestaurantEntity business){
        OwnerEntity owner = ownerRepository.findOne(business.getOwnerId());
        business.setOwner(owner);
        owner.addBusiness(business);
        try {
            businessRepository.save(business);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
