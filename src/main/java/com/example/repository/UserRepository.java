package com.example.repository;

import com.example.entity.OwnerEntity;
import com.example.entity.UserEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserRepository extends UserBaseRepository<UserEntity>{

}
