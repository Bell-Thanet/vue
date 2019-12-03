package com.cpe.backend.registercompany.repository;

import com.cpe.backend.registercompany.entity.Size;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface SizeRepository extends JpaRepository<Size, Long> {
	Size findById(long id);
}