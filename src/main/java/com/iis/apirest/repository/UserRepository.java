package com.iis.apirest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iis.apirest.entity.TUser;

public interface UserRepository extends JpaRepository<TUser, String> {
    Optional<TUser> findByNameUser(String nameUser);
}
