package com.iis.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iis.apirest.entity.TPerson;

public interface PersonRepository extends JpaRepository<TPerson, String> { }
