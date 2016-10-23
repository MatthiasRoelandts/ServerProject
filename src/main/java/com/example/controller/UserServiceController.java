package com.example.controller;

import com.example.entity.*;


import com.example.mail.MailService;
import com.example.mail.PersonnelMailObj;
import com.example.repository.*;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.io.IOException;
import java.util.List;
import org.apache.commons.lang.RandomStringUtils;

import javax.mail.internet.AddressException;

/**
 * Created by matth on 7/10/2016.
 */
@RestController
public class UserServiceController {


    private OwnerRepository ownerRepository;
    private UserRepository userRepository;
    private PersonnelRepository personnelRepository;
    private BusinessRepository businessRepository;


    @Autowired
    private MailService mailService;


    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public UserServiceController(OwnerRepository ownerRepository, UserRepository userRepository, PersonnelRepository personnelRepository, BusinessRepository businessRepository) {
        this.ownerRepository = ownerRepository;
        this.userRepository = userRepository;
        this.personnelRepository = personnelRepository;
        this.businessRepository = businessRepository;

    }

    @RequestMapping(value = "/auth/user/owner", method = RequestMethod.POST)
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

    @RequestMapping(value = "/user/personnel", method = RequestMethod.POST)
    public ResponseEntity registerWaiter(@RequestBody WaiterEntity personnel) {

        //generates random alphanumeric password for personnel member to use
        String uncoded_password = RandomStringUtils.randomAlphanumeric(8);
        System.out.println("The password is " + uncoded_password);
        personnel.setPassword(passwordEncoder.encode(uncoded_password));
        RestaurantEntity business = businessRepository.findOne(personnel.getRestaurant_id());
        List<WaiterEntity> pList;
        pList = business.getPersonnel();
        pList.add(personnel);
        business.setPersonnel(pList);
        System.out.println("The name of added is " + personnel.getName());

        //instantiate the mail object
        PersonnelMailObj pmailObj = new PersonnelMailObj(
                personnel.getName(),
                personnel.getLastname(),
                personnel.getEmail(),
                uncoded_password,
                personnel.getJob_description(),
                business.getName()
        );
        try {
            personnelRepository.save(personnel);
            mailService.sendMailToPersonnel(pmailObj);
            return new ResponseEntity(HttpStatus.CREATED);
        } catch (DataIntegrityViolationException e) {
            // return 409 response for duplicate email address
            return new ResponseEntity(HttpStatus.CONFLICT);
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

    }


}
