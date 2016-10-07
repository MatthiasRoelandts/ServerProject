package com.example.repository;

import com.example.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by matth on 7/10/2016.
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findUserByEmail(String email);
}
