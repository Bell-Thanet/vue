package com.cpe.backend.jobpost.repository;

import com.cpe.backend.jobpost.entity.Benefits;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface BenefitsRepository extends JpaRepository<Benefits, Long> {
	Benefits findById(long id);
}