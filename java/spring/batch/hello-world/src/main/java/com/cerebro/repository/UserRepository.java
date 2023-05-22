package com.cerebro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cerebro.model.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

}