package com.example.repository;

import com.example.entity.ItemcategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Created by matth on 17/10/2016.
 */
@Repository
public interface ItemCategoryRepository extends JpaRepository<ItemcategoryEntity, Integer>{
    ArrayList<ItemcategoryEntity> findByRestaurantId(int id);
}
