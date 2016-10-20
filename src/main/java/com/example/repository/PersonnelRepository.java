package com.example.repository;

import com.example.entity.OwnerEntity;
import com.example.entity.WaiterEntity;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by michael on 19/10/2016.
 */
@Transactional
public interface PersonnelRepository extends UserBaseRepository<WaiterEntity>{
}
