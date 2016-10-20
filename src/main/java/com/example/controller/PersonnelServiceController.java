package com.example.controller;

import com.example.entity.RestaurantEntity;
import com.example.entity.WaiterEntity;
import com.example.repository.BusinessRepository;
import com.example.repository.PersonnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by michael on 19/10/2016.
 */

@RestController
public class PersonnelServiceController {

    private PersonnelRepository personnelRepository;
    private BusinessRepository businessRepository;

    @Autowired
    public PersonnelServiceController(PersonnelRepository personnelRepository,BusinessRepository businessRepository){
        this.personnelRepository = personnelRepository;
        this.businessRepository = businessRepository;
    }

    @RequestMapping(value = "/addpersonnel",method = RequestMethod.GET)
    public ResponseEntity addPersonnel(@RequestBody WaiterEntity personnel){

        RestaurantEntity business = businessRepository.findOne(personnel.getRestaurant_id());
        List<WaiterEntity> pList;
        pList = business.getPersonnel();
        pList.add(personnel);
        business.setPersonnel(pList);

        try{
            personnelRepository.save(personnel);
            return new ResponseEntity(HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
