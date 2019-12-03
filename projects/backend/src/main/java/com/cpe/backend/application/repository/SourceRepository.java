package com.cpe.backend.application.repository;

import com.cpe.backend.application.entity.Source;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface SourceRepository extends JpaRepository<Source, Long> {
	Source findById(long id);
}