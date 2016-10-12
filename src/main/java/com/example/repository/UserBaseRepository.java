package com.example.repository;

import com.example.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

/**
 * Created by matth on 7/10/2016.
 */
@NoRepositoryBean
public interface UserBaseRepository<T extends UserEntity> extends JpaRepository<T, Integer> {

    T findUserByEmail(String email);
}
