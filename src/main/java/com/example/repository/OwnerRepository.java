package com.example.repository;

import com.example.entity.OwnerEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface OwnerRepository extends UserBaseRepository<OwnerEntity>{


}
