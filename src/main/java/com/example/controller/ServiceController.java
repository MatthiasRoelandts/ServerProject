package com.example.controller;

import com.example.entity.*;
import com.example.repository.ItemCategoryRepository;
import com.example.repository.MenuItemRepository;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by matth on 7/10/2016.
 */
@RestController
public class ServiceController {


    private OwnerRepository ownerRepository;
    private UserRepository userRepository;
    private MenuItemRepository menuItemRepository;
    private ItemCategoryRepository itemCategoryRepository;
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public ServiceController(OwnerRepository ownerRepository, UserRepository userRepository, MenuItemRepository menuItemRepository, ItemCategoryRepository itemCategoryRepository) {
        this.ownerRepository = ownerRepository;
        this.userRepository = userRepository;
        this.menuItemRepository = menuItemRepository;
        this.itemCategoryRepository = itemCategoryRepository;
    }

    @RequestMapping(value = "/auth/register/owner", method = RequestMethod.POST)
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

    @RequestMapping(value = "/auth/register/waiter", method = RequestMethod.POST)
    public ResponseEntity registerWaiter(@RequestBody WaiterEntity waiter) {


        return ResponseEntity.ok("");
    }

    @RequestMapping(value = "/auth/register/customer", method = RequestMethod.POST)
    public ResponseEntity registerCustomer(@RequestBody CustomerEntity owner) {


        return ResponseEntity.ok("");
    }

    @RequestMapping(value = "/create/item", method = RequestMethod.POST)
    public ResponseEntity createNewItem(@RequestBody MenuitemEntity item) {

        System.out.println("The incoming item has title " + item.getTitle());
        System.out.println("and description " + item.getDescription());
        System.out.println("and price " + item.getPrice());
        System.out.println("and categoryID : " + item.getItemCategoryId());
        try {
            MenuitemEntity createdItem = menuItemRepository.save(item);
            menuItemRepository.flush();
            System.out.println("created ID = " + createdItem.getId());
            return new ResponseEntity(HttpStatus.ACCEPTED);
        } catch (ResourceAccessException e) {
            //For any other problem
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/create/itemcategory", method = RequestMethod.POST)
    public ResponseEntity<ItemcategoryEntity> createNewItemCategory(@RequestBody ItemcategoryEntity itemCategory) {

        System.out.println("The incoming itemCategory has id " + itemCategory.getId());
        System.out.println("and name " + itemCategory.getName());
        ItemcategoryEntity createdCategory = null;
        try {
            createdCategory = itemCategoryRepository.save(itemCategory);
            itemCategoryRepository.flush();
            System.out.println("created ID = " + createdCategory.getId());
            return new ResponseEntity(createdCategory, HttpStatus.ACCEPTED);
        } catch (ResourceAccessException e) {
            //For any other problem
            return new ResponseEntity(createdCategory, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/ItemCategory/all", method = RequestMethod.GET)
    public ResponseEntity<List<ItemcategoryEntity>> getAllItemCategories() {
        List<ItemcategoryEntity> entityList = itemCategoryRepository.findAll();
        return new ResponseEntity<>(entityList, HttpStatus.OK);
    }

    @RequestMapping(value = "/MenuItem/all", method = RequestMethod.GET)
    public ResponseEntity<List<MenuitemEntity>> getAllMenuItems() {
        List<MenuitemEntity> entityList = menuItemRepository.findAll();
        return new ResponseEntity<>(entityList, HttpStatus.OK);
    }

    @RequestMapping(value = "/MenuItem/category/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<MenuitemEntity>> getMenuItemByCategory(@PathVariable Integer id) {
        List<MenuitemEntity> entityList = menuItemRepository.findByItemCategoryId(id);
        return new ResponseEntity<>(entityList, HttpStatus.OK);
    }

    @RequestMapping(value = "/Menu/all", method = RequestMethod.GET)
    public ResponseEntity<HashMap<ItemcategoryEntity, List<MenuitemEntity>>> getAllMenu() {
        HashMap<ItemcategoryEntity, List<MenuitemEntity>> entityMap = new HashMap<>();
        List<ItemcategoryEntity> categoryList = itemCategoryRepository.findAll();
        for(ItemcategoryEntity category: categoryList) {
            ArrayList<MenuitemEntity> itemList = menuItemRepository.findByItemCategoryId(category.getId());
            entityMap.put(category, itemList);
        }
        return new ResponseEntity<>(entityMap, HttpStatus.OK);
    }
}
