package com.example.controller;

import com.example.entity.ItemcategoryEntity;
import com.example.entity.MenuitemEntity;
import com.example.repository.ItemCategoryRepository;
import com.example.repository.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by michael on 20/10/2016.
 */
@RestController
public class MenuServiceController {


    private MenuItemRepository menuItemRepository;
    private ItemCategoryRepository itemCategoryRepository;

    @Autowired
    public MenuServiceController(MenuItemRepository menuItemRepository, ItemCategoryRepository itemCategoryRepository) {
        this.menuItemRepository = menuItemRepository;
        this.itemCategoryRepository = itemCategoryRepository;
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

    @RequestMapping(value = "/ItemCategory/all/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<ItemcategoryEntity>> getAllItemCategories(@PathVariable Integer id) {
        List<ItemcategoryEntity> entityList = itemCategoryRepository.findByRestaurantId(id);
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
        for (ItemcategoryEntity category : categoryList) {
            ArrayList<MenuitemEntity> itemList = menuItemRepository.findByItemCategoryId(category.getId());
            entityMap.put(category, itemList);
        }
        return new ResponseEntity<>(entityMap, HttpStatus.OK);
    }
}
