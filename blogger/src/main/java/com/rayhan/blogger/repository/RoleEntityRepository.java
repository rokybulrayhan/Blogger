package com.rayhan.blogger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rayhan.blogger.entity.RoleEntity;

public interface RoleEntityRepository extends JpaRepository<RoleEntity, Integer> {

    RoleEntity findByName(String name);
}
