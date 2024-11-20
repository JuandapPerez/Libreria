package com.proyectosjuan.libreria.persistence.repository;

import com.proyectosjuan.libreria.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findByUsername(String username);
}
