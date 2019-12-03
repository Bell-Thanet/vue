package com.cpe.backend.registercompany.repository;

import com.cpe.backend.registercompany.entity.Type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface TypeRepository extends JpaRepository<Type, Long> {
	Type findById(long id);
}