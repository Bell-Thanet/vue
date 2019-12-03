package com.cpe.backend.resume.repository;

import com.cpe.backend.resume.entity.Education;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface EducationRepository extends JpaRepository<Education, Long> {
	Education findById(long id);
}


