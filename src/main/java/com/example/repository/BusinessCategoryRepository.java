package com.example.repository;

import com.example.entity.CategoryrestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by michael on 24/10/2016.
 */
public interface BusinessCategoryRepository extends JpaRepository<CategoryrestaurantEntity,Integer> {
}
