package com.cpe.backend.registeruser.repository;

import com.cpe.backend.registeruser.entity.Gender;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface GenderRepository extends JpaRepository<Gender, Long> {
	Gender findById(long id);
}
