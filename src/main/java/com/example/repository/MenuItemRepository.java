package com.example.repository;

import com.example.entity.MenuitemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Created by matth on 16/10/2016.
 */
@Repository
public interface MenuItemRepository extends JpaRepository<MenuitemEntity, Integer> {
    ArrayList<MenuitemEntity> findByItemCategoryId(int id);
}
