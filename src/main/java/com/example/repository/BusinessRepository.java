package com.example.repository;

import com.example.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by michael on 14/10/2016.
 */

@Repository
public interface BusinessRepository extends JpaRepository<RestaurantEntity,Integer> {
}
