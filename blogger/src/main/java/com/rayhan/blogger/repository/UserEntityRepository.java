package com.rayhan.blogger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rayhan.blogger.entity.UserEntity;

public interface UserEntityRepository extends JpaRepository<UserEntity, Integer> {

    UserEntity findByLogin(String login);
}
